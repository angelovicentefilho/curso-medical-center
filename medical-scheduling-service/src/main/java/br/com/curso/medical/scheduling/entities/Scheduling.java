package br.com.curso.medical.scheduling.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-04, Monday
 */
@Entity
@Table(name = "scheduling")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Scheduling implements Serializable {
    @Id
    @Basic(optional = false)
    private String scheduleId;
    @Basic(optional = false)
    private String patientId;
    @Basic(optional = false)
    private String doctorId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public static final String CACHE_NAME = "SCHEDULING";
}
