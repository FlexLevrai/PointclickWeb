package com.winnertech.point_click.metier;

import java.util.List;

import com.winnertech.point_click.entities.ExerciceJournalier;

public interface ExerciceJournalierMetier {
	
	public ExerciceJournalier heureArriver(ExerciceJournalier e);
	
	public ExerciceJournalier heureDepart(ExerciceJournalier e);
	
	public ExerciceJournalier heureDebutPause(ExerciceJournalier e);
	
	public ExerciceJournalier heureFinPause(ExerciceJournalier e);
	
	public ExerciceJournalier heureSortieSpecial(ExerciceJournalier e);
	
	public ExerciceJournalier heureFinSortieSpecial(ExerciceJournalier e);
	
	public List<ExerciceJournalier> listExercieJournalier();
	

}
