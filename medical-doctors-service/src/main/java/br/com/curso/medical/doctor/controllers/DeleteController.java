package br.com.curso.medical.doctor.controllers;

import br.com.curso.medical.doctor.commands.DeleteDoctorCommand;
import br.com.curso.medical.doctor.services.command.DoctorCommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class DeleteController {
    private final DoctorCommandService service;

    @DeleteMapping("/{doctorId}")
    public ResponseEntity<Void> delete(@PathVariable String doctorId) {
        this.service.delete(new DeleteDoctorCommand(doctorId));
        return ResponseEntity.noContent().build();
    }
}
