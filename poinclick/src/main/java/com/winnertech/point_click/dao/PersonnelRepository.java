package com.winnertech.point_click.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.winnertech.point_click.entities.Personnel;

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
	
	@Query("select count(p.id) from Personnel p where p.sexe = 'M'")
	public int nombreHomme();
	
	@Query("select count(p.id) from Personnel p where p.sexe = 'F'")
	public int nombreFemme();
	
	@Query("select count(p.id) from Personnel p")
	public int nombrePersonnel();

}
