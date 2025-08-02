package com.child1.rolebaseacc.repository;

import com.child1.rolebaseacc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

