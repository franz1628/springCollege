package com.example.inicio.config;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;

@Component
public class JwtUtil {

    private final JwtConfig jwtConfig;

    public JwtUtil(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    public String generateToken(String username) {
        Key key = new SecretKeySpec(Base64.getDecoder().decode(Base64.getEncoder().encodeToString(jwtConfig.getKey().getBytes())), 
                                    SignatureAlgorithm.HS512.getJcaName());

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) 
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public String extractUsername(String token) {
        Key key = new SecretKeySpec(Base64.getDecoder().decode(Base64.getEncoder().encodeToString(jwtConfig.getKey().getBytes())), 
                                    SignatureAlgorithm.HS512.getJcaName());

        Claims claims = Jwts.parserBuilder()
                            .setSigningKey(key) 
                            .build()
                            .parseClaimsJws(token)
                            .getBody();

        return claims.getSubject();
    }

    public boolean isTokenValid(String token, String username) {
        return username.equals(extractUsername(token)) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {
        Key key = new SecretKeySpec(Base64.getDecoder().decode(Base64.getEncoder().encodeToString(jwtConfig.getKey().getBytes())), 
                                    SignatureAlgorithm.HS512.getJcaName());
    
        Claims claims = Jwts.parserBuilder()
                            .setSigningKey(key) 
                            .build()
                            .parseClaimsJws(token)
                            .getBody();
    
        return claims.getExpiration().before(new Date());
    }
}
