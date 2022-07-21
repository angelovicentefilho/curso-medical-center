package br.com.curso.medical.doctor.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-08, Friday
 */
@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role implements Serializable {

    @Id
    @Basic(optional = false)
    private String roleId;
    private String name;
}
