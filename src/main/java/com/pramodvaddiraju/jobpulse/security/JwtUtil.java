package com.pramodvaddiraju.jobpulse.security;

import com.pramodvaddiraju.jobpulse.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // Secret key and expiration are read from application.properties
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expirationTime;

    // Generate JWT token based on User info
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail()) // Unique identity
                .claim("role", user.getRole()) // Add custom claim
                .setIssuedAt(new Date()) // Token creation time
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime)) // Token expiry
                .signWith(getKey()) // Sign with secret key
                .compact();
    }

    // Validate token — returns true if valid
    public boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token);
            return true; // No exception = valid
        } catch (JwtException ex) {
            return false; // Invalid token
        }
    }

    // Extract email (subject) from token
    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    // Internal helper method to get signing key from string
    private Key getKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }
}
