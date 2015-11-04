package fr.ece.ing4.bouvet.beans;

public class Eleve {
	private int id;
	private String nom;
	private Professeur professeur;
	private Specialite specialite;
	
	public Eleve(int id, String nom, Professeur professeur, Specialite specialite) {
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
	public Professeur getProfesseur() {
		return professeur;
	}
	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}
	public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}	
}
