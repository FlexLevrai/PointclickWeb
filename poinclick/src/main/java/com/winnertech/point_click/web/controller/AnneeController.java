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
import com.winnertech.point_click.metier.AnneeMetier;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/annee")
public class AnneeController {
	
	@Autowired
	private AnneeMetier AnneeMetier;
	
	@PostMapping(value = "/save")
	public Annee ajouterAnnee(@RequestBody Annee p) {
		return AnneeMetier.addAnnee(p);	
	}
	
	@GetMapping(value = "/edit/{id}")
	public Annee modifierAnnee(@PathVariable Long id) {
		return AnneeMetier.updateAnnee(id);
		
	}
	
	@GetMapping(value = "/active/{id}")
	public Annee activeAnnee(@PathVariable Long id) {
		return AnneeMetier.activateAnnee(id);
		
	}
	
	
	@DeleteMapping(value = "/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		AnneeMetier.deleteAnnee(id);
	}
	
	@GetMapping(value = "/list")
	public List<Annee> listAnnee() {
		return AnneeMetier.listAnnee();
		
	}

}
