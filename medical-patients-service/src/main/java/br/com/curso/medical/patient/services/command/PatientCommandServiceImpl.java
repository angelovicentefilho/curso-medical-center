package br.com.curso.medical.patient.services.command;

import br.com.curso.medical.commons.id.GenId;
import br.com.curso.medical.patient.codec.Codec;
import br.com.curso.medical.patient.commands.CreatePatientCommand;
import br.com.curso.medical.patient.commands.DeletePatientCommand;
import br.com.curso.medical.patient.commands.UpdatePatientCommand;
import br.com.curso.medical.patient.entities.Patient;
import br.com.curso.medical.patient.queries.FindByPatientIdQuery;
import br.com.curso.medical.patient.repository.PatientRepository;
import br.com.curso.medical.patient.services.query.PatientQueryService;
import br.com.curso.medical.patient.entities.Roles;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-20, Wednesday
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PatientCommandServiceImpl implements PatientCommandService {

    private static final String PATIENT_NOT_FOUND = "Patient not found!";
    private final PatientRepository repository;
    private final PasswordEncoder encoder;
    private final PatientQueryService queryService;

    @Override
    public Optional<Patient> update(UpdatePatientCommand command) {
        var patient = queryService.findById(new FindByPatientIdQuery(command.getPatientId()));
        if (patient.isPresent()) {
            setUsernameAndPassword(command, patient.get());
            return Optional.of(this.repository.save(Codec.toPatient(command)));
        }
        throw new EntityNotFoundException(PATIENT_NOT_FOUND);
    }

    private void setUsernameAndPassword(UpdatePatientCommand command, Patient patient) {
        if (command.getPassword() == null) {
            command.setPassword(patient.getPassword());
        } else {
            command.setPassword(encoder.encode(command.getPassword()));
        }
        if (command.getUsername() == null) {
            command.setUsername(patient.getUsername());
        }
    }

    @Override
    public void delete(DeletePatientCommand command) {
        var patient = queryService.findById(new FindByPatientIdQuery(command.getPatientId()));
        if (patient.isPresent()) {
            this.repository.deleteById(command.getPatientId());
        }
    }

    @Override
    public Optional<Patient> save(CreatePatientCommand command) {
        var patient = Codec.toPatient(command);
        patient.setPatientId(GenId.id());
        patient.setRoles(Roles.defaultRole());
        patient.setPassword(encoder.encode(patient.getPassword()));
        return Optional.of(this.repository.save(patient));
    }

}
