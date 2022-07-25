package br.com.curso.medical.patient.services.query;

import br.com.curso.medical.patient.entities.Patient;
import br.com.curso.medical.patient.queries.FindAllQuery;
import br.com.curso.medical.patient.queries.FindByPatientIdQuery;
import br.com.curso.medical.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-20, Wednesday
 */
@Service
@RequiredArgsConstructor
public class PatientQueryServiceImpl implements PatientQueryService {
    private final PatientRepository repository;

    @Cacheable(cacheNames = Patient.CACHE_NAME, key = "#query.getPatientId()")
    @Override
    public Optional<Patient> findById(FindByPatientIdQuery query) {
        return this.repository.findById(query.getPatientId());
    }

    @Cacheable(cacheNames = Patient.CACHE_NAME, key = "#root.method.name")
    @Override
    public List<Patient> findAll(FindAllQuery query) {
        return this.repository.findAll();
    }


}
