package br.com.curso.medical.scheduling.codec;

import br.com.curso.medical.scheduling.commands.SchedulingCommand;
import br.com.curso.medical.scheduling.controller.FindAllController;
import br.com.curso.medical.scheduling.controller.FindByDoctorIdController;
import br.com.curso.medical.scheduling.controller.FindByPatientIdController;
import br.com.curso.medical.scheduling.entities.Scheduling;
import br.com.curso.medical.scheduling.protocols.SchedulingRequest;
import br.com.curso.medical.scheduling.protocols.SchedulingResponse;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-04, Monday
 */
@UtilityClass
public class Codec {

    public static Scheduling toScheduling(SchedulingRequest request) {
        var o = new Scheduling();
        BeanUtils.copyProperties(request, o);
        return o;
    }

    public static SchedulingResponse toResponse(Scheduling scheduling) {
        return SchedulingResponse.builder()
                .date(scheduling.getDate())
                .doctorId(scheduling.getDoctorId())
                .patientId(scheduling.getPatientId())
                .scheduleId(scheduling.getScheduleId())
                .build()
                .add(linkTo(methodOn(FindByPatientIdController.class)
                        .findByPatientId(scheduling.getPatientId())).withSelfRel())
                .add(linkTo(methodOn(FindByDoctorIdController.class)
                        .findByDoctor(scheduling.getDoctorId())).withSelfRel());

    }

    public static SchedulingResponse toResponse(Set<Scheduling> schedulers) {
        var set = schedulers.stream().map(Codec::toResponse).collect(Collectors.toSet());
        return SchedulingResponse.builder()
                .schedulers(set)
                .build()
                .add(linkTo(methodOn(FindAllController.class).schedules()).withSelfRel());
    }

    public static SchedulingCommand toSchedulingCommand(SchedulingRequest request) {
        return SchedulingCommand.builder()
                .date(request.getDate())
                .doctorId(request.getDoctorId())
                .scheduleId(request.getScheduleId())
                .patientId(request.getPatientId())
                .build();
    }
}
