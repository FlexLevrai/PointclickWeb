package com.winnertech.point_click.MeterImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winnertech.point_click.dao.DetailJourneeRepository;
import com.winnertech.point_click.entities.DetailJournee;
import com.winnertech.point_click.metier.DetailJourneeMetier;

@Service
@Transactional
public class DetailJourneeMetierImpl implements DetailJourneeMetier {
	
	@Autowired
	private DetailJourneeRepository detailJourneeRepository;

	@Override
	public DetailJournee addDetailJournee(DetailJournee j) {
		return detailJourneeRepository.save(j);
	}

	@Override
	public DetailJournee updateDetailJournee(Long id) {
		return detailJourneeRepository.findById(id).get();
	}

	@Override
	public void deleteDetailJournee(Long id) {
		detailJourneeRepository.deleteById(id);
		
	}

	@Override
	public List<DetailJournee> listDetailJournee() {
		return detailJourneeRepository.findAll();
	}

	@Override
	public List<DetailJournee> listDetailJourneeParPersonnel(Long id) {
		
		return detailJourneeRepository.listDetailJourneeByPersonnel(id);
	}



}
