package br.com.curso.medical.doctor.services.query;

import br.com.curso.medical.doctor.entities.Doctor;
import br.com.curso.medical.doctor.queries.FindAllQuery;
import br.com.curso.medical.doctor.queries.FindByDoctorIdQuery;
import br.com.curso.medical.doctor.queries.FindByUsernameQuery;

import java.util.List;
import java.util.Optional;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-21, Thursday
 */
public interface DoctorQueryService {

    Optional<Doctor> findByUsername(FindByUsernameQuery query);

    Optional<Doctor> findById(FindByDoctorIdQuery query);

    List<Doctor> findAll(FindAllQuery query);
}
