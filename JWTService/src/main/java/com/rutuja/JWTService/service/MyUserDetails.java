package com.rutuja.JWTService.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.rutuja.JWTService.entity.MyUser;

public class MyUserDetails implements UserDetails {

	
	private String username;
	private String password;
	private List<GrantedAuthority> grantedAuthorities;
	
	
	public MyUserDetails(MyUser myUser)
	{
		this.username=myUser.getUsername();
		this.password=myUser.getPassword();
		this.grantedAuthorities=Arrays.stream(myUser.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	

}
