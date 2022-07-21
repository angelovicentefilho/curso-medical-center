package br.com.curso.medical.patient.services.command;

import br.com.curso.medical.patient.commands.CreatePatientCommand;
import br.com.curso.medical.patient.commands.DeletePatientCommand;
import br.com.curso.medical.patient.commands.UpdatePatientCommand;
import br.com.curso.medical.patient.entities.Patient;

import java.util.Optional;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-20, Wednesday
 */
public interface PatientCommandService {

    Optional<Patient> save(CreatePatientCommand command);

    Optional<Patient> update(UpdatePatientCommand command);

    void delete(DeletePatientCommand command);
}
