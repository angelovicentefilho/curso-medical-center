package br.com.curso.medical.patient.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-19, Tuesday
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePatientCommand {
    private String patientId;
    private String socialNumber;
    private Integer age;
    private String name;
    private String phone;
    private String username;
    private String password;
}
