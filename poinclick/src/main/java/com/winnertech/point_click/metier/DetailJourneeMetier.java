package com.winnertech.point_click.metier;

import java.util.List;

import com.winnertech.point_click.entities.DetailJournee;

public interface DetailJourneeMetier {
	
	public DetailJournee addDetailJournee(DetailJournee j);
	public DetailJournee updateDetailJournee(Long id);
	public void deleteDetailJournee(Long id);
	public List<DetailJournee> listDetailJournee();
	public List<DetailJournee> listDetailJourneeParPersonnel(Long id);
}
