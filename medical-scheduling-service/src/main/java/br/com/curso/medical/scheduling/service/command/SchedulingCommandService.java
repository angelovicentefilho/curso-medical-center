package br.com.curso.medical.scheduling.service.command;

import br.com.curso.medical.scheduling.entities.Scheduling;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-20, Wednesday
 */
public interface SchedulingCommandService {
    Scheduling toSchedule(Scheduling scheduling);
}
