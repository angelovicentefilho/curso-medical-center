package br.com.curso.medical.scheduling.service.command;

import br.com.curso.medical.commons.dates.Dates;
import br.com.curso.medical.commons.id.GenId;
import br.com.curso.medical.scheduling.entities.Scheduling;
import br.com.curso.medical.scheduling.protocols.DoctorResponse;
import br.com.curso.medical.scheduling.protocols.PatientResponse;
import br.com.curso.medical.scheduling.repository.SchedulingRepository;
import br.com.curso.medical.scheduling.webclient.DoctorWebClient;
import br.com.curso.medical.scheduling.webclient.PatientWebClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

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

    @CacheEvict(cacheNames = Scheduling.CACHE_NAME, allEntries = true)
    @Override
    public Scheduling toSchedule(final Scheduling scheduling) {
        log.info(">>> Scheduling patient '{}' for doctor '{}' at: '{}'", scheduling.getPatientId(), scheduling.getDoctorId(), Dates.format(scheduling.getDate()));
        scheduling.setScheduleId(GenId.id());
        log.info("::: Search by doctor on doctors-service :::");
        DoctorResponse doctor = doctorWebClient.findByDoctorId(scheduling.getDoctorId());
        log.info("::: Search by patient on patients-service :::");
        PatientResponse patient = patientWebClient.findByPatientId(scheduling.getPatientId());
        if (hasDoctor(doctor) && hasPatient(patient)) {
            log.info("<<< Schedule!");
            return this.repository.save(scheduling);
        }
        throw new IllegalStateException("Error to create Scheduling!");
    }

    private boolean hasPatient(PatientResponse patient) {
        return patient != null;
    }

    private boolean hasDoctor(DoctorResponse doctor) {
        return doctor != null;
    }

}
