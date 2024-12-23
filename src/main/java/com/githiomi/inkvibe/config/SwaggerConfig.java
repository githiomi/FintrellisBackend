package com.githiomi.inkvibe.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Ink Vibe")
                        .description("Fintrellis Backend Technical Assessment")
                        .version("v.1.0")
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0")))
                .addServersItem(
                        new Server().url("http://localhost:9000/").description("Local Development Server."))
                .addServersItem(
                        new Server().url("http://localhost:8080").description("Docker Containerised Server."));
    }
}
