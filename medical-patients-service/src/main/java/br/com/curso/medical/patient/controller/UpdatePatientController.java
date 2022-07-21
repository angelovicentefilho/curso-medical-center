package br.com.curso.medical.patient.controller;

import br.com.curso.medical.patient.codec.Codec;
import br.com.curso.medical.patient.protocols.PatientRequest;
import br.com.curso.medical.patient.protocols.PatientResponse;
import br.com.curso.medical.patient.services.command.PatientCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-19, Tuesday
 */
@RestController
@RequestMapping("/v1/patients")
@RequiredArgsConstructor
public class UpdatePatientController {

    private final PatientCommandService service;

    @PutMapping("/{patientId}")
    public ResponseEntity<PatientResponse> update(@PathVariable String patientId, @RequestBody PatientRequest request) {
        request.setPatientId(patientId);
        return service.update(Codec.toUpdateCommand(request))
                .map(Codec::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
