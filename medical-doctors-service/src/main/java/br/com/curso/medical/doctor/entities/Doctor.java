package br.com.curso.medical.doctor.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-04, Monday
 */
@Entity
@Table(name = "doctors")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Doctor implements Serializable {
    @JoinTable(name = "doctors_has_roles",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
    @Id
    @Basic(optional = false)
    @Column(name = "doctor_id")
    private String doctorId;
    @Basic(optional = false)
    private String name;
    @Basic(optional = false)
    private String speciality;
    @Basic(optional = false)
    private String password;
    @Basic(optional = false)
    private String username;
}
