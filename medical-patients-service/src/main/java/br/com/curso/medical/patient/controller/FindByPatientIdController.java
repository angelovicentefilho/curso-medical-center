package br.com.curso.medical.patient.controller;

import br.com.curso.medical.patient.codec.Codec;
import br.com.curso.medical.patient.protocols.PatientResponse;
import br.com.curso.medical.patient.queries.FindByPatientIdQuery;
import br.com.curso.medical.patient.services.query.PatientQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-19, Tuesday
 */
@RestController
@RequestMapping(value = "/v1/patients", produces = {"application/json", "application/hal+json"})
@RequiredArgsConstructor
public class FindByPatientIdController {

    private final PatientQueryService service;

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientResponse> findById(@PathVariable String patientId) {
        return service.findById(new FindByPatientIdQuery(patientId))
                .map(Codec::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
