package com.gdsc.pknu.backend.domain.authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gdsc.pknu.backend.domain.member.Email;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.Date;

public class Jwt {

    private final String issuer;
    private final String secret;
    private final int expirySeconds;
    private final Algorithm algorithm;
    private final JWTVerifier jwtVerifier;

    public Jwt(String issuer, String secret, int expirySeconds) {
        this.issuer = issuer;
        this.secret = secret;
        this.expirySeconds = expirySeconds;
        this.algorithm = Algorithm.HMAC512(secret);
        this.jwtVerifier = JWT.require(algorithm)
                .withIssuer(issuer)
                .build();
    }

    public String generateToken(Claims claims){
        Date now = new Date();
        JWTCreator.Builder builder = JWT.create();
        builder.withIssuer(issuer);
        builder.withIssuedAt(now);
        if (expirySeconds > 0) {
            builder.withExpiresAt(new Date(now.getTime() + expirySeconds * 1_000L));
        }
        builder.withClaim("email", claims.userId);
        builder.withClaim("email", claims.email.getAddress());
        builder.withArrayClaim("roles", claims.roles);
        return builder.sign(algorithm);
    }


    static public class Claims {
        Long userId;
        Email email;
        String[] roles;
        Date iat;
        Date exp;

        private Claims() {
        }

        public static Claims of(long userId, Email email, String[] roles) {
            Claims claims = new Claims();
            claims.userId = userId;
            claims.email = email;
            claims.roles = roles;
            return claims;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                    .append("email", email)
                    .append("roles", Arrays.toString(roles))
                    .append("iat", iat)
                    .append("exp", exp)
                    .toString();
        }
    }

}
