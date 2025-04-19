package com.rutuja.JWTService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rutuja.JWTService.entity.LogInRequest;
import com.rutuja.JWTService.entity.MyUser;
import com.rutuja.JWTService.service.JwtService;
import com.rutuja.JWTService.service.MyUserService;

@RestController
@RequestMapping("/User")
public class JController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private MyUserService myUserService;
	
	
	@PostMapping("/register")
	public String register(@RequestBody MyUser myUser)
	{
		return myUserService.register(myUser);
	}
	
	@PostMapping("/token")
	public String generateToken(@RequestBody LogInRequest logInRequest)
	{
		Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(logInRequest.getUsername(),logInRequest.getPassword()));
		
		if(authentication.isAuthenticated())
		{
			return jwtService.GeneratedToken(logInRequest.getUsername());
		}
		return "Wrong credentials";
	}
	
	@PostMapping("/valid")
	public String valid(@RequestParam String token)
	{
		jwtService.ExtractallClaims(token);
		return "Token is valid";
	}

}
