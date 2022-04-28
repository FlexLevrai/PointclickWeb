package com.winnertech.point_click.MeterImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winnertech.point_click.dao.DetailJourneeRepository;
import com.winnertech.point_click.dao.ExerciceJournalierRepository;
import com.winnertech.point_click.dao.JourneeRepository;
import com.winnertech.point_click.dao.PersonnelRepository;
import com.winnertech.point_click.entities.ExerciceJournalier;
import com.winnertech.point_click.entities.Journee;
import com.winnertech.point_click.entities.Personnel;
import com.winnertech.point_click.metier.ExerciceJournalierMetier;

@Service
@Transactional
public class ExerciceJournalierMetierImpl implements ExerciceJournalierMetier {
	
	@Autowired
	private ExerciceJournalierRepository exerciceJournalierRepository;
	
	@Autowired
	private JourneeRepository journeeRepository;
	
	@Autowired
	private DetailJourneeRepository detailJourneeRepository;

	@Override
	public ExerciceJournalier heureArriver(ExerciceJournalier e) {
		
		ExerciceJournalier ex = exerciceJournalierRepository.save(e);
		
		Journee j = journeeRepository.activeJournee();
		
		ExerciceJournalier ej = exerciceJournalierRepository.activeJour(ex.getDetailJournee().getPersonnel().getId());
		
		ex.setDateJour(new Date());
		ex.setHeureArrive(new Date());
		j.setEtat(false);
		
		return exerciceJournalierRepository.save(ex);
	}



	@Override
	public ExerciceJournalier heureDebutPause(ExerciceJournalier e) {

		return exerciceJournalierRepository.save(e);
	}



	@Override
	public ExerciceJournalier heureDepart(ExerciceJournalier e) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ExerciceJournalier heureFinPause(ExerciceJournalier e) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ExerciceJournalier heureSortieSpecial(ExerciceJournalier e) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ExerciceJournalier heureFinSortieSpecial(ExerciceJournalier e) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<ExerciceJournalier> listExercieJournalier() {
		// TODO Auto-generated method stub
		return null;
	}



}
