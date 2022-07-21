package br.com.curso.medical.scheduling.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-20, Wednesday
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SchedulingCommand {
    private String scheduleId;
    private String patientId;
    private String doctorId;
    private Date date;
}
