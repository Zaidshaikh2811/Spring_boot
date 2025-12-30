package com.child1.hospital.config;


import com.child1.hospital.repository.AdminRepository;
import com.child1.hospital.service.impl.CustomUserDetailsService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableCaching
@EnableScheduling
public class AppConfig {

    @Value("${db-username}")
    private String username;
    @Value("${db-password}")
    private String password;


    private final EmailConfig emailConfig;

    public AppConfig(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
        System.out.println("Email Host from AppConfig: " + emailConfig.getHost());
        System.out.println("from address: " + emailConfig.getFrom().getAddress());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService(AdminRepository adminRepository) {
//        return new CustomUserDetailsService(adminRepository);
//    }

    @PostConstruct
    public void activeProfile() {
        System.out.println("Active Profile: " + username + " - " + password);
    }


    @Bean
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(authProvider);
    }
}
