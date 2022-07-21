package br.com.curso.medical.patient.controller;

import br.com.curso.medical.patient.commands.DeletePatientCommand;
import br.com.curso.medical.patient.services.command.PatientCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-19, Tuesday
 */
@RestController
@RequestMapping("/v1/patients")
@RequiredArgsConstructor
public class DeletePatientController {

    private final PatientCommandService service;

    @DeleteMapping("/{patientId}")
    public ResponseEntity<?> delete(@PathVariable String patientId) {
        this.service.delete(new DeletePatientCommand(patientId));
        return ResponseEntity.ok().build();
    }
}
