package com.winnertech.point_click.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.winnertech.point_click.entities.Journee;

public interface JourneeRepository extends JpaRepository<Journee, Long> {
	
	@Query("select j from Journee j where j.etat = true")
	public Journee activeJournee();

}
