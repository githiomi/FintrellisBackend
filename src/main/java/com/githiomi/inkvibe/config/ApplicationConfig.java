package com.githiomi.inkvibe.config;

import com.githiomi.inkvibe.data.records.Blog;
import com.githiomi.inkvibe.services.BlogService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.UUID;

@Configuration
public class ApplicationConfig {

    @Bean
    @ConditionalOnProperty(prefix = "app", name = "manual.db.populate", havingValue = "true")
        // To only populate the DB if manually allowed
    CommandLineRunner commandLineRunner(BlogService blogService) {
        return args -> {
            System.out.println("Hello World");

            // Create dummy blogs
            Blog blog = new Blog(UUID.randomUUID(), "Blog Post 1", LocalDateTime.now());
            blogService.saveBlog(blog);

            System.out.println("Blog Post Saved");
        };
    }
}
