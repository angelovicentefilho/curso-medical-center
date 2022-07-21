package br.com.curso.medical.patient.controller;

import br.com.curso.medical.patient.codec.Codec;
import br.com.curso.medical.patient.protocols.PatientRequest;
import br.com.curso.medical.patient.protocols.PatientResponse;
import br.com.curso.medical.patient.services.command.PatientCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromController;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-19, Tuesday
 */
@RestController
@RequestMapping(value = "/v1/patients", produces = {"application/hal+json", "application/json"})
@RequiredArgsConstructor
public class CreatePatientController {

    private final PatientCommandService service;

    private static ResponseEntity<PatientResponse> created(PatientResponse response) {
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<PatientResponse> save(@RequestBody PatientRequest request) {
        return service.save(Codec.toCreateCommand(request))
                .map(Codec::toResponse)
                .map(CreatePatientController::created)
                .orElse(ResponseEntity.notFound().build());
    }

}
