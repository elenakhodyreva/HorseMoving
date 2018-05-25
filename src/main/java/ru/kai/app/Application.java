package ru.kai.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.kai.servlets.HorseMoveServlet;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = "ru.kai")
@EntityScan(basePackages = "ru.kai.models")
public class Application {

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean bean=  new ServletRegistrationBean(new HorseMoveServlet());
        return bean;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}