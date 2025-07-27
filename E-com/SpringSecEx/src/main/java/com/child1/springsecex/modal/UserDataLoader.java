package com.child1.springsecex.modal;

import com.child1.springsecex.repo.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDataLoader {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void loadData() {
        System.out.println("🚀 Loading initial user data...");
        User user = new User("admin", "admin123", "ADMIN");
        userRepository.save(user);
    }
}
