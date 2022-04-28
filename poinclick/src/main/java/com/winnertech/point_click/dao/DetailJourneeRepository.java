package com.winnertech.point_click.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.winnertech.point_click.entities.DetailJournee;

public interface DetailJourneeRepository extends JpaRepository<DetailJournee, Long> {
	
	@Query("select d from DetailJournee d where d.personnel.id = :x")
	public List<DetailJournee> listDetailJourneeByPersonnel(@Param("x") Long id);

}
