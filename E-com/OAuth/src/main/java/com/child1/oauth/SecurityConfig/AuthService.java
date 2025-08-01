package com.child1.oauth.SecurityConfig;

import com.child1.oauth.entity.OAuthUser;
import com.child1.oauth.repository.OAuthUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final OAuthUserRepository oAuthUserRepository;

    public String handleOAuth2LoginRequest(OAuth2User oauth2User, String registrationId) {
        String name = oauth2User.getAttribute("name");
        String email = oauth2User.getAttribute("email");
        OAuthUser user = new OAuthUser(name, email, registrationId);
        oAuthUserRepository.save(user);
        return email;
    }
}
