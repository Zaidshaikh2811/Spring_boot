package com.child1.springsecex.service;

import com.child1.springsecex.Dto.UserDto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @Autowired
    public AuthenticationService(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;

    }

    public UserDto.LoginResponse authenticate(UserDto.LoginRequest loginRequest) {
        try {

            log.debug("Attempting authentication for user: {}", loginRequest.getPassword());



            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()

                    )
            );

            String role = authentication.getAuthorities().stream()
                    .findFirst()
                    .map(GrantedAuthority::getAuthority)
                    .orElse("ROLE_USER")
                    .replace("ROLE_", "");



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