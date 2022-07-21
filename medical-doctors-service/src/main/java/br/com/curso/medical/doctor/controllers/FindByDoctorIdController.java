package br.com.curso.medical.doctor.controllers;

import br.com.curso.medical.doctor.codec.Codec;
import br.com.curso.medical.doctor.protocols.DoctorResponse;
import br.com.curso.medical.doctor.queries.FindByDoctorIdQuery;
import br.com.curso.medical.doctor.services.query.DoctorQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import static org.springframework.http.ResponseEntity.ok;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-20, Wednesday
 */
@Slf4j
@RestController
@RequestMapping(value = "/v1/doctors", produces = {"application/json", "application/hal+json"})
@RequiredArgsConstructor
public class FindByDoctorIdController {
    private final DoctorQueryService service;

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<DoctorResponse> findByDoctorId(@PathVariable String doctorId) {
        return this.service.findById(new FindByDoctorIdQuery(doctorId))
                .map(Codec::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
