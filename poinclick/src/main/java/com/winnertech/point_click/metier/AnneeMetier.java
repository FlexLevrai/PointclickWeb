package com.winnertech.point_click.metier;

import java.util.List;

import com.winnertech.point_click.entities.Annee;

public interface AnneeMetier {
	
	public Annee addAnnee(Annee a);
	public Annee updateAnnee(Long id);
	public void deleteAnnee(Long id);
	public List<Annee> listAnnee();
	public Annee activateAnnee(Long id);

}
