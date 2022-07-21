package br.com.curso.medical.commons.dates;

import lombok.experimental.UtilityClass;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-19, Tuesday
 */
@UtilityClass
public class Dates {

    public static String format(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

}
