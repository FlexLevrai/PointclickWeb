package com.winnertech.point_click.metier;

import java.util.List;


import com.winnertech.point_click.entities.Journee;


public interface JourneeMetier {
	
	public Journee addJournee(Journee j);
	public Journee updateJournee(Long id);
	public void deleteJournee(Long id);
	public List<Journee> listJournee();
	public Journee activateJour(Long id);

}
