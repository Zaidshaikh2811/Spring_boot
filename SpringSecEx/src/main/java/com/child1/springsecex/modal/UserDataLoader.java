package com.child1.springsecex.modal;

import com.child1.springsecex.repo.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDataLoader {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void loadData() {
        System.out.println("🚀 Loading initial user data...");
        String hashedPassword = passwordEncoder.encode("admin123");
        User user = new User("admin", hashedPassword, "ADMIN");
        userRepository.save(user);
    }
}
