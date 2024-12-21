package com.githiomi.inkvibe.config;

import com.githiomi.inkvibe.data.enums.Category;
import com.githiomi.inkvibe.data.models.Blog;
import com.githiomi.inkvibe.data.models.User;
import com.githiomi.inkvibe.services.BlogService;
import com.githiomi.inkvibe.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ApplicationConfig {

    @Bean
    // To only populate the DB if manually allowed
    @ConditionalOnProperty(prefix = "app", name = "manual.db.populate", havingValue = "true")
    CommandLineRunner commandLineRunner(UserService userService, BlogService blogService) {
        return args -> {
            userService.saveUser(
                    new User("Daniel", "Githiomi")
            );

            // Create dummy blogs
            blogService.saveAllBlogs(
                    Arrays.asList(
                            new Blog("Blog Post 1", "DANGIT", Category.ART),
                            new Blog("Blog Test 2", "DANGIT", Category.MUSIC)));
        };
    }
}
