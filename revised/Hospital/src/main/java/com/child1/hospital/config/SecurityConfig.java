package com.child1.hospital.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf->csrf.disable())
//                .formLogin(Customizer.withDefaults())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/v1/patients/**").hasAnyRole("PATIENT", "DOCTOR", "ADMIN")
//                        .requestMatchers("/api/v1/doctors/**").hasAnyRole("DOCTOR", "ADMIN")
//                        .requestMatchers("/api/v1/admins/**").hasRole("ADMIN")
//                        .anyRequest().permitAll()
//                );

        http.csrf( csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                    .anyRequest().permitAll()
            )
            .formLogin(Customizer.withDefaults());

        return http.build();
    }


    @Bean
    UserDetailsService userDetailsService() {
        UserDetails user1 = User
                .withUsername("patient")
                .password(passwordEncoder.encode("password"))
                .roles("Patient")
                .build();

        UserDetails user2 = User
                .withUsername("Doctor")
                .password(passwordEncoder.encode("password"))
                .roles("DOCTOR")
                .build();

        UserDetails user3 = User
                .withUsername("Admin")
                .password(passwordEncoder.encode("password"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager( user1, user2, user3);
    }
}
