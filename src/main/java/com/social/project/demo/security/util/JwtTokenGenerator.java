package com.social.project.demo.security.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.util.Date;

import static com.social.project.demo.security.util.JwtTokenUtil.encodeSecretKey;

@Component
@RequiredArgsConstructor
public class JwtTokenGenerator {

    private final String secretKey;
    private final long tokenExpireMilliseconds;

    public String generateToken(String username) {
        Date expireDate = new Date(System.currentTimeMillis() + tokenExpireMilliseconds);

        return Jwts.builder()
                .subject(username)
                .expiration(expireDate)
                .signWith(Keys.hmacShaKeyFor(encodeSecretKey(secretKey)))
                .compact();
    }
}