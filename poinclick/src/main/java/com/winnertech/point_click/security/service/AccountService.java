package com.winnertech.point_click.security.service;

import java.util.List;

import com.winnertech.point_click.security.Role;
import com.winnertech.point_click.security.Utilisateur;

public interface AccountService {

	public Utilisateur saveUtilisateur(Utilisateur utilisateur);
	public Role saveRole(Role  role);
	
	public Utilisateur editeUtilisateur(Long id);
	public Role editeRole(Long id);
	
	public void addRoleToUser( String username , String roleName);
	public Utilisateur getUtilisateur(String username);
	
	public List<Utilisateur>getUtilisateurs();
	public List<Role> getRoles();
}

