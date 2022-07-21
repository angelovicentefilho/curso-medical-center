package br.com.curso.medical.doctor.protocols;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;
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
public class DoctorResponse extends RepresentationModel<DoctorResponse> implements Serializable {
    private String doctorId;
    private String name;
    private String speciality;
    private String password;
    private String username;
    private Set<RoleResponse> roles;
    private List<DoctorResponse> doctors;
}
