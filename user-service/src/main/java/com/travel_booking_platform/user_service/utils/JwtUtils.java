package com.travel_booking_platform.user_service.utils;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    private final String SECRET_KEY = "amit's secret key";
    private final long EXPIRATION_TIME = 86400000;

    public String generateToken(String userName){
        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();
    }

    public String extractUserName(String token){
            return Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();

    }

    public boolean validateToken(String token){
        try {
            Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY.getBytes())
                    .build()
                    .parseClaimsJws(token);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
