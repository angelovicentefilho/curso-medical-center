package br.com.curso.medical.discovery.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class StartDiscoveryService {

    public static void main(String[] args) {
        SpringApplication.run(StartDiscoveryService.class, args);
    }

}
