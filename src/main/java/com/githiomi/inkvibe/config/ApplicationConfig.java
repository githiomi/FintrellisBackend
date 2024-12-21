package com.githiomi.inkvibe.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> System.out.println("Hello World");
    }
}
