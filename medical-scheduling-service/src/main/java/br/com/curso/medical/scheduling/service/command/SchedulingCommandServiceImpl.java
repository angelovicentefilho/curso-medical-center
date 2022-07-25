package br.com.curso.medical.scheduling.service.command;

import br.com.curso.medical.commons.dates.Dates;
import br.com.curso.medical.commons.id.GenId;
import br.com.curso.medical.scheduling.cache.DoctorCache;
import br.com.curso.medical.scheduling.cache.PatientCache;
import br.com.curso.medical.scheduling.entities.Scheduling;
import br.com.curso.medical.scheduling.protocols.DoctorResponse;
import br.com.curso.medical.scheduling.protocols.PatientResponse;
import br.com.curso.medical.scheduling.repository.SchedulingRepository;
import br.com.curso.medical.scheduling.webclient.DoctorWebClient;
import br.com.curso.medical.scheduling.webclient.PatientWebClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import static br.com.curso.medical.scheduling.entities.Scheduling.CACHE_NAME;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-20, Wednesday
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SchedulingCommandServiceImpl implements SchedulingCommandService {

    private final SchedulingRepository repository;
    private final DoctorWebClient doctorWebClient;
    private final PatientWebClient patientWebClient;
    private final DoctorCache doctorCache;
    private final PatientCache patientCache;

    @CacheEvict(cacheNames = CACHE_NAME, allEntries = true)
    @Override
    @CircuitBreaker(name = "toSchedule", fallbackMethod = "toScheduleFallback")
    public Scheduling toSchedule(final Scheduling scheduling) {
        log.info(">>> Scheduling patient '{}' for doctor '{}' at: '{}'", scheduling.getPatientId(), scheduling.getDoctorId(), Dates.format(scheduling.getDate()));
        scheduling.setScheduleId(GenId.id());
        DoctorResponse doctor = doctor(scheduling);
        PatientResponse patient = patient(scheduling);
        if (hasDoctor(doctor) && hasPatient(patient)) {
            log.info("<<< Schedule!");
            return this.repository.save(scheduling);
        }
        throw new IllegalStateException("Error to create Scheduling!");
    }

    public Scheduling toScheduleFallback(final Scheduling scheduling, Throwable e) {
        log.info(">>> Scheduling patient '{}' for doctor '{}' at: '{}'", scheduling.getPatientId(), scheduling.getDoctorId(), Dates.format(scheduling.getDate()));
        scheduling.setScheduleId(GenId.id());
        DoctorResponse doctor = doctorCache.get(scheduling.getDoctorId());
        PatientResponse patient = patientCache.get(scheduling.getPatientId());
        if (hasDoctor(doctor) && hasPatient(patient)) {
            log.info("<<< Schedule!");
            return this.repository.save(scheduling);
        }
        throw new IllegalStateException("Error to create Scheduling!");
    }

    private PatientResponse patient(Scheduling scheduling) {
        log.info("::: Search by patient on patients-service :::");
        var patient =  patientWebClient.findByPatientId(scheduling.getPatientId());
        if (patient != null) {
            log.info(">>> Add patient to cache!");
            patientCache.add(patient);
        }
        return patient;
    }

    private DoctorResponse doctor(Scheduling scheduling) {
        log.info("::: Search by doctor on doctors-service :::");
        var doc = doctorWebClient.findByDoctorId(scheduling.getDoctorId());
        if (doc != null) {
            log.info(">>> Add doc to cache!");
            doctorCache.add(doc);
        }
        return doc;
    }

    private boolean hasPatient(PatientResponse patient) {
        return patient != null;
    }

    private boolean hasDoctor(DoctorResponse doctor) {
        return doctor != null;
    }

}
