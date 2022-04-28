package com.winnertech.point_click.security.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winnertech.point_click.security.Role;
import com.winnertech.point_click.security.Utilisateur;
import com.winnertech.point_click.security.dao.RoleRepository;
import com.winnertech.point_click.security.dao.UtilisateurRepository;


@Service @Transactional
public class IAccountService implements AccountService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Utilisateur saveUtilisateur(Utilisateur utilisateur) {

		String hashPassword = bCryptPasswordEncoder.encode(utilisateur.getPassword());
		utilisateur.setDateSave(new Date());
		utilisateur.setPassword(hashPassword);
		
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public Role saveRole(Role role) {
		
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
	
		Role role = roleRepository.findByName(roleName);
		Utilisateur  utilisateurs = utilisateurRepository.findByUsername(username);
		
		utilisateurs.getRoles().add(role);
	}

	@Override
	public Utilisateur getUtilisateur(String username) {
		
		return  utilisateurRepository.findByUsername(username);
	}

	@Override
	public List<Utilisateur> getUtilisateurs() {
		
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur editeUtilisateur(Long id) {
		
		return utilisateurRepository.findById(id).get();
	}

	@Override
	public Role editeRole(Long id) {
		
		return roleRepository.findById(id).get();
	}

	@Override
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

}
