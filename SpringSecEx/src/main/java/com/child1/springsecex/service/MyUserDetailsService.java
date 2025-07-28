package com.child1.springsecex.service;

import com.child1.springsecex.Dto.UserDto;
import com.child1.springsecex.modal.User;
import com.child1.springsecex.repo.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public List<UserDto.Response> getAllUsers() {
        log.debug("Fetching all users");
        return userRepository.findAll()
                .stream()
                .map(UserDto.Response::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public UserDto.Response getUserByUsername(String username) {
        log.debug("Fetching user by username: {}", username);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return UserDto.Response.from(user);
    }

    public UserDto.Response createUser(UserDto.RegisterRequest request) {
        log.debug("Creating new user with username: {}", request.getUsername());

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new UserAlreadyExistsException("User already exists with username: " + request.getUsername());
        }

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(User.Role.valueOf(request.getRole().toUpperCase()))
                .enabled(true)
                .build();

        User savedUser = userRepository.save(user);
        log.info("User created successfully with username: {}", savedUser.getUsername());

        return UserDto.Response.from(savedUser);
    }

    public void deleteUserByUsername(String username) {
        log.debug("Deleting user with username: {}", username);

        if (!userRepository.existsByUsername(username)) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        userRepository.deleteByUsername(username);
        log.info("User deleted successfully with username: {}", username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .accountLocked(!user.getEnabled())
                .build();
    }
}
