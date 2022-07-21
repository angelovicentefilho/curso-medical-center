package br.com.curso.medical.scheduling.protocols;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-04, Monday
 */
@AllArgsConstructor
@NoRepositoryBean
@Builder
@Data
public class SchedulingRequest implements Serializable {
    private String scheduleId;
    private String patientId;
    private String doctorId;
    private Date date;
}
