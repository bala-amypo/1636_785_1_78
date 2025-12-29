package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        // 🔒 JWT lock symbol (UI only)
        SecurityScheme bearerScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        // 🌐 IMPORTANT: HTTPS + PORT
        Server server = new Server()
                .url("https://9161.pro604cr.amypo.ai")
                .description("Production server");

        return new OpenAPI()
                .servers(List.of(server))
                .components(new Components()
                        .addSecuritySchemes("BearerAuth", bearerScheme))
                .addSecurityItem(new SecurityRequirement()
                        .addList("BearerAuth"));
    }
}
