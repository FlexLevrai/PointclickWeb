package com.winnertech.point_click.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winnertech.point_click.security.RegisterForm;
import com.winnertech.point_click.security.Role;
import com.winnertech.point_click.security.Utilisateur;
import com.winnertech.point_click.security.service.AccountService;



@RestController @CrossOrigin("*")
@RequestMapping("/api/security/")
public class SecurityController {

		@Autowired
		private AccountService  accountService;
				
		
		@PostMapping(value = "/register" )
		public Utilisateur register(@RequestBody RegisterForm registerForm)
		{
			if (!registerForm.getPassword().equals(registerForm.getPassword())) throw new RuntimeException("Vous n'avez pas comfirmer votre password") ;
			Utilisateur utilisateur = accountService.getUtilisateur(registerForm.getUsername());
			if (utilisateur != null) throw new RuntimeException("Cet utilisateur exite deja") ;
			Utilisateur u = new Utilisateur();
			
			u.setDateSave(new Date());
			u.setPassword(registerForm.getPassword());
			u.setUsername(registerForm.getUsername());
			u.setName(registerForm.getName());
			accountService.saveUtilisateur(u);
			
			accountService.addRoleToUser(u.getUsername(), "USER");
			return u;
		}
		
		
		
		@PostMapping(value = "/save/users" )
		public Utilisateur saveUtilisateur(@RequestBody Utilisateur u)
		{
			return accountService.saveUtilisateur(u);
		}

		@GetMapping(value = "/edite/users/{id}")
		public Utilisateur updateUtilisateur(@PathVariable(value ="id") Long id)
		{
			return accountService.editeUtilisateur(id);
		}
		
		@GetMapping( value = "/liste/users")
		public List<Utilisateur> ListeUtilisateur() 
		{
			return accountService.getUtilisateurs();
		}
		

		/**
		 * @author RogerBanki
		 * Controlleur  gestion des roles des utilisateurs
		 */
		
		@PostMapping(value = "/save/roles" )
		public Role saveRole(@RequestBody Role r)
		{
			return accountService.saveRole(r);
		}
		
		@GetMapping( value = "/edite/roles/{id}")
		public Role updateRoles ( @PathVariable(value ="id") Long id) 
		{
			return accountService.editeRole(id);
		}

		
		@GetMapping( value = "/liste/roles")
		public List<Role> ListeRole() 
		{
			return accountService.getRoles();
		}
}
