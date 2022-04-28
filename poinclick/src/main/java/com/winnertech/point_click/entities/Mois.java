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


@Table(name = "mois")
@Entity
public class Mois implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "libelle", length = 30, nullable = false)
	private String libelle;
	
	@Column(name = "etat", length = 1, nullable = false)
	private boolean etat;
	
	@ManyToOne
	@JoinColumn(name = "id_annee", nullable = true)
	private Annee annee;

	public Mois() {
		super();
	}

	public Mois(String libelle, boolean etat, Annee annee) {
		super();
		this.libelle = libelle;
		this.etat = etat;
		this.annee = annee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public Annee getAnnee() {
		return annee;
	}

	public void setAnnee(Annee annee) {
		this.annee = annee;
	}
	
	

}
