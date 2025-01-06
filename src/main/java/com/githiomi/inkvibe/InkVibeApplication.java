package com.githiomi.inkvibe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class
})
@CrossOrigin(origins = {"*"})
public class InkVibeApplication {

    public static void main(String[] args) {
        SpringApplication.run(InkVibeApplication.class, args);
    }

}
