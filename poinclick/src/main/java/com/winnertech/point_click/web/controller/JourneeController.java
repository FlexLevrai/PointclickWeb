package com.winnertech.point_click.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winnertech.point_click.entities.Annee;
import com.winnertech.point_click.entities.Journee;
import com.winnertech.point_click.metier.JourneeMetier;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/journee")
public class JourneeController {

	@Autowired
	private JourneeMetier JourneeMetier;
	
	@PostMapping(value = "/save")
	public Journee ajouterJournee(@RequestBody Journee p) {
		return JourneeMetier.addJournee(p);	
	}
	
	@GetMapping(value = "/edit/{id}")
	public Journee modifierJournee(@PathVariable Long id) {
		return JourneeMetier.updateJournee(id);
		
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		JourneeMetier.deleteJournee(id);
	}
	
	@GetMapping(value = "/active/{id}")
	public Journee activeJour(@PathVariable Long id) {
		return JourneeMetier.activateJour(id);
		
	}
	
	@GetMapping(value = "/list")
	public List<Journee> listJournee() {
		return JourneeMetier.listJournee();
		
	}
	
}
