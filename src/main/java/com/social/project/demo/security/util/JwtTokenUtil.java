package com.social.project.demo.security.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class JwtTokenUtil {
    public static byte[] encodeSecretKey(String secretKey) {
        return Base64.getEncoder()
                .encodeToString(secretKey.getBytes())
                .getBytes();
    }
}
