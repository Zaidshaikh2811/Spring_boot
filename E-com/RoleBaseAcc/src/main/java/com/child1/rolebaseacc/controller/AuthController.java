package com.child1.rolebaseacc.controller;

import com.child1.rolebaseacc.model.User;
import com.child1.rolebaseacc.service.UserService;
import com.child1.rolebaseacc.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        if (userService.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        try {
            String username = loginRequest.get("username");
            String password = loginRequest.get("password");
            if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
                return ResponseEntity.badRequest().body("Username and password must not be empty");
            }
            System.out.println(" Login request: " + loginRequest);
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            username,
                            password
                    )
            );
            System.out.println("Authentication successful for user: " + username);
            if (authentication == null || !authentication.isAuthenticated()) {
                System.out.println("Authentication failed for user: " + username);
                return ResponseEntity.status(401).body("Invalid username or password");
            }
            System.out.println("Setting security context for user: " + username);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            User user = userService.findByUsername(username);
            if (user == null) {
                System.out.println("User not found: " + username);
                return ResponseEntity.status(404).body("User not found");
            }
            System.out.println("Generating JWT token for user: " + user.getUsername());
            log.info("Generating JWT token for user: {}", user.getUsername());
            String token = jwtUtil.generateToken(user);
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("role", user.getRole());
            response.put("username", user.getUsername());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println("Error during login: " + e.getMessage());
            log.error("Error during login: {}", e.getMessage());
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }



}
