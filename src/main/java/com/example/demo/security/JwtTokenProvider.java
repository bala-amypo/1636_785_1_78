package com.example.demo.security;

import java.util.*;
import org.springframework.security.core.Authentication;

public class JwtTokenProvider {

    private final String secretKey;
    private final long validityInMs;

    public JwtTokenProvider(String secretKey, long validityInMs) {
        this.secretKey = secretKey;
        this.validityInMs = validityInMs;
    }

    public String generateToken(Authentication auth, Long userId, String role) {
        return auth.getName() + "|" + userId + "|" + role;
    }

    public String getUsernameFromToken(String token) {
        return token.split("\\|")[0];
    }

    public boolean validateToken(String token) {
        return token != null && token.contains("|");
    }

    public Map<String, Object> getAllClaims(String token) {
        String[] parts = token.split("\\|");
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", parts[0]);
        claims.put("userId", Long.parseLong(parts[1]));
        claims.put("role", parts[2]);
        return claims;
    }
}
