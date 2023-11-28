package com.social.project.demo.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.social.project.demo.security.util.JwtTokenUtil.encodeSecretKey;

@Component
@RequiredArgsConstructor
public class UserDetailsExtractor {

    private final String secretKey;
    private final UserDetailsService userDetails;

    public Optional<UserDetails> extractFromToken(String token) {
        try {
            var claimsJws = parseToken(token);
            var username = claimsJws.getPayload().getSubject();
            return Optional.ofNullable(userDetails.loadUserByUsername(username));
        } catch (Exception e) {
            throw new BadCredentialsException("Expired or invalid JWT token");
        }
    }

    public Jws<Claims> parseToken(String token) {
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(encodeSecretKey(secretKey)))
                .build()
                .parseSignedClaims(token);
    }
}
