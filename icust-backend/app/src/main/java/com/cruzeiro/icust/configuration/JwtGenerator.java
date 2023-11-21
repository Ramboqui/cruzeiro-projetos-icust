package com.cruzeiro.icust.configuration;

import com.cruzeiro.icust.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtGenerator {

	public String generateToken(Authentication authentication, String userType, User user) {
		String username = authentication.getName();
		Date currentDate = new Date();
		Date expiryDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXPIRATION);

		return Jwts.builder()
		           .setSubject(username)
		           .setIssuedAt(currentDate)
		           .setExpiration(expiryDate)
		           .claim("nome", user.getNome())
		           .claim("sobrenome", user.getSobrenome())
		           .signWith(Keys.hmacShaKeyFor(SecurityConstants.JWT_SECERT.getBytes(StandardCharsets.UTF_8)),
		                     SignatureAlgorithm.HS256)
		           .claim("usertype", userType)
		           .compact();
	}

	public String getUsernameFromJWT(String token) {
		Claims claims = Jwts.parserBuilder()
		                    .setSigningKey(
				                    Keys.hmacShaKeyFor(SecurityConstants.JWT_SECERT.getBytes(StandardCharsets.UTF_8)))
		                    .build()
		                    .parseClaimsJws(token)
		                    .getBody();
		return claims.getSubject();
	}

	public String getUserTypeFromJWT(String token) {
		Claims claims = Jwts.parserBuilder()
		                    .setSigningKey(
				                    Keys.hmacShaKeyFor(SecurityConstants.JWT_SECERT.getBytes(StandardCharsets.UTF_8)))
		                    .build()
		                    .parseClaimsJws(token)
		                    .getBody();
		return claims.get("usertype").toString();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder()
			    .setSigningKey(
					    Keys.hmacShaKeyFor(SecurityConstants.JWT_SECERT.getBytes(StandardCharsets.UTF_8)))
			    .build().parseClaimsJws(token);
			return true;
		} catch (Exception ex) {
			throw new AuthenticationCredentialsNotFoundException("JWT token is not valid " + token);
		}
	}
}
