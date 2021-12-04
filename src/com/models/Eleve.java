package com.models;

import java.io.Serializable;
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
@Table(name="eleve")
public class Eleve implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_eleve")
	private int idEleve;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="address")
	private String address;
	@Column(name="cp")
	private String codePostal;
	@Column(name="ville")
	private String ville;
	@OneToMany(mappedBy = "eleve",fetch = FetchType.EAGER)
	private List<Lecon> lecons;
	
	public int getIdEleve() {
		return idEleve;
	}
	public void setIdEleve(int idEleve) {
		this.idEleve = idEleve;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public Eleve() {}
	@Override
	public String toString() {
		return "Eleve [idEleve=" + idEleve + ", nom=" + nom + ", prenom=" + prenom + ", address=" + address
				+ ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
	
	
}
