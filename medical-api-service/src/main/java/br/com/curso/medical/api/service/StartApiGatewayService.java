package br.com.curso.medical.api.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class StartApiGatewayService {

    public static void main(String[] args) {
        SpringApplication.run(StartApiGatewayService.class, args);
    }

}
