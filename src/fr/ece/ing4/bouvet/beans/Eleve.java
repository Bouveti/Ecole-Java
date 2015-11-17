package fr.ece.ing4.bouvet.beans;

public class Eleve {
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
