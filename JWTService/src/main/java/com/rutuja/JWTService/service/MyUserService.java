package com.rutuja.JWTService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rutuja.JWTService.entity.MyUser;
import com.rutuja.JWTService.repository.Repo;

@Service
public class MyUserService implements UserDetailsService {

	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private Repo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<MyUser> optional=repo.findByusername(username);
		if(optional.isPresent())
		{
			return optional.map(MyUserDetails::new).get();
		}
		return null;
	}
	
	public String register(MyUser myUser)
	{
		myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
		repo.save(myUser);
		return "USer Successfully registered!!";
	}

}
