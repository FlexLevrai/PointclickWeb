package com.winnertech.point_click.MeterImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winnertech.point_click.dao.AnneeRepository;
import com.winnertech.point_click.dao.MoisRepository;
import com.winnertech.point_click.entities.Annee;
import com.winnertech.point_click.entities.Mois;
import com.winnertech.point_click.metier.MoisMetier;

@Service
@Transactional
public class MoisMetierImpl implements MoisMetier {
	
	@Autowired
	private MoisRepository moisRepository;
	
	@Autowired
	private AnneeRepository anneeRepository;

	@Override
	public Mois addMois(Mois m) {
		
		Mois mo =  moisRepository.save(m);
		
		Annee a = anneeRepository.anneeActif();
		mo.setAnnee(a);
		
		return moisRepository.save(m);
	}

	@Override
	public Mois updateMois(Long id) {
	
		
		return moisRepository.findById(id).get();
	}

	@Override
	public void deleteMois(Long id) {
		moisRepository.deleteById(id);
		
	}

	@Override
	public List<Mois> listMois() {
		
		return moisRepository.findAll();
	}

	@Override
	public Mois activateMois(Long id) {
		
		List<Mois> lmois = moisRepository.findAll();

		Mois mos = moisRepository.findById(id).get();

		for (Mois re : lmois) {
			if (re.isEtat() != false) {
				re.setEtat(false);
				moisRepository.save(re);
			}

			Mois r = moisRepository.findById(mos.getId()).get();
			r.setEtat(true);
			moisRepository.save(r);
		}
		
		return mos;
	}

}
