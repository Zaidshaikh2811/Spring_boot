package com.child1.hospital.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Component
public class JWTUtil {

    private final String SECRETE_KRY = "my-super-secure-jwt-secret-key-which-is-very-long";
    private final SecretKey secretKey= Keys.hmacShaKeyFor(SECRETE_KRY.getBytes());
    private final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    public String generateToken(String username) {
        // 1 min = 60000 ms
        // 1 hour = 3600000 ms
        long jwtExpirationInMs = 60000L;
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))
                .signWith(secretKey, signatureAlgorithm)
                .compact();

    }

    public String validateTokenAndGetUsername(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(secretKey)
                .build().
                parseClaimsJws(token)
                .getBody()
                .getSubject();

    }

    public Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean isTokenExpired(String token){
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        try {
            final String username = extractUsername(token);
            return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }



}
