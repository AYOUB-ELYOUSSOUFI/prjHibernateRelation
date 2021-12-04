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
@Table(name="voiture")
public class Voiture implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_Voiture")
	private int id;
	@Column(name="modele")
	private String modele;
	@Column(name="couleur")
	private String couleur;
	@Column(name="dateMiseCirculation")
	private Date dateMiseCirculation;
	@OneToMany(mappedBy = "voiture",fetch = FetchType.EAGER)
	private List<Lecon> lecons;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public Date getDateMiseCirculation() {
		return dateMiseCirculation;
	}
	public void setDateMiseCirculation(Date dateMiseCirculation) {
		this.dateMiseCirculation = dateMiseCirculation;
	}
	
	public Voiture () {}
	@Override
	public String toString() {
		return "Voiture [id=" + id + ", modele=" + modele + ", couleur=" + couleur + ", dateMiseCirculation="
				+ dateMiseCirculation + "]";
	}
	
	
}
