package br.com.curso.medical.scheduling.cache;

import br.com.curso.medical.scheduling.protocols.DoctorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-25, Monday
 */
@Component
@RequiredArgsConstructor
public class DoctorCache {

    private final CacheManager cacheManager;

    public void add(DoctorResponse response) {
        requireNonNull(cacheManager.getCache("DOCTOR_RESPONSE")).put(response.getDoctorId(), response);
    }

    public DoctorResponse get(String doctorId) {
        return (DoctorResponse) requireNonNull(requireNonNull(cacheManager.getCache("DOCTOR_RESPONSE")).get(doctorId)).get();
    }

}
