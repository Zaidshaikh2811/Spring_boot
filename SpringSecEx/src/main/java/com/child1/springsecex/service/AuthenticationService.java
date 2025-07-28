package com.child1.springsecex.service;

import com.child1.springsecex.Dto.UserDto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public AuthenticationService(AuthenticationManager authenticationManager, JwtService jwtService , PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto.LoginResponse authenticate(UserDto.LoginRequest loginRequest) {
        try {
            System.out.println("Attempting authentication for user: " + loginRequest.getUsername());
            System.out.println("Attempting authentication for user: " + loginRequest.getPassword());
            log.debug("Attempting authentication for user: {}", loginRequest.getPassword());



            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()

                    )
            );
            System.out.println("Authentication successful for user: " + loginRequest.getUsername());

            String role = authentication.getAuthorities().stream()
                    .findFirst()
                    .map(GrantedAuthority::getAuthority)
                    .orElse("ROLE_USER")
                    .replace("ROLE_", "");

            System.out.println("User role: " + role);

            String token = jwtService.generateToken(authentication.getName(), role);

            return UserDto.LoginResponse.builder()
                    .message("Login successful")
                    .username(authentication.getName())
                    .role(role)
                    .token(token)
                    .build();

        } catch (Exception e) {
            log.error("Authentication failed for user: {}", loginRequest.getUsername(), e);
            throw new RuntimeException("Authentication failed: " + e.getMessage());
        }
    }
}