package com.child1.hospital.utils;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JWTUtil {

    private final String SECRETE_KRY = "my-super-secure-jwt-secret-key-which-is-very-long";
    private final SecretKey secretKey= Keys.hmacShaKeyFor(SECRETE_KRY.getBytes());
    private final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    public String generateToken(String username) {
        // 1 hour
        long jwtExpirationInMs = 3600000L;
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
                .signWith(secretKey, signatureAlgorithm)
                .compact();

    }

    public String validateTokenAndGetUsername(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();


    }

}
