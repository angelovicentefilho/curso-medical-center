package br.com.curso.medical.patient.repository;

import br.com.curso.medical.patient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-04, Monday
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
}
