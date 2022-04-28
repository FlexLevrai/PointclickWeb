package com.winnertech.point_click.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winnertech.point_click.dao.AnneeRepository;
import com.winnertech.point_click.dao.MoisRepository;
import com.winnertech.point_click.dao.PersonnelRepository;
import com.winnertech.point_click.entities.Annee;
import com.winnertech.point_click.entities.Mois;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/dashbord")
public class DashbordController {
	
	@Autowired
	private AnneeRepository anneeRepository;
	
	
	@Autowired
	private MoisRepository moisRepository;
	
	@Autowired
	private PersonnelRepository personnelRepository;
	
	
	@GetMapping(value = "/annneEncours")
	public String anneeEncours() {
		
		Annee a = anneeRepository.anneeActif();
		
		String an = a.getLibelle();
		
		System.out.println("L'annee est : ");
		
		System.out.println(an);
		
		return an;
	}
	
	@GetMapping(value = "/moisEncours")
	public int personnel() {
		
         Integer per = personnelRepository.nombrePersonnel();
		
		System.out.println(per);
		
		System.out.println("Le nombre d'homme est : ");
		
		int valeurper = 0;
		
		if (per != null) {
			valeurper = per;
		}
		
		return valeurper;
	}
	
	@GetMapping(value = "/homme")
	public int homme() {
		
		Integer hom = personnelRepository.nombreHomme();
		
		System.out.println(hom);
		
		System.out.println("Le nombre d'homme est : ");
		
		int valeurHom = 0;
		
		if (hom != null) {
			valeurHom = hom;
		}
		
		return valeurHom;
	}
	
	@GetMapping(value = "/femme")
	public int femme() {
		
		Integer fem = personnelRepository.nombreFemme();
		
		System.out.println("Le nombre de femme est : ");
		
		System.out.println(fem);
		
		int valeurFem = 0;
		
		if (fem != null) {
			valeurFem = fem;
		}
		
		return valeurFem;
	}
	
	

}
