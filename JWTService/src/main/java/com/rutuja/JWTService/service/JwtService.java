package com.rutuja.JWTService.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	private static final String SECRET="5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";
	
	
	public String GeneratedToken(String username) {
		// TODO Auto-generated method stub
		HashMap<String, Object> claims=new HashMap();
		return createtoken(username,claims);
	}

	private String createtoken(String username, HashMap<String, Object> claims) {
		// TODO Auto-generated method stub
		return Jwts.builder().setSubject(username)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
				.signWith(getsignkey(), SignatureAlgorithm.HS256)
				.compact();
	}

	private Key getsignkey() {
		// TODO Auto-generated method stub
		byte[] keyarray=Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyarray);
	}

	public String ExtractUsername(String token) {
		// TODO Auto-generated method stub
		return extractclaims(token,Claims::getSubject);
	}

	

	public boolean istokenvalid(String token, UserDetails userDetails) {
		// TODO Auto-generated method stub
		String username=ExtractUsername(token);
		return username.equals(userDetails.getUsername())&&!isTokenExpired(token);
	}

	public  Claims ExtractallClaims(String token) {
		// TODO Auto-generated method stub
		return Jwts.parserBuilder().setSigningKey(getsignkey()).build().parseClaimsJws(token).getBody();
	}
	
	public <T> T extractclaims(String token, Function<Claims, T> claimResolver)
	{
		Claims claims=ExtractallClaims(token);
		return claimResolver.apply(claims);
	}
	
	public Date ExtractExpiration(String token)
	{
		return extractclaims(token, Claims::getExpiration);
	}
	
	public boolean isTokenExpired(String token)
	{
		return ExtractExpiration(token).before(new Date());
	}
	

	

}
