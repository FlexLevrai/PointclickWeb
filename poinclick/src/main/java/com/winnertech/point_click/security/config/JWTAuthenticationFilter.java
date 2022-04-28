package com.winnertech.point_click.security.config;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.winnertech.point_click.security.Utilisateur;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
private AuthenticationManager authenticationManager;
	
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		Utilisateur utilisateur = null;
		try {
			utilisateur = new ObjectMapper().readValue(request.getInputStream(), Utilisateur.class);
			System.out.println("*****************************************");
			System.out.println("username : " +utilisateur.getUsername());
			System.out.println("password : " + utilisateur.getPassword());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	
		
		return authenticationManager.authenticate( new UsernamePasswordAuthenticationToken( utilisateur.getUsername(), utilisateur.getPassword()));
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		User springUser = (User) authResult.getPrincipal();
		String jwt = Jwts.builder()
				.setSubject(springUser.getUsername())
				.setExpiration( new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME) )
				.signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET)
				.claim("roles", springUser.getAuthorities()).compact();
	    response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+jwt);
	
	}

}
