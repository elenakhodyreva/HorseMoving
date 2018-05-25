package ru.kai.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "ru.kai")
@EntityScan(basePackages = "ru.kai.models")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}