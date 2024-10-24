package com.malunjkar.security;

import com.malunjkar.encryption.JwtKeyProvider;
import com.malunjkar.encryption.RSAService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class JwtUtil {


    @Value("${jwt.secretKey}")
    private String secret;

    @Value("${jwt.expirationTime}")
    private long expirationTime;

    private final JwtKeyProvider jwtKeyProvider;


    public String generateToken(String username) throws Exception {
        System.out.println("Adesh");
        PrivateKey privateKey = jwtKeyProvider.getPrivateKey();

        return Jwts.builder()
                .claims(CustomClaims.of(username))
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(privateKey, Jwts.SIG.RS256)
                .compact();
    }


    public String getSubjectFromToken(String token) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PublicKey publicKey = jwtKeyProvider.getPublicKey();

        return Jwts.parser()
                .verifyWith(publicKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public String getUsernameAndValidateTokenOrElseTrow(String token) throws Exception {
        String subject = getSubjectFromToken(token);
        if (validateToken(token, subject)) {
            return subject;
        }
        throw new Exception("Invalid token");


    }

    public boolean validateToken(String token, String username) {
        final String usernameFromToken = extractUsername(token);
        return (username.equals(usernameFromToken) && !isTokenExpired(token));
    }

//    private boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }

//    private Date extractExpiration(String token) {
//        return Jwts.parser().verifyWith(secret).parseClaimsJws(token).getBody().getExpiration();
//    }

//    public String extractUsername(String token) {
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
//    }

    public Claims extractClaim(String token) throws ExpiredJwtException {
        try {
            return Jwts.parser()
                    .verifyWith(RSAService.getPublicKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractClaim(token);
        return claimsResolver.apply(claims);
    }

    public String extractUsername(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public boolean isTokenExpired(String token) {
        return getClaimFromToken(token, Claims::getExpiration).before(new Date(System.currentTimeMillis()));
    }
}
