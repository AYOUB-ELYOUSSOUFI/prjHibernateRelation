package com.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="moniteur")
public class Moniteur implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_Moniteur")
	private int id;
	@Column(name="nom_Moniteur")
	private String nom;
	@Column(name="prenom_Moniteur")
	private String prenom;
	@Column(name="dateNaissance")
	private Date dateNaissance;
	@Column(name="sexe")
	private String sexe;
	@OneToMany(mappedBy = "moniteur",fetch = FetchType.EAGER)
	private List<Lecon> lecons;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	public Moniteur() {}
	@Override
	public String toString() {
		return "Moniteur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", sexe=" + sexe + "]";
	}
	
	
}
