package com.child1.security.service;

import com.child1.security.model.Student;
import com.child1.security.repository.StudentRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private StudentRepo studentRepo;

    public CustomUserDetailsService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student stu=studentRepo.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("User Not Found: " + username));

        List<SimpleGrantedAuthority> authorities =
                List.of(new SimpleGrantedAuthority("ROLE_" + stu.getRole()));
        System.out.println("Authorities: " + authorities);
        return  new User(stu.getEmail(),stu.getPassword(),authorities);



    }
}
