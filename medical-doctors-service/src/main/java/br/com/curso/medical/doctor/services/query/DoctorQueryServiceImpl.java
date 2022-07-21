package br.com.curso.medical.doctor.services.query;

import br.com.curso.medical.doctor.entities.Doctor;
import br.com.curso.medical.doctor.queries.FindAllQuery;
import br.com.curso.medical.doctor.queries.FindByDoctorIdQuery;
import br.com.curso.medical.doctor.queries.FindByUsernameQuery;
import br.com.curso.medical.doctor.repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-21, Thursday
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DoctorQueryServiceImpl implements DoctorQueryService {
    private final DoctorRepository repository;

    @Override
    public Optional<Doctor> findByUsername(FindByUsernameQuery query) {
        return Optional.of(this.repository.findByUsername(query.getUsername()));
    }

    @Override
    public Optional<Doctor> findById(FindByDoctorIdQuery query) {
        return this.repository.findById(query.getDoctorId());
    }

    @Override
    public List<Doctor> findAll(FindAllQuery query) {
        return this.repository.findAll();
    }
}
