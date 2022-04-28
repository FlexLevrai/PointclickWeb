package com.winnertech.point_click.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winnertech.point_click.entities.ExerciceJournalier;
import com.winnertech.point_click.metier.ExerciceJournalierMetier;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/exercice")
public class ExerciceJournalierController {
	
	@Autowired
	private ExerciceJournalierMetier exerciceJournalierMetier ;
	
	@PostMapping(value = "/save/heureArive")
	public ExerciceJournalier heureArriver(ExerciceJournalier e) {
		return exerciceJournalierMetier.heureArriver(e);
	}

}
