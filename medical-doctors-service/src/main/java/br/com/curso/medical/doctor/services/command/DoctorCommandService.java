package br.com.curso.medical.doctor.services.command;

import br.com.curso.medical.doctor.commands.CreateDoctorCommand;
import br.com.curso.medical.doctor.commands.DeleteDoctorCommand;
import br.com.curso.medical.doctor.commands.UpdateDoctorCommand;
import br.com.curso.medical.doctor.entities.Doctor;

import java.util.Optional;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-21, Thursday
 */
public interface DoctorCommandService {

    Optional<Doctor> save(CreateDoctorCommand command);

    Optional<Doctor> update(UpdateDoctorCommand command);

    void delete(DeleteDoctorCommand command);
}
