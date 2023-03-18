package com.proj.MusicPlayer.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    @Value("${spring.data.secret.key}")
    private String SECRET_KEY;

   /* @Autowired
    private TokenValidityRepo tokenValidity;

*/
    public String extractUserByUsername(String token){
        return extractAllClaims(token, Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractAllClaims(token, Claims::getExpiration);
    }

    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims,userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims,String username){
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ 10000*60*60*10))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();
    }

    private <T> T extractAllClaims(String token, Function<Claims, T> claimsTFunction){
        final Claims claims = extractClaims(token);
        return claimsTFunction.apply(claims);
    }

    private Claims extractClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJwt(token).getBody();
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUserByUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}
