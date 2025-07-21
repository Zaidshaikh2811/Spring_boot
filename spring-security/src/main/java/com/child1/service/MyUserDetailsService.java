package com.child1.service;

import com.child1.modal.Student;
import com.child1.modal.UserPrincipal;
import com.child1.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepo student;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


       Student stu= student.findByUsername(username);

        if (stu == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }


        return new UserPrincipal(stu);





    }
}
