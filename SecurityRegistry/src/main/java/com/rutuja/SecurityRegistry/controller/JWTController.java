package com.rutuja.SecurityRegistry.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rutuja.SecurityRegistry.entity.LogInRequest;
import com.rutuja.SecurityRegistry.entity.MyUsers;
import com.rutuja.SecurityRegistry.service.JWTService;
import com.rutuja.SecurityRegistry.service.MyUserServices;

@RestController
@RequestMapping("/users")
public class JWTController {
	
	@Autowired
	private MyUserServices myuserservices;
	
	@Autowired
	private JWTService jwtservice;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/registration")
	private String Register(@RequestBody MyUsers myusers)
	{
		return myuserservices.register(myusers);
	}
	
	@PostMapping("/token")
	public String genrateToken(@RequestBody LogInRequest logInRequest) {
		Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(logInRequest.getName(), logInRequest.getPasscode()));
		if(authentication.isAuthenticated()) {
			return jwtservice.GenratedToken(logInRequest.getName());
		}return "Wrong User Name Or Password !!!!!";
	}
	
	@GetMapping("/valid")
	public String valid(@RequestParam String token)
	{
		jwtservice.ExtractallClaims(token);
		return "Token is valid";
	}

}
