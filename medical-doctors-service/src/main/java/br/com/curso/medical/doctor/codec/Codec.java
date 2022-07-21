package br.com.curso.medical.doctor.codec;


import br.com.curso.medical.doctor.commands.CreateDoctorCommand;
import br.com.curso.medical.doctor.commands.UpdateDoctorCommand;
import br.com.curso.medical.doctor.controllers.FindAllController;
import br.com.curso.medical.doctor.controllers.FindByDoctorIdController;
import br.com.curso.medical.doctor.controllers.FindByUsernameController;
import br.com.curso.medical.doctor.entities.Doctor;
import br.com.curso.medical.doctor.entities.Role;
import br.com.curso.medical.doctor.protocols.DoctorRequest;
import br.com.curso.medical.doctor.protocols.DoctorResponse;
import br.com.curso.medical.doctor.protocols.RoleResponse;
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

    public static Doctor toDoctor(DoctorRequest request) {
        var doc = new Doctor();
        BeanUtils.copyProperties(request, doc);
        return doc;
    }

    public static Doctor toDoctor(CreateDoctorCommand command) {
        var doc = new Doctor();
        BeanUtils.copyProperties(command, doc);
        return doc;
    }

    public static Doctor toDoctor(UpdateDoctorCommand command) {
        var doc = new Doctor();
        BeanUtils.copyProperties(command, doc);
        return doc;
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

    public static DoctorResponse toResponse(Doctor doctor) {
        var response = new DoctorResponse();
        BeanUtils.copyProperties(doctor, response);
        response.setRoles(Codec.toResponse(doctor.getRoles()).getRoles());
        response.add(linkTo(methodOn(FindByDoctorIdController.class).findByDoctorId(doctor.getDoctorId())).withSelfRel());
        response.add(linkTo(methodOn(FindByUsernameController.class).findByUsername(doctor.getUsername())).withSelfRel());
        return response;
    }

    public static DoctorResponse toResponse(List<Doctor> doctors) {
        var list = doctors.stream().map(Codec::toResponse).collect(Collectors.toList());
        return DoctorResponse.builder().doctors(list)
                .build().add(linkTo(methodOn(FindAllController.class)
                        .findAll()).withSelfRel());
    }

    public static CreateDoctorCommand toCreateCommand(DoctorRequest request) {
        return CreateDoctorCommand.builder()
                .doctorId(request.getDoctorId())
                .name(request.getName())
                .password(request.getPassword())
                .speciality(request.getSpeciality())
                .username(request.getUsername())
                .build();
    }

    public static UpdateDoctorCommand toUpdateCommand(DoctorRequest request) {
        return UpdateDoctorCommand.builder()
                .doctorId(request.getDoctorId())
                .name(request.getName())
                .password(request.getPassword())
                .speciality(request.getSpeciality())
                .username(request.getUsername())
                .build();
    }

}
