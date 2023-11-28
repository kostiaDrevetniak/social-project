package com.social.project.demo.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigProperties {
    @Value("${security.jwt.token.secret-key}")
    private String secretKey;
    @Value("${security.jwt.token.expire-milliseconds}")
    private long tokenExpireMilliseconds;

    @Bean
    public String getSecretKey() {
        return secretKey;
    }

    @Bean
    public long getTokenExpireMilliseconds() {
        return tokenExpireMilliseconds;
    }
}
