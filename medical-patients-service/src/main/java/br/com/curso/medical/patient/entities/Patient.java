package br.com.curso.medical.patient.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-04, Monday
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
@ToString(exclude = "roles")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient implements Serializable {
    @Id
    private String patientId;
    private Integer age;
    private String name;
    private String phone;
    private String username;
    private String password;
    @JoinTable(name = "patients_has_roles",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public static final String CACHE_NAME = "PATIENT";
}
