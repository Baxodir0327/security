package com.example.security.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenUtil {

//    public static final String SECRET_KEY = "7134743777217A25432A462D4A614E645267556B58703272357538782F413F44";
    public static final String SECRET_KEY = "ce2f983f33a1aac2ccdc2b00ca233e9264055459a06b1518f485352fc5352644";
//    public static final String SECRET_KEY = "69e258a1f052ff370061abca90eed14673dae7d81e91e0891aa32764fb1e49fc";

    public String generateToken(@NonNull String username) {

        return Jwts.builder().setSubject(username)
                .setIssuer("Mendirman osha")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                .signWith(signKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    public boolean isValid(@NonNull String token) {
        try {
            Claims claims = getClaims(token);
            return claims.getExpiration().after(new Date());
        } catch (ExpiredJwtException | IllegalArgumentException | SignatureException | MalformedJwtException |
                 UnsupportedJwtException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String gentUsername(@NonNull String token) {
        Claims claims = getClaims(token);
        return claims.getSubject();
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(signKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key signKey() {
        byte[] decode = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(decode);
    }
}
