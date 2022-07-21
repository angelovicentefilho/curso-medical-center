package br.com.curso.medical.doctor.services.query;

import br.com.curso.medical.doctor.entities.Role;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-21, Thursday
 */
public interface RoleQueryService {
    Role findByName(String name);
}
