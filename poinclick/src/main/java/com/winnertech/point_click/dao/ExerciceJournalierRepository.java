package com.winnertech.point_click.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.winnertech.point_click.entities.ExerciceJournalier;

public interface ExerciceJournalierRepository extends JpaRepository<ExerciceJournalier, Long> {
	
	@Query("select e from ExerciceJournalier e where e.detailJournee.journee.etat = true and e.detailJournee.personnel.id = :x")
	public ExerciceJournalier activeJour(@Param("x") Long id);

}
