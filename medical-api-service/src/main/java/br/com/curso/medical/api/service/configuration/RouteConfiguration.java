package br.com.curso.medical.api.service.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-07-18, Monday
 */
@Configuration
public class RouteConfiguration {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(r -> r.path("/v1/doctors/**").uri("lb://doctors-service"))
                .build();
    }
}
