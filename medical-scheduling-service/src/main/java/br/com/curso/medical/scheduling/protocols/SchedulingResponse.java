package br.com.curso.medical.scheduling.protocols;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-04, Monday
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SchedulingResponse extends RepresentationModel<SchedulingResponse> implements Serializable {
    private String scheduleId;
    private String patientId;
    private String doctorId;
    private Date date;
    private Set<SchedulingResponse> schedulers;
}
