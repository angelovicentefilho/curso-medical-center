package br.com.curso.medical.doctor.commands;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-20, Wednesday
 */
@Data
@AllArgsConstructor
public class DeleteDoctorCommand {
    private String doctorId;
}
