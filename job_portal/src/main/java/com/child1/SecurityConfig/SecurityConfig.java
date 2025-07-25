package com.child1.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



    @Bean
    public UserDetailsService userDetailsService() {


        return username -> {

            if ("admin".equals(username)) {
                return org.springframework.security.core.userdetails.User.withUsername("admin")
                        .password("admin123")
                        .roles("USER", "ADMIN")
                        .build();
            }
            throw new org.springframework.security.core.userdetails.UsernameNotFoundException("User not found");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return NoOpPasswordEncoder.getInstance();


    }



    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService,
                                                            PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider configurer = new DaoAuthenticationProvider();
        configurer.setUserDetailsService(userDetailsService);
        configurer.setPasswordEncoder(passwordEncoder);

        return configurer;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }



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