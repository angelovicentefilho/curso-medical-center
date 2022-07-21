package br.com.curso.medical.commons.id;

import lombok.experimental.UtilityClass;

import java.util.UUID;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-08, Friday
 */
@UtilityClass
public class GenId {
    public static String id() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
}
