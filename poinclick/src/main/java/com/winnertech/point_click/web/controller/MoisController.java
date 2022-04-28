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

import com.winnertech.point_click.entities.Mois;
import com.winnertech.point_click.metier.MoisMetier;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/mois")
public class MoisController {
	
	@Autowired
	private MoisMetier MoisMetier;
	
	@PostMapping(value = "/save")
	public Mois ajouterMois(@RequestBody Mois p) {
		return MoisMetier.addMois(p);	
	}
	
	@GetMapping(value = "/edit/{id}")
	public Mois modifierMois(@PathVariable Long id) {
		return MoisMetier.updateMois(id);
		
	}
	
	@GetMapping(value = "/active/{id}")
	public Mois mactiveMois(@PathVariable Long id) {
		return MoisMetier.activateMois(id);
		
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		MoisMetier.deleteMois(id);
	}
	
	@GetMapping(value = "/list")
	public List<Mois> listMois() {
		return MoisMetier.listMois();
		
	}

}
