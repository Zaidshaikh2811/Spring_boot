package com.child1.oauth.repository;

import com.child1.oauth.entity.OAuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OAuthUserRepository extends JpaRepository<OAuthUser, Long> {
    // You can add custom query methods here if needed
}

