package br.com.curso.medical.doctor.controllers;

import br.com.curso.medical.doctor.codec.Codec;
import br.com.curso.medical.doctor.protocols.DoctorRequest;
import br.com.curso.medical.doctor.protocols.DoctorResponse;
import br.com.curso.medical.doctor.services.command.DoctorCommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-20, Wednesday
 */
@Slf4j
@RestController
@RequestMapping(value = "/v1/doctors", produces = {"application/json", "application/hal+json"})
@RequiredArgsConstructor
public class CreateController {
    private final DoctorCommandService service;

    private static ResponseEntity<DoctorResponse> created(DoctorResponse response) {
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<DoctorResponse> save(@RequestBody DoctorRequest request) {
        return service.save(Codec.toCreateCommand(request))
                .map(Codec::toResponse)
                .map(CreateController::created)
                .orElse(ResponseEntity.notFound().build());
    }


}
