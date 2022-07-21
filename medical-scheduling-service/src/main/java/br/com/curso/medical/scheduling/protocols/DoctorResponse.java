package br.com.curso.medical.scheduling.protocols;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-04, Monday
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class DoctorResponse implements Serializable {
    private String doctorId;
    private String name;
    private String speciality;
    private String password;
    private String username;
    private String token;
    private Set<RoleResponse> roles;
    private List<DoctorResponse> doctors;
}
