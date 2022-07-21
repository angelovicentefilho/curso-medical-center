package br.com.curso.medical.scheduling.controller;

import br.com.curso.medical.scheduling.codec.Codec;
import br.com.curso.medical.scheduling.protocols.SchedulingResponse;
import br.com.curso.medical.scheduling.queries.FindByPatientIdQuery;
import br.com.curso.medical.scheduling.service.query.SchedulingQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-19, Tuesday
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/schedulers", produces = {"application/json", "application/hal+json"})
public class FindByPatientIdController {

    private final SchedulingQueryService service;

    @GetMapping("/patient/{patientId}")
    public SchedulingResponse findByPatientId(@PathVariable String patientId) {
        return Codec.toResponse(this.service.findByPatientId(new FindByPatientIdQuery(patientId)));
    }
}
