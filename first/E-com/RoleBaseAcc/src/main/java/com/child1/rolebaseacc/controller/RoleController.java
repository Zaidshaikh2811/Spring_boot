package com.child1.rolebaseacc.controller;

import com.child1.rolebaseacc.model.User;
import com.child1.rolebaseacc.repository.UserRepository;
import com.child1.rolebaseacc.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/users")
    public ResponseEntity<?> getUsersByRole(@RequestHeader("Authorization") String authHeader) {
        System.out.println("getUsersByRole");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body("Missing or invalid Authorization header");
        }
        String token = authHeader.substring(7);
        String role = jwtUtil.getRoleFromToken(token);
        String username = jwtUtil.getUsernameFromToken(token);
        System.out.println("Role: " + role + ", Username: " + username);
        System.out.println("Token: " + token);
        if (role == null) {
            return ResponseEntity.status(403).body("Invalid token or role");
        }
        System.out.println(role.equals("ADMIN"));
        if (role.equals("ADMIN")) {
            List<User> allUsers = userRepository.findAll();
            System.out.println("Admin role detected, returning all users");
            return ResponseEntity.ok(allUsers);
        } else {
            List<User> users = userRepository.findAll().stream()
                    .filter(u -> u.getRole().name().equals(role) && u.getUsername().equals(username))
                    .collect(Collectors.toList());
            System.out.println("Non-admin role detected, returning users with role: " + role);
            return ResponseEntity.ok(users);
        }
    }
}

