package com.child1.security.Sec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//            http.authorizeHttpRequests(authorizeRequests ->
//                    authorizeRequests
//                            .requestMatchers(HttpMethod.GET,"/students").hasAnyRole("USER", "ADMIN","MANAGER")
//                            .requestMatchers(HttpMethod.GET,"/students/**").hasAnyRole("USER", "ADMIN","MANAGER")
//                            .requestMatchers(HttpMethod.POST,"/students").permitAll()
//                            .requestMatchers(HttpMethod.PUT,"/students/**").hasRole("MANAGER")
//                            .requestMatchers(HttpMethod.DELETE,"/students/**").hasRole("ADMIN")
//                    )
//                    .csrf(csrf -> csrf.disable())
//                    .httpBasic(org.springframework.security.config.Customizer.withDefaults());
        http.authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/user").authenticated()
                                .anyRequest().permitAll()
                )
                .csrf(csrf -> csrf.disable())
                .httpBasic(org.springframework.security.config.Customizer.withDefaults());

            return http.build();

    }
     

//    @Bean
//    public InMemoryUserDetailsManager  userDetailsManager() {
//
//        UserDetails user = User.builder()
//                .username("test")
//                .password("{noop}password")
//                .roles("USER")
//                .build();
//
//        UserDetails user2 = User.builder()
//                .username("test2")
//                .password("{noop}password")
//                .roles("USER","MANAGER")
//                .build();
//
//        UserDetails user3 = User.builder()
//                .username("test3")
//                .password("{noop}password")
//                .roles("USER","MANAGER","ADMIN")
//                .build();
//
//
//        return  new InMemoryUserDetailsManager(user,user2,user3);
//    }

}
