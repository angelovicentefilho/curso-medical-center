package br.com.curso.medical.api.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(exclude = {
        RedisAutoConfiguration.class
})
public class StartApiGatewayService {

    public static void main(String[] args) {
        SpringApplication.run(StartApiGatewayService.class, args);
    }

}
