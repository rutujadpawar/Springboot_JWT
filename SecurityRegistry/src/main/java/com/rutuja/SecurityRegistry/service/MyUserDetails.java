package com.rutuja.SecurityRegistry.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.rutuja.SecurityRegistry.entity.MyUsers;

public class MyUserDetails implements UserDetails {

	private String username;
	private String passcode;
	private List<GrantedAuthority> authorities;
	
	public MyUserDetails(MyUsers myusers)
	{
		this.username=myusers.getName();
		this.passcode=myusers.getPasscode();
		this.authorities=Arrays.stream(myusers.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return passcode;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
