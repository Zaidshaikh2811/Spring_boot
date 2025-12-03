package com.child1.springsecex.controller;

import com.child1.springsecex.Dto.UserDto;

import com.child1.springsecex.service.AuthenticationService;
import com.child1.springsecex.service.MyUserDetailsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api")
public class UserController {

    private final MyUserDetailsService userService;
    private final AuthenticationService authenticationService;

    public UserController(MyUserDetailsService userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }


    @GetMapping("/users")
    public  ResponseEntity<List<UserDto.Response>> getAllUsers() {

        List<UserDto.Response> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<UserDto.Response> getUser(@PathVariable String username) {
        UserDto.Response user = userService.getUserByUsername(username);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto.Response> registerUser(@Valid @RequestBody UserDto.RegisterRequest  request) {
        UserDto.Response user = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }



    @PostMapping("/login")
    public ResponseEntity<UserDto.LoginResponse> login(@Valid @RequestBody UserDto.LoginRequest loginRequest) {
        System.out.println("Received login request for user: " + loginRequest.getUsername());
        UserDto.LoginResponse response = authenticationService.authenticate(loginRequest);
        return ResponseEntity.ok(response);
    }





}
