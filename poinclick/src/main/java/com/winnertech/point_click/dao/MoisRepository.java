package com.winnertech.point_click.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.winnertech.point_click.entities.Mois;

public interface MoisRepository extends JpaRepository<Mois, Long> {
	
	@Query("select m from Mois m where m.etat = true")
	public Mois activeMois();
	
	@Query("select m.libelle from Mois m where m.etat = true")
	public String moisEncours();

}
