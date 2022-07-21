package br.com.curso.medical.scheduling.webclient;

import br.com.curso.medical.scheduling.protocols.PatientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * WebClient to get a PatientResponse for Scheduling.
 *
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-19, Tuesday
 */
@FeignClient(name = "patients-service", path = "/v1/patients")
public interface PatientWebClient {

    /**
     * FeignClient for to get a Patient by ID.
     * @param patientId PatientID for search.
     * @return A PatientResponse from patients-service.
     */
    @GetMapping("/{patientId}")
    PatientResponse findByPatientId(@PathVariable String patientId);
}
