package com.pfe.ebankapp.security;


import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Service
public class TokenService {


    @Value("${jwt.secret.string:bXktc3VwZXItc2VjcmV0LWtleS10aGF0LWlzLXZlcnktbG9uZy1hbmQtc2VjdXJlLTIwMjY=}")
    private String JWT_SECRETE;


    @Value("${jwt.expiration.time:86400000}") // 24 heures par défaut si la variable est introuvable
    private long EXPIRATION_TIME;


    private SecretKey key;


    @PostConstruct
    private void init() {
           this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(JWT_SECRETE));
    }


    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsTFunction) {
        return claimsTFunction.
                apply(Jwts.parser().verifyWith(key).
                        build().
                        parseSignedClaims(token)
                        .getPayload());
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractClaims(token, Claims::getExpiration).before(new Date());
    }

}













