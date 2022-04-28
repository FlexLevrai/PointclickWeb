package com.winnertech.point_click.security.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winnertech.point_click.security.Utilisateur;



@Service @Transactional
public class UtilisteurService implements UserDetailsService {

	@Autowired
	private AccountService accountService;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Utilisateur utilisateur =  accountService.getUtilisateur(username);
		if ( utilisateur == null ) throw new UsernameNotFoundException(username);
		{
			Collection<GrantedAuthority> authorities = new  ArrayList<>();
			utilisateur.getRoles().forEach(r-> {
				authorities.add(new SimpleGrantedAuthority(r.getName()));
			});
			
			return  new User(utilisateur.getUsername(), utilisateur.getPassword(),authorities);
		}
		
	}

}
