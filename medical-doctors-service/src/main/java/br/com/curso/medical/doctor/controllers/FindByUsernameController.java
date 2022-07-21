package br.com.curso.medical.doctor.controllers;

import br.com.curso.medical.doctor.codec.Codec;
import br.com.curso.medical.doctor.protocols.DoctorResponse;
import br.com.curso.medical.doctor.queries.FindByUsernameQuery;
import br.com.curso.medical.doctor.services.query.DoctorQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-20, Wednesday
 */
@Slf4j
@RestController
@RequestMapping("/v1/doctors")
@RequiredArgsConstructor
public class FindByUsernameController {
    private final DoctorQueryService service;

    @GetMapping("/{username}")
    public ResponseEntity<DoctorResponse> findByUsername(@PathVariable String username) {
        return this.service.findByUsername(new FindByUsernameQuery(username))
                .map(Codec::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
