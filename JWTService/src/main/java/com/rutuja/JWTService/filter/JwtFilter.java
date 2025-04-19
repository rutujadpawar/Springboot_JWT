package com.rutuja.JWTService.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.rutuja.JWTService.service.JwtService;
import com.rutuja.JWTService.service.MyUserService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{

	@Autowired
	private JwtService jwtService;
	@Autowired
	private MyUserService myUserService;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Username=null;
		String token=null;
		String AutoHeader=request.getHeader("Authorization");
		
		if(AutoHeader!=null &&AutoHeader.startsWith("Bearer ")) {
			token=AutoHeader.substring(7);
			Username=jwtService.ExtractUsername(token);
		}
		
		if(Username!=null & SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails userDetails=myUserService.loadUserByUsername(Username);
			
			if(jwtService.istokenvalid(token,userDetails))
			{
				UsernamePasswordAuthenticationToken autToken=new UsernamePasswordAuthenticationToken(userDetails,null ,userDetails.getAuthorities());
				autToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(autToken);
				
			}
		}
		filterChain.doFilter(request, response);
	}

}
