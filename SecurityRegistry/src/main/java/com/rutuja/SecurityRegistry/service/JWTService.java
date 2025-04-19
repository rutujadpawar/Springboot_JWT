package com.rutuja.SecurityRegistry.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;



import org.springframework.stereotype.Service;

import com.rutuja.SecurityRegistry.entity.MyUsers;

@Service
public class JWTService {
	
	private static final String SECRET="5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";
			
			public String GeneratedToken(String username)
			{
				HashMap<String, Object> claims=new HashMap();
				return createToken(username,claims);
			}

			private String createToken(String username, HashMap<String, Object> claims) {
				// TODO Auto-generated method stub
				return 
			}

			

			public String GenratedToken(String name) {
				// TODO Auto-generated method stub
				
			}

			public void ExtractallClaims(String token) {
				// TODO Auto-generated method stub
				
			}
			

}
