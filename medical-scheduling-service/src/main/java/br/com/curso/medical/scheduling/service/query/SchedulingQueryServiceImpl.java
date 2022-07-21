package br.com.curso.medical.scheduling.service.query;

import br.com.curso.medical.scheduling.entities.Scheduling;
import br.com.curso.medical.scheduling.queries.FindAllQuery;
import br.com.curso.medical.scheduling.queries.FindByDoctorIdQuery;
import br.com.curso.medical.scheduling.queries.FindByPatientIdQuery;
import br.com.curso.medical.scheduling.repository.SchedulingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-20, Wednesday
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SchedulingQueryServiceImpl implements SchedulingQueryService {

    private final SchedulingRepository repository;

    @Override
    public Set<Scheduling> findByDoctorId(FindByDoctorIdQuery query) {
        log.info(">>> find schedule for doctor: '{}'", query.getDoctorId());
        var doctor = this.repository.findByDoctorId(query.getDoctorId());
        log.info("<<< schedule found!");
        return doctor;
    }

    @Override
    public Set<Scheduling> findByPatientId(FindByPatientIdQuery query) {
        log.info(">>> find schedule for patient: '{}'", query.getPatientId());
        var patient = this.repository.findByPatientId(query.getPatientId());
        log.info("<<< schedule found!");
        return patient;
    }

    @Override
    public Set<Scheduling> findAll(FindAllQuery query) {
        log.info(">>> find all schedulers");
        var schedulers = new HashSet<>(this.repository.findAll());
        log.info("<<< schedules found!");
        return schedulers;
    }
}
