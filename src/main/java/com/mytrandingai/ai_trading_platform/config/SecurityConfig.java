package com.mytrandingai.ai_trading_platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()  // Disable CSRF for API (optional, based on your use case)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api","/api/auth/signup", "/api/auth/login").permitAll()  // Allow unauth access here
                .anyRequest().authenticated()  // Secure everything else
            )
            .formLogin().disable();  // Disable default form login if you don't need it

        return http.build();
    }
}
