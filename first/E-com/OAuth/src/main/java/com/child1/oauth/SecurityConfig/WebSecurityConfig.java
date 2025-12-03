package com.child1.oauth.SecurityConfig;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final OAuthTwoSuccessHandler oAuthTwoSuccessHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(
                authz -> authz
                        .requestMatchers("/", "/login", "/oauth2/**", "/h2-console/**").permitAll() // Allow public access to these endpoints
                    .anyRequest().authenticated() // All other requests require authentication
            ).oauth2Login(
                oauth2 -> oauth2
                        .loginPage("/login") // Custom login page
                        .successHandler(oAuthTwoSuccessHandler)
                ).csrf(
                        AbstractHttpConfigurer::disable
                );
        return http.build();
    }
}
