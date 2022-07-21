package br.com.curso.medical.patient.codec;

import br.com.curso.medical.patient.commands.CreatePatientCommand;
import br.com.curso.medical.patient.commands.UpdatePatientCommand;
import br.com.curso.medical.patient.controller.FindAllController;
import br.com.curso.medical.patient.controller.FindByPatientIdController;
import br.com.curso.medical.patient.entities.Patient;
import br.com.curso.medical.patient.entities.Role;
import br.com.curso.medical.patient.protocols.PatientRequest;
import br.com.curso.medical.patient.protocols.PatientResponse;
import br.com.curso.medical.patient.protocols.RoleResponse;
import br.com.curso.medical.patient.entities.Roles;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

import java.util.List;
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

    public static Patient toPatient(CreatePatientCommand command) {
        var o = new Patient();
        BeanUtils.copyProperties(command, o);
        return o;
    }

    public static Patient toPatient(UpdatePatientCommand command) {
        var o = new Patient();
        BeanUtils.copyProperties(command, o);
        o.setRoles(Roles.defaultRole());
        return o;
    }


    public static Patient toPatient(PatientRequest request) {
        var o = new Patient();
        BeanUtils.copyProperties(request, o);
        return o;
    }

    public static PatientResponse toResponse(Patient patient) {
        var o = new PatientResponse();
        BeanUtils.copyProperties(patient, o);
        o.setRoles(Codec.toResponse(patient.getRoles()).getRoles());
        o.add(linkTo(methodOn(FindByPatientIdController.class).findById(patient.getPatientId())).withSelfRel());
        return o;
    }

    public static PatientResponse toResponse(List<Patient> patients) {
        var list = patients.stream().map(Codec::toResponse).collect(Collectors.toList());
        return PatientResponse.builder().patients(list).build()
                .add(linkTo(methodOn(FindAllController.class).findAll()).withSelfRel());
    }

    public static RoleResponse toResponse(Role role) {
        var response = new RoleResponse();
        BeanUtils.copyProperties(role, response);
        return response;
    }

    public static RoleResponse toResponse(Set<Role> roles) {
        var set = roles.stream().map(Codec::toResponse).collect(Collectors.toSet());
        return RoleResponse.builder().roles(set).build();
    }


    public static CreatePatientCommand toCreateCommand(PatientRequest request) {
        return CreatePatientCommand.builder()
                .age(request.getAge())
                .patientId(request.getPatientId())
                .name(request.getName())
                .phone(request.getPhone())
                .username(request.getUsername())
                .password(request.getPassword())
                .socialNumber(request.getSocialNumber())
                .build();
    }

    public static UpdatePatientCommand toUpdateCommand(PatientRequest request) {
        return UpdatePatientCommand.builder()
                .age(request.getAge())
                .patientId(request.getPatientId())
                .name(request.getName())
                .phone(request.getPhone())
                .username(request.getUsername())
                .password(request.getPassword())
                .socialNumber(request.getSocialNumber())
                .build();
    }
}
