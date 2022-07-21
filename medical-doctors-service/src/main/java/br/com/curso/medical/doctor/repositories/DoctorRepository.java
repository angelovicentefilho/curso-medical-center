package br.com.curso.medical.doctor.repositories;


import br.com.curso.medical.doctor.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-06-30, Thursday
 */
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {

    Doctor findByUsernameAndPassword(String username, String password);

    Doctor findByUsername(String username);

    Boolean existsDoctorByUsername(String username);

}
