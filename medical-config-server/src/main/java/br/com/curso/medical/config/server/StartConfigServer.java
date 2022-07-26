package br.com.curso.medical.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication(exclude = {
        RedisAutoConfiguration.class
})
public class StartConfigServer {

    public static void main(String[] args) {
        SpringApplication.run(StartConfigServer.class, args);
    }

}
