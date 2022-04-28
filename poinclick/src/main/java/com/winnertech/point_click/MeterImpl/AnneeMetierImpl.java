package com.winnertech.point_click.MeterImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winnertech.point_click.dao.AnneeRepository;
import com.winnertech.point_click.entities.Annee;
import com.winnertech.point_click.metier.AnneeMetier;


@Service
@Transactional
public class AnneeMetierImpl implements AnneeMetier {
	
	@Autowired
	private AnneeRepository anneeRepository;

	@Override
	public Annee addAnnee(Annee a) {
		
		return anneeRepository.save(a);
	}

	@Override
	public Annee updateAnnee(Long id) {
		
		return anneeRepository.findById(id).get();
	}

	@Override
	public void deleteAnnee(Long id) {
	   
		anneeRepository.deleteById(id);
		
	}

	@Override
	public List<Annee> listAnnee() {
		
		return anneeRepository.findAll();
	}

	@Override
	public Annee activateAnnee(Long id) {
		
		List<Annee> lsr = anneeRepository.findAll();

		Annee rt = anneeRepository.findById(id).get();

		for (Annee re : lsr) {
			if (re.isEtat() != false) {
				re.setEtat(false);
				anneeRepository.save(re);
			}

			Annee r = anneeRepository.findById(rt.getId()).get();
			r.setEtat(true);
			anneeRepository.save(r);
		}
		
		return rt;
	}

}
