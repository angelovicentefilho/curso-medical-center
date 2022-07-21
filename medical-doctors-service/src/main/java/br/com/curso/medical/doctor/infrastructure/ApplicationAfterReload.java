package br.com.curso.medical.doctor.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-07, Thursday
 */
@Slf4j
@RefreshScope
@Configuration
public class ApplicationAfterReload {


    @Value("${app.message}")
    private String environment;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationEvent(ApplicationReadyEvent event) {
        show();
    }

    private void show() {
        log.info("=====================================");
        log.info("== Running: '{}' ==", environment);
        log.info("=====================================");
    }

    @EventListener(RefreshScopeRefreshedEvent.class)
    public void onRefresh(RefreshScopeRefreshedEvent event) {
        show();
    }
}
