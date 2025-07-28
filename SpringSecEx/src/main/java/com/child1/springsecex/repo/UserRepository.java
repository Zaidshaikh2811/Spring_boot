package com.child1.springsecex.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.child1.springsecex.modal.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.enabled = true")
    Optional<User> findActiveUserByUsername(@Param("username") String username);

    void deleteByUsername(String username);

}

