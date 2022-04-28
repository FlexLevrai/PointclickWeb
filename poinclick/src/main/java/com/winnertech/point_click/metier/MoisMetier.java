package com.winnertech.point_click.metier;

import java.util.List;

import com.winnertech.point_click.entities.Mois;

public interface MoisMetier {
	
	public Mois addMois(Mois m);
	public Mois updateMois(Long id);
	public void deleteMois(Long id);
	public List<Mois> listMois();
	public Mois activateMois(Long id);

}
