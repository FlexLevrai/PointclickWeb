package com.winnertech.point_click.MeterImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winnertech.point_click.dao.JourneeRepository;
import com.winnertech.point_click.entities.Annee;
import com.winnertech.point_click.entities.Journee;
import com.winnertech.point_click.metier.JourneeMetier;

@Service
@Transactional
public class JourneeMetierImpl implements JourneeMetier {
	
	@Autowired
	private JourneeRepository journeeRepository;

	@Override
	public Journee addJournee(Journee j) {
		return journeeRepository.save(j);
	}

	@Override
	public Journee updateJournee(Long id) {
		return journeeRepository.findById(id).get();
	}

	@Override
	public void deleteJournee(Long id) {
		journeeRepository.deleteById(id);
		
	}

	@Override
	public List<Journee> listJournee() {
		return journeeRepository.findAll();
	}

	@Override
	public Journee activateJour(Long id) {
		
		List<Journee> lsr = journeeRepository.findAll();

		Journee rt = journeeRepository.findById(id).get();

		for (Journee re : lsr) {
			if (re.isEtat() != false) {
				re.setEtat(false);
				journeeRepository.save(re);
			}

			Journee r = journeeRepository.findById(rt.getId()).get();
			r.setEtat(true);
			journeeRepository.save(r);
		}
		return null;
	}

}
