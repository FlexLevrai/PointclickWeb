package com.winnertech.point_click.metier;

import java.util.List;

import com.winnertech.point_click.entities.Personnel;

public interface PersonnelMetier {
	
	public Personnel addPersonnel(Personnel p);
	public Personnel updatePersonnel(Long id);
	public void deletePersonnel(Long id);
	public List<Personnel> listPersonnel();

}
