package com.child1.controller;


import com.child1.JwtService;
import com.child1.modal.User;
import io.jsonwebtoken.JwtBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private AuthenticationManager authenticationManage;


    @Autowired
    private JwtService jwtService;


    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    List<User> userList = new ArrayList<>(
            List.of(
                    new User("admin", "admin123")
    )
    );

 @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        if (userList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.ok(userList);
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user ) {

        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println("Registration attempt with username: " + username + " and password: " + password);
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username and password cannot be empty");
        }
        for (User userList : userList) {
            if (userList.getUsername().equals(username)) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
            }
        }
        User newUser = new User(username, password);
        userList.add(newUser);


        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println("Login attempt with username: " + username + " and password: " + password);
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username and password cannot be empty");
        }


        for( User userList : userList) {
            System.out.println("Checking user: " + userList.getUsername());
            if (userList.getUsername().equals(username) && userList.getPassword().equals(password)) {

                Authentication authentication = authenticationManage.authenticate(new UsernamePasswordAuthenticationToken(username, password));
                System.out.println(authentication.isAuthenticated());
                if(authentication.isAuthenticated()) {
                    System.out.println("User authenticated successfully: " + username);
                    String token=  jwtService.generateToken(username);
                    System.out.println("Generated Token: " + token);
                    return ResponseEntity.status(HttpStatus.OK).body(token )   ;

                }
                System.out.println("User authenticated successfully: " + username);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");


    }
}
