package com.child1.springsecex.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.child1.springsecex.modal.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);




}

