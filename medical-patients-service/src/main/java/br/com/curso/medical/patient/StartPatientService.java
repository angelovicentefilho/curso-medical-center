package br.com.curso.medical.patient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class StartPatientService {

    public static void main(String[] args) {
        SpringApplication.run(StartPatientService.class, args);
    }

}
