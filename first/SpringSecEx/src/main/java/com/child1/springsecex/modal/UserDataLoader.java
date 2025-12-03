package com.child1.springsecex.modal;

import com.child1.springsecex.repo.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
@Profile("!test") // Don't load data during tests
@ConditionalOnProperty(name = "app.data.load-initial-users", havingValue = "true", matchIfMissing = true)
public class UserDataLoader {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    @Transactional
    public void loadData() {
        log.info("🚀 Loading initial user data...");

        try {
            // Check if admin user already exists
            if (userRepository.existsByUsername("admin")) {
                log.info("Admin user already exists, skipping data load");
                return;
            }

            // Create admin user
            User adminUser = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin123"))
                    .role(User.Role.ADMIN)
                    .enabled(true)
                    .build();

            userRepository.save(adminUser);
            log.info("✅ Admin user created successfully");

            // Create a regular user for testing
            if (!userRepository.existsByUsername("user")) {
                User regularUser = User.builder()
                        .username("user")
                        .password(passwordEncoder.encode("user123"))
                        .role(User.Role.USER)
                        .enabled(true)
                        .build();

                userRepository.save(regularUser);
                log.info("✅ Regular user created successfully");
            }

            log.info("🎉 Initial user data loaded successfully");

        } catch (Exception e) {
            log.error("❌ Error loading initial user data: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to load initial user data", e);
        }
    }
}