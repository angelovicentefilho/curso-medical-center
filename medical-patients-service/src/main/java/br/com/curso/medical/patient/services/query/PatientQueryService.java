package br.com.curso.medical.patient.services.query;

import br.com.curso.medical.patient.entities.Patient;
import br.com.curso.medical.patient.queries.FindAllQuery;
import br.com.curso.medical.patient.queries.FindByPatientIdQuery;

import java.util.List;
import java.util.Optional;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-20, Wednesday
 */
public interface PatientQueryService {

    Optional<Patient> findById(FindByPatientIdQuery query);

    List<Patient> findAll(FindAllQuery query);
}
