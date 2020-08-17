package ru.inno.stc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SimpleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleAppApplication.class, args);
    }

}