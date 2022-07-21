package br.com.curso.medical.doctor.controllers;

import br.com.curso.medical.doctor.codec.Codec;
import br.com.curso.medical.doctor.protocols.DoctorRequest;
import br.com.curso.medical.doctor.protocols.DoctorResponse;
import br.com.curso.medical.doctor.services.command.DoctorCommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-20, Wednesday
 */
@Slf4j
@RestController
@RequestMapping("/v1/doctors")
@RequiredArgsConstructor
public class UpdateController {
    private final DoctorCommandService service;


    @PutMapping("/{doctorId}")
    public ResponseEntity<DoctorResponse> update(@PathVariable String doctorId, @RequestBody DoctorRequest request) {
        request.setDoctorId(doctorId);
        return service.update(Codec.toUpdateCommand(request))
                .map(Codec::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
