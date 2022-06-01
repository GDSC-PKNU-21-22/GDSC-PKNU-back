package com.gdsc.pknu.backend.config;

import com.gdsc.pknu.backend.domain.authentication.Jwt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig {
    @Value("${jwt.token.issuer}")
    private String issuer;
    @Value("${jwt.token.secret}")
    private String secret;
    @Value("${jwt.token.expirySeconds}")
    private int expirySeconds;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Jwt jwt(){
        return new Jwt(issuer, secret, expirySeconds);
    }
}
