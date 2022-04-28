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

import com.winnertech.point_click.entities.Personnel;
import com.winnertech.point_click.metier.PersonnelMetier;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/personnel")
public class PersonnelController {
	
	@Autowired
	private PersonnelMetier personnelMetier;
	
	@PostMapping(value = "/save")
	public Personnel ajouterPersonnel(@RequestBody Personnel p) {
		return personnelMetier.addPersonnel(p);	
	}
	
	@GetMapping(value = "/edit/{id}")
	public Personnel modifierPersonnel(@PathVariable Long id) {
		return personnelMetier.updatePersonnel(id);
		
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void supprimer(@PathVariable Long id) {
		personnelMetier.deletePersonnel(id);
	}
	
	@GetMapping(value = "/list")
	public List<Personnel> listPersonnel() {
		return personnelMetier.listPersonnel();
		
	}

}
