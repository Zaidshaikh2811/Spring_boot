package com.child1.rest_controller.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain springSecurityFilterChain(HttpSecurity http) throws Exception {

            http.authorizeHttpRequests(authorizeRequests ->
                    authorizeRequests
                            .requestMatchers(HttpMethod.GET,"/employees").hasRole("EMPLOYEE")
                            .requestMatchers(HttpMethod.GET,"/employees/**").hasRole("EMPLOYEE")
                            .requestMatchers(HttpMethod.POST,"/employees").hasRole("MANAGER")
                            .requestMatchers(HttpMethod.PUT,"/employees").hasRole("MANAGER")
                            .requestMatchers(HttpMethod.DELETE,"/employees/**").hasRole("ADMIN")
                    )
                    .csrf(csrf -> csrf.disable())
                    .httpBasic(org.springframework.security.config.Customizer.withDefaults());

            return http.build();

    }
     

    @Bean
    public InMemoryUserDetailsManager  userDetailsManager() {

        UserDetails user = User.builder()
                .username("test")
                .password("{noop}password")
                .roles("USER")
                .build();

        UserDetails user2 = User.builder()
                .username("test2")
                .password("{noop}password")
                .roles("USER","MANAGER")
                .build();

        UserDetails user3 = User.builder()
                .username("test3")
                .password("{noop}password")
                .roles("USER","MANAGER","ADMIN")
                .build();


        return  new InMemoryUserDetailsManager(user,user2,user3);
    }

}
