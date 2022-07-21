package br.com.curso.medical.patient.controller;

import br.com.curso.medical.patient.codec.Codec;
import br.com.curso.medical.patient.protocols.PatientResponse;
import br.com.curso.medical.patient.queries.FindAllQuery;
import br.com.curso.medical.patient.services.query.PatientQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-19, Tuesday
 */
@RestController
@RequestMapping(value = "/v1/patients", produces = {"application/json", "application/hal+json"})
@RequiredArgsConstructor
public class FindAllController {

    private final PatientQueryService service;

    @GetMapping
    public ResponseEntity<PatientResponse> findAll() {
        return ResponseEntity.ok(Codec.toResponse(service.findAll(new FindAllQuery())));
    }
}
