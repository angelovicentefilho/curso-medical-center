package br.com.curso.medical.doctor.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-20, Wednesday
 */
@Data
@Builder
@AllArgsConstructor
public class UpdateDoctorCommand {
    private String doctorId;
    private String name;
    private String speciality;
    private String password;
    private String username;
}
