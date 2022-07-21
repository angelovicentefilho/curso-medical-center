package br.com.curso.medical.patient.commands;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-19, Tuesday
 */
@Data
@AllArgsConstructor
public class DeletePatientCommand {
    private String patientId;
}
