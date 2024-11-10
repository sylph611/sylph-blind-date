package org.sylph.blinddate.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.sylph.blinddate.domain.User;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    // JWT 비밀 키 (이 키는 절대로 노출되어서는 안 됩니다)
    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    // JWT 토큰 만료 시간 (예: 1시간)
    private static final long JWT_EXPIRATION = 60 * 60 * 1000;  // 1 hour

    // JWT 생성
    public String generateToken(Authentication authentication) {
        User userPrincipal = (User) authentication.getPrincipal();

        // JWT의 Claims 설정 (이메일, 권한 등)
        return Jwts.builder()
                .subject(userPrincipal.getUsername())  // 사용자 이름 (Subject)
                .claim("role", userPrincipal.getAuthorities())  // 사용자 권한
                .issuedAt(new Date())  // 토큰 발행 시간
                .expiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))  // 만료 시간
                .signWith(SECRET_KEY)  // 서명
                .compact();
    }

    // JWT에서 사용자 이름 추출
    public String getUsernameFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getSubject();
    }

    // JWT에서 클레임 추출
    private Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    // JWT 만료 시간 추출
    public Date getExpirationDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

    // JWT 토큰이 만료되었는지 확인
    public boolean isTokenExpired(String token) {
        Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    // 토큰 유효성 검사
    public boolean validateToken(String token, Authentication authentication) {
        String username = getUsernameFromToken(token);
        User user = (User) authentication.getPrincipal();
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }

}