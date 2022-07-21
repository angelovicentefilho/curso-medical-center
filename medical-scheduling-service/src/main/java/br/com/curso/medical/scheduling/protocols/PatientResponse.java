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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientResponse implements Serializable {
    private String patientId;
    private Integer age;
    private String name;
    private String phone;
    private Set<RoleResponse> roles;
    private List<PatientResponse> patients;
}
