package com.winnertech.point_click.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "exercice_journee")
@Entity
public class ExerciceJournalier implements Serializable  {
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "date_jour", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dateJour;
	
	@Column(name = "heure_arrive", nullable = true)
	@Temporal(TemporalType.TIME)
    private Date heureArrive;
	
	@Column(name = "heure_depart", nullable = true)
	@Temporal(TemporalType.TIME)
	private Date heureDepart;
	
	@Column(name = "heure_debut_pause", nullable = true)
	@Temporal(TemporalType.TIME)
	private Date heureDebutPause;
	
	@Column(name = "heure_fin_pause", nullable = true)
	@Temporal(TemporalType.TIME)
	private Date heureFinPause;
	
	@Column(name = "heure_sortie_speciale", nullable = true)
	@Temporal(TemporalType.TIME)
	private Date heureSortieSpeciale;
	
	@Column(name = "motif", nullable = true)
	private String motif;
	
	@Column(name = "fin_heure_sortie_speciale", nullable = true)
	@Temporal(TemporalType.TIME)
	private Date finHeureSortieSpeciale;
	
	@ManyToOne
	@JoinColumn(name = "id_personnel", nullable = true)
	private DetailJournee detailJournee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateJour() {
		return dateJour;
	}

	public void setDateJour(Date dateJour) {
		this.dateJour = dateJour;
	}

	public Date getHeureArrive() {
		return heureArrive;
	}

	public void setHeureArrive(Date heureArrive) {
		this.heureArrive = heureArrive;
	}

	public Date getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}



	public Date getHeureDebutPause() {
		return heureDebutPause;
	}

	public void setHeureDebutPause(Date heureDebutPause) {
		this.heureDebutPause = heureDebutPause;
	}

	public Date getHeureFinPause() {
		return heureFinPause;
	}

	public void setHeureFinPause(Date heureFinPause) {
		this.heureFinPause = heureFinPause;
	}

	public Date getHeureSortieSpeciale() {
		return heureSortieSpeciale;
	}

	public void setHeureSortieSpeciale(Date heureSortieSpeciale) {
		this.heureSortieSpeciale = heureSortieSpeciale;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Date getFinHeureSortieSpeciale() {
		return finHeureSortieSpeciale;
	}

	public void setFinHeureSortieSpeciale(Date finHeureSortieSpeciale) {
		this.finHeureSortieSpeciale = finHeureSortieSpeciale;
	}

	public DetailJournee getDetailJournee() {
		return detailJournee;
	}

	public void setDetailJournee(DetailJournee detailJournee) {
		this.detailJournee = detailJournee;
	}


	
	

}
