package com.winnertech.point_click.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity @Table(name="utilisateurs")
public class Utilisateur implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="username", length = 101, nullable = false, unique = true)
	private String username;
	
	@Column(name="password", length = 101, nullable = false)
	private String password;
	
	@Column(name="name", length = 101, nullable = false)
	private String name;
	
	@Temporal(TemporalType.DATE) 
	@Column(name = "date_save", nullable = false)
	private Date dateSave;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles =  new ArrayList<>();
	
	public Utilisateur() {
		super();

	}

	public Utilisateur(String username, String password, String name, Date dateSave, Collection<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.dateSave = dateSave;
		this.roles = roles;
	}

	public Utilisateur(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonGetter
	public String getPassword() {
		return password;
	}

	@JsonSetter
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateSave() {
		return dateSave;
	}

	public void setDateSave(Date dateSave) {
		this.dateSave = dateSave;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
