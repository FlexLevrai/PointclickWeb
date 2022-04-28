package com.winnertech.point_click.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Table(name = "personnel")
@Entity
public class Personnel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nom", length = 101, nullable = false)
	private String nom;
	
	@Column(name = "prenom", length = 101, nullable = false)
	private String prenom;
	
	@Column(name = "sexe", length = 10, nullable = false)
	private String sexe;
	
	@Column(name = "contact", length = 15, nullable = false)
	private String contact;
	
	@Column(name = "adresse", length = 101, nullable = false)
	private String adresse;
	
	@Column(name = "date_naissance", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@Column(name = "lieu_naissance", length = 101, nullable = false)
	private String lieuNaissance;

	public Personnel() {
		super();
		
	}

	public Personnel(String nom, String prenom, String sexe, String contact, String adresse, Date dateNaissance,
			String lieuNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.contact = contact;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	
	
	
	

}
