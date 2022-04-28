package com.winnertech.point_click.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.winnertech.point_click.entities.Annee;

public interface AnneeRepository extends JpaRepository<Annee, Long> {
	
	
	@Query("Select a from Annee a where a.etat = true")
	public Annee anneeActif();
	

}
