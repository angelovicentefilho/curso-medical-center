package br.com.curso.medical.scheduling.service.query;

import br.com.curso.medical.scheduling.entities.Scheduling;
import br.com.curso.medical.scheduling.queries.FindAllQuery;
import br.com.curso.medical.scheduling.queries.FindByDoctorIdQuery;
import br.com.curso.medical.scheduling.queries.FindByPatientIdQuery;

import java.util.Set;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-20, Wednesday
 */
public interface SchedulingQueryService {
    Set<Scheduling> findByDoctorId(FindByDoctorIdQuery query);

    Set<Scheduling> findByPatientId(FindByPatientIdQuery query);

    Set<Scheduling> findAll(FindAllQuery query);
}
