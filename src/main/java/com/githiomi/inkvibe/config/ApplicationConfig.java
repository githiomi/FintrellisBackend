package com.githiomi.inkvibe.config;

import com.githiomi.inkvibe.data.enums.Category;
import com.githiomi.inkvibe.data.models.Blog;
import com.githiomi.inkvibe.services.BlogService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    // To only populate the DB if manually allowed
    @ConditionalOnProperty(prefix = "app", name = "manual.db.populate", havingValue = "true")
    CommandLineRunner commandLineRunner(BlogService blogService) {
        return args -> {
            System.out.println("Hello World");

            // Create dummy blogs
            blogService.saveBlog(new Blog("Blog Post 1", Category.ART));
        };
    }
}
