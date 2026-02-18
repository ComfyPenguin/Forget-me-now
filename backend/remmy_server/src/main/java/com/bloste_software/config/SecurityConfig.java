package com.bloste_software.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // desactiva CSRF para pruebas REST 

            .authorizeHttpRequests(auth -> auth
                // Permite acceso público a registro y login
                .requestMatchers("/api/usuarios").permitAll()
                .requestMatchers("/api/login").permitAll()    

              
                // .anyRequest().authenticated()
                .anyRequest().permitAll()  
            );

        return http.build();
    }
}