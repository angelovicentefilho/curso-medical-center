package br.com.curso.medical.scheduling.repository;

import br.com.curso.medical.scheduling.entities.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-04, Monday
 */
@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, String> {

    @Query("SELECT s FROM Scheduling s WHERE function('date_format', s.date, '%y-%m-%d') = function('date_format', current_timestamp , '%y-%m-%d') AND s.doctorId = :doctorId")
    Set<Scheduling> findByDoctorId(@Param("doctorId") String doctorId);

    @Query("SELECT s FROM Scheduling s WHERE function('date_format', s.date, '%y-%m-%d') = function('date_format', current_timestamp , '%y-%m-%d') AND s.patientId = :patientId")
    Set<Scheduling> findByPatientId(String patientId);
}
