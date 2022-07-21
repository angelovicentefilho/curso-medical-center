package br.com.curso.medical.patient.entities;

import br.com.curso.medical.patient.entities.Role;
import com.google.common.collect.Sets;
import lombok.experimental.UtilityClass;

import java.util.Set;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-08, Friday
 */
@UtilityClass
public class Roles {

    public static Set<Role> defaultRole() {
        var role = new Role("6663710ADDD04CF9B2038CBDE2736R01", "ROLE_PATIENT");
        return Sets.newHashSet(role);
    }
}
