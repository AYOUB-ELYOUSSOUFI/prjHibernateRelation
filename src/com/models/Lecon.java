package com.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lecon")
public class Lecon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_locon")
	private int id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_Moniteur")
	@Column(name="id_Moniteur")
	private Moniteur moniteur;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_Voiture")
	@Column(name="id_Voiture")
	private Voiture voiture;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_eleve")
	@Column(name="id_eleve")
	private Eleve eleve;
	@Column(name="dateLecon")
	private Date dateLecon;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Moniteur getMoniteur() {
		return moniteur;
	}
	public void setMoniteur(Moniteur moniteur) {
		this.moniteur = moniteur;
	}
	public Voiture getVoiture() {
		return voiture;
	}
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	public Eleve getEleve() {
		return eleve;
	}
	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	public Date getDateLecon() {
		return dateLecon;
	}
	public void setDateLecon(Date dateLecon) {
		this.dateLecon = dateLecon;
	}
	
	
	
	
}
