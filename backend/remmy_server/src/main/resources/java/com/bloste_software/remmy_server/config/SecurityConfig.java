package com.bloste_software.remmy_server.config;

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
            .csrf(csrf -> csrf.disable())  // OK for stateless REST API / dev

            .authorizeHttpRequests(auth -> auth
                // Public: registration, login, etc.
                // Fix: add /** if you want to cover subpaths (e.g. /User/123)
                .requestMatchers("/User", "/User/**", "/login", "/register").permitAll()

                // For now: allow everything else (remove or restrict later!)
                .anyRequest().permitAll()
            );

        // Optional: if you later add JWT / OAuth, you'll probably want .httpBasic() or .oauth2ResourceServer() etc.
        // .httpBasic(Customizer.withDefaults());   ← uncomment only if needed

        return http.build();
    }
}