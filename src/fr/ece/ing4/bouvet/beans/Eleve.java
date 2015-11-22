package fr.ece.ing4.bouvet.beans;

import java.io.Serializable;

public class Eleve implements Serializable {
	
	private static final String className="EleveClass";
	private int id;
	private String nom;
	private int professeur;
	private int specialite;
	
	public Eleve(int id, String nom, int professeur, int specialite) {
		super();
		this.id = id;
		this.nom = nom;
		this.professeur = professeur;
		this.specialite = specialite;
	}
	
	public Eleve(){
		this(0,"",0,0);
	}
	
	public String toString(){
		return this.className+"_"+this.id + "_" + this.nom + "_" + this.professeur+ 
				"_" + this.specialite;
	}
	
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
	public int getProfesseur() {
		return professeur;
	}
	public void setProfesseur(int professeur) {
		this.professeur = professeur;
	}
	public int getSpecialite() {
		return specialite;
	}
	public void setSpecialite(int specialite) {
		this.specialite = specialite;
	}	
}
