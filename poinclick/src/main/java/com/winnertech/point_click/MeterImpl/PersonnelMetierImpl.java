package com.winnertech.point_click.MeterImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winnertech.point_click.dao.PersonnelRepository;
import com.winnertech.point_click.entities.Personnel;
import com.winnertech.point_click.metier.PersonnelMetier;

@Service
@Transactional
public class PersonnelMetierImpl implements PersonnelMetier {
	
	@Autowired
	private PersonnelRepository personnelRepository;

	@Override
	public Personnel addPersonnel(Personnel p) {
		
		return personnelRepository.save(p);
	}

	@Override
	public Personnel updatePersonnel(Long id) {
		
		return personnelRepository.findById(id).get();
	}

	@Override
	public void deletePersonnel(Long id) {
		
		personnelRepository.deleteById(id);
		
	}

	@Override
	public List<Personnel> listPersonnel() {
		
		return personnelRepository.findAll();
	}

}
