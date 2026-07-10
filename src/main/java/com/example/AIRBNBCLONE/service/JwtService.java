package com.example.AIRBNBCLONE.service;

import org.springframework.stereotype.Service;

import com.example.AIRBNBCLONE.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;


@Service
public class JwtService {

    @Value("${jwt.secretKey}")
    private String jwtSecretKey;

    public SecretKey getJwtSecretKey() {
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateAccessToken(User user){
        return Jwts.builder()
                  .subject(user.getId().toString())
                  .claim("email", user.getEmail())
                  .claim("roles", user.getRoles().toString())
                  .issuedAt(new Date())
                  .expiration(new Date(System.currentTimeMillis()+1000*60*10))
                  .signWith(getJwtSecretKey())
                  .compact();
    }

    public String generateRefreshToken(User user){
        return Jwts.builder()
                .subject(user.getId().toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000L+60*60*24*30*6))
                .signWith(getJwtSecretKey())
                .compact();
    }

    public Long getUserIdFromToken(String token){
        Claims claims=Jwts.parser()
                         .verifyWith(getJwtSecretKey())
                         .build()
                         .parseSignedClaims(token)
                         .getPayload();
        return Long.valueOf(claims.getSubject());
    }


}
