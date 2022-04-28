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

import com.winnertech.point_click.entities.DetailJournee;
import com.winnertech.point_click.metier.DetailJourneeMetier;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/detail_journee")
public class DetailJourneeController {
	
	@Autowired
	private DetailJourneeMetier DetailJourneeMetier;
	
	@PostMapping(value = "/save")
	public DetailJournee ajouterDetailJournee(@RequestBody DetailJournee p) {
		return DetailJourneeMetier.addDetailJournee(p);	
	}
	
	@GetMapping(value = "/edit/{id}")
	public DetailJournee modifierDetailJournee(@PathVariable Long id) {
		return DetailJourneeMetier.updateDetailJournee(id);
		
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		DetailJourneeMetier.deleteDetailJournee(id);
	}
	
	@GetMapping(value = "/list")
	public List<DetailJournee> listDetailJournee() {
		return DetailJourneeMetier.listDetailJournee();
		
	}
	
	@GetMapping(value = "/list/personnel/{id}")
	public List<DetailJournee> listDetailJourneeParPersonnel(@PathVariable Long id) {
		return DetailJourneeMetier.listDetailJourneeParPersonnel(id);
		
	}

}
