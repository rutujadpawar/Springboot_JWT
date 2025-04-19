package com.rutuja.JWTService.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.rutuja.JWTService.filter.JwtFilter;
import com.rutuja.JWTService.service.MyUserService;

import jakarta.websocket.Session;

@Configuration
@EnableWebSecurity
public class Config {
	
	@Autowired
	private JwtFilter jwtFilter;
	
	@Autowired
	private MyUserService myUserService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception
	{
		return httpSecurity.csrf(csrf->csrf.disable())
				.authorizeHttpRequests(resitry->{
					resitry.requestMatchers("/User/register","/User/token","/User/valid").permitAll();
					resitry.anyRequest().authenticated();
				}).formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
				.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider())
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		// TODO Auto-generated method stub
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(myUserService);
		provider.setPasswordEncoder(PasswordEncoder());
		return provider;
	}

	@Bean
	public PasswordEncoder PasswordEncoder() {
		// TODO Auto-generated method stub
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
	{
		return config.getAuthenticationManager();
	}

}
