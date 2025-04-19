package com.rutuja.SecurityRegistry.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rutuja.SecurityRegistry.entity.MyUsers;
import com.rutuja.SecurityRegistry.repository.Repo;

@Service
public class MyUserServices {
	
	@Autowired
	private Repo repo;
	
	@Autowired
	private PasswordEncoder passwordencoder;
	
	public UserDetails LoadUserByUsername(String username) {
		Optional<MyUsers> optional=repo.findByName(username);
		if(optional.isPresent())
		{
			return optional.map(MyUserDetails::new).get();
		}
		return null;
	}
	
	public String register(MyUsers myusers)
	{
		myusers.setPasscode(passwordencoder.encode(myusers.getPasscode()));
		repo.save(myusers);
		return "User Successfully Registered!!";
	}
	

}
