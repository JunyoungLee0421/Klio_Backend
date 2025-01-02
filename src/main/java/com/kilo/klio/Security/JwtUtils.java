package com.kilo.klio.Security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

import java.security.Key;

import java.util.Date;

@Component
public class JwtUtils {

    private final String jwtSecret;
    private final long jwtExpirationMs = 3600 * 1000; // 1 hour
    private final Key key;

    public JwtUtils() {
        Dotenv dotenv = Dotenv.configure().load();
        this.jwtSecret = dotenv.get("JWT_SECRET");
        this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String generateToken(String email) {
    return Jwts.builder()
        .setSubject(email)
        .setIssuedAt(new Date())
        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
        .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()), SignatureAlgorithm.HS512)
        .compact();
}

     public String getEmailFromJwtToken(String token) {
        // get email from token
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String token) {
        try {
            // parse claims from token
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            // catch exception if token is invalid
            System.err.println("Invalid JWT token: " + e.getMessage());
            return false;
        }
    }
}
