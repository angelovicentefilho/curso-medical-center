package br.com.curso.medical.scheduling.cache;

import br.com.curso.medical.scheduling.protocols.DoctorResponse;
import br.com.curso.medical.scheduling.protocols.PatientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import static java.util.Objects.requireNonNull;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-25, Monday
 */
@Component
@RequiredArgsConstructor
public class PatientCache {

    private final CacheManager cacheManager;

    public void add(PatientResponse response) {
        requireNonNull(cacheManager.getCache("PATIENT_RESPONSE")).put(response.getPatientId(), response);
    }

    public PatientResponse get(String patientId) {
        return (PatientResponse) requireNonNull(cacheManager.getCache("PATIENT_RESPONSE")).get(patientId).get();
    }
}
