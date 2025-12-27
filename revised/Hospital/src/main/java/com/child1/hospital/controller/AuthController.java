package com.child1.hospital.controller;


import com.child1.hospital.dto.request.AuthRequest;
import com.child1.hospital.utils.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            System.out.println("User " + request.getUsername() + " authenticated successfully.");

            return jwtUtil.generateToken(request.getUsername());

        }
        catch (Exception ex) {
            return "Invalid username or password";
        }
    }
}
