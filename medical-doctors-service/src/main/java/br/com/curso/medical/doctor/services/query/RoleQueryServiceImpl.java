package br.com.curso.medical.doctor.services.query;

import br.com.curso.medical.doctor.entities.Role;
import br.com.curso.medical.doctor.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-21, Thursday
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class RoleQueryServiceImpl implements RoleQueryService {
    private final RoleRepository repository;

    @Override
    public Role findByName(String name) {
        return this.repository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Role not found!"));
    }
}
