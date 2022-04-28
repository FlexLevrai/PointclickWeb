package com.winnertech.point_click.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.winnertech.point_click.security.Utilisateur;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	@Query("select u from Utilisateur u where u.username=:x")
	public Utilisateur findByUsername(@Param("x") String username);
	
}
