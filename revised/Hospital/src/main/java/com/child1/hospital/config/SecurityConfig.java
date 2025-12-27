package com.child1.hospital.config;


import com.child1.hospital.filters.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter JwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth
//                    .anyRequest().permitAll()
                            .requestMatchers(HttpMethod.GET, "/").permitAll()
            )
            .addFilterBefore(JwtFilter, UsernamePasswordAuthenticationFilter.class)
            .formLogin(Customizer.withDefaults());

        return http.build();
    }

}
