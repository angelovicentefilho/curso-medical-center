package br.com.curso.medical.doctor.services.command;

import br.com.curso.medical.commons.id.GenId;
import br.com.curso.medical.doctor.codec.Codec;
import br.com.curso.medical.doctor.commands.CreateDoctorCommand;
import br.com.curso.medical.doctor.commands.DeleteDoctorCommand;
import br.com.curso.medical.doctor.commands.UpdateDoctorCommand;
import br.com.curso.medical.doctor.entities.Doctor;
import br.com.curso.medical.doctor.entities.Roles;
import br.com.curso.medical.doctor.repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-21, Thursday
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class DoctorCommandServiceImpl implements DoctorCommandService {
    private final DoctorRepository repository;
    private final PasswordEncoder encoder;

    public Optional<Doctor> save(CreateDoctorCommand command) {
        var doctor = Codec.toDoctor(command);
        doctor.setDoctorId(GenId.id());
        doctor.setPassword(encoder.encode(doctor.getPassword()));
        if (doctor.getRoles() == null || doctor.getRoles().isEmpty()) {
            doctor.setRoles(Roles.defaultRole());
        }
        return Optional.of(this.repository.save(doctor));
    }

    @Override
    public Optional<Doctor> update(UpdateDoctorCommand command) {
        var doctor = this.repository.findById(command.getDoctorId());
        if (doctor.isPresent()) {
            return Optional.of(this.repository.save(Codec.toDoctor(command)));
        }
        throw new EntityNotFoundException("Doctor not found!");
    }

    @Override
    public void delete(DeleteDoctorCommand command) {
        this.repository.deleteById(command.getDoctorId());
    }
}
