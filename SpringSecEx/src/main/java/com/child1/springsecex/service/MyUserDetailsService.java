package com.child1.springsecex.service;

import com.child1.springsecex.modal.User;
import com.child1.springsecex.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    public MyUserDetailsService(UserRepository userRepository ) {
        this.userRepository = userRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) {
         System.out.println("🚀 Loading user by username: " + username);

         User user1= userRepository.findByUsername(username) ;

        if (user1 != null) {
            System.out.println(org.springframework.security.core.userdetails.User
                    .withUsername(user1.getUsername())
                    .password(user1.getPassword())
                    .roles(user1.getRole())
                    .build());
            return org.springframework.security.core.userdetails.User
                    .withUsername(user1.getUsername())
                    .password(user1.getPassword())
                    .roles(user1.getRole())
                    .build();
        }



          throw new UsernameNotFoundException("User not found");
    }



}
