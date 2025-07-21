package com.child1.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // disable CSRF for testing purpose
                .authorizeHttpRequests(auth -> auth
                        // Exclude internal Spring paths from security
                        .requestMatchers("/WEB-INF/**", "/error", "/resources/**", "/static/**").permitAll()

                        .requestMatchers(HttpMethod.GET, "/createJob").authenticated()
                        .requestMatchers(HttpMethod.POST, "/createJob").authenticated()

                        // All other requests are public
                        .anyRequest().permitAll()
                )
                .httpBasic(Customizer.withDefaults()); // enable basic auth

        return http.build();
    }
}