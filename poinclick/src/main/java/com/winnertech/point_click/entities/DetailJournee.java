package com.winnertech.point_click.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name = "detail_journee")
@Entity

public class DetailJournee implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "heure_arrive", nullable = false)
    private String heureArrive;
	
	@Column(name = "heure_depart", nullable = false)
	private String heureDepart;
	
	@Column(name = "heure_debut_pause", nullable = false)
	private String heureDebutPause;
	
	@Column(name = "heure_fin_pause", nullable = false)
	private String heureFinPause;
	
	
	@ManyToOne
	@JoinColumn(name = "id_journee", nullable = false)
	private Journee journee;
	
	@ManyToOne
	@JoinColumn(name = "id_personnel", nullable = false)
	private Personnel personnel;

	public DetailJournee() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getHeureArrive() {
		return heureArrive;
	}


	public void setHeureArrive(String heureArrive) {
		this.heureArrive = heureArrive;
	}

	public String getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}


	public String getHeureDebutPause() {
		return heureDebutPause;
	}



	public void setHeureDebutPause(String heureDebutPause) {
		this.heureDebutPause = heureDebutPause;
	}



	public String getHeureFinPause() {
		return heureFinPause;
	}



	public void setHeureFinPause(String heureFinPause) {
		this.heureFinPause = heureFinPause;
	}



	public Journee getJournee() {
		return journee;
	}

	public void setJournee(Journee journee) {
		this.journee = journee;
	}

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	
	
}
