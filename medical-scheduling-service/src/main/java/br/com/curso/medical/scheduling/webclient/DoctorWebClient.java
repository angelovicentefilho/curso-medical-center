package br.com.curso.medical.scheduling.webclient;

import br.com.curso.medical.scheduling.protocols.DoctorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-19, Tuesday
 */
@FeignClient(name = "doctors-service", path = "/v1/doctors")
public interface DoctorWebClient {

    @GetMapping("/doctor/{doctorId}")
    DoctorResponse findByDoctorId(@PathVariable String doctorId);

}
