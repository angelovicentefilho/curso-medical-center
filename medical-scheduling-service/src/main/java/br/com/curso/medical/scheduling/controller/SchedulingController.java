package br.com.curso.medical.scheduling.controller;

import br.com.curso.medical.scheduling.codec.Codec;
import br.com.curso.medical.scheduling.protocols.SchedulingRequest;
import br.com.curso.medical.scheduling.protocols.SchedulingResponse;
import br.com.curso.medical.scheduling.service.command.SchedulingCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to access service.
 *
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-04, Monday
 */
@RestController
@RequestMapping(value = "/v1/schedulers", produces = {"application/json", "application/hal+json"})
@RequiredArgsConstructor
public class SchedulingController {

    private final SchedulingCommandService service;

    @PostMapping
    public SchedulingResponse schedule(@RequestBody SchedulingRequest request) {
        return Codec.toResponse(service.toSchedule(Codec.toScheduling(request)));
    }


}
