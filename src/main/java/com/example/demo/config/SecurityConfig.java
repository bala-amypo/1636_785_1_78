package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // ❌ disable csrf (swagger needs this)
            .csrf(csrf -> csrf.disable())

            // ❌ disable default login
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable())

            // ✅ allow swagger & everything else
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/swagger-ui.html"
                ).permitAll()
                .anyRequest().permitAll()
            );

        return http.build();
    }
}
