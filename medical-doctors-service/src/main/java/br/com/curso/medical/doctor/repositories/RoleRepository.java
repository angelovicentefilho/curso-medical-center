package br.com.curso.medical.doctor.repositories;

import br.com.curso.medical.doctor.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-08, Friday
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByName(String name);
}
