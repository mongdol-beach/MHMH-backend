package com.mondol.mhmh.auth.jwt;

import com.mondol.mhmh.auth.principal.PrincipalDetail;
import com.mondol.mhmh.auth.principal.PrincipalUserDetailsService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    @Value("${auth.jwt.secret}")
    private String secretKey;

    @Value("${auth.jwt.exp.access}")
    private Long accessToken;

    @Value("${auth.jwt.exp.refresh}")
    private Long refreshToken;

    private final String HEADER = "Authorization";

    private final String PREFIX = "Bearer ";

    private final PrincipalUserDetailsService principalUserDetailsService;

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateAccessToken(String id, String email) {
        return Jwts.builder()
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + accessToken * 1000))
                .subject(id)
                .claim("type", "access")
                .claim( "email", email)
                .signWith(this.getSigningKey())
                .compact();
    }

    public String generateRefreshToken(String id) {
        return Jwts.builder()
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + refreshToken * 1000))
                .subject(id)
                .claim("type", "refresh")
                .signWith(this.getSigningKey())
                .compact();
    }

    public String resolveToken(HttpServletRequest httpServletRequest) {
        String bearerToken = httpServletRequest.getHeader(HEADER);

        if(bearerToken != null && bearerToken.startsWith(PREFIX)) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith(this.getSigningKey())
                    .build().parseSignedClaims(token).getPayload().getSubject();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getId(String token) {
        try {
            return Jwts.parser().verifyWith(this.getSigningKey())
                    .build().parseSignedClaims(token).getPayload().getSubject();
        } catch (Exception e) {
            throw new RuntimeException(e);
//            throw new InvalidTokenException();
        }
    }
    public Authentication getAuthentication(String token) {
       PrincipalDetail authDetails = principalUserDetailsService.loadUserByUsername(getId(token));
        return new UsernamePasswordAuthenticationToken(authDetails, "", authDetails.getAuthorities());
    }

}
