package fr.ece.ing4.bouvet.beans;

public class Professeur {
	private int id;
	private String nom;
	private Module module;
	private Specialite specialite;
	
	public Professeur(int id, String nom, Module module, Specialite specialite) {
		super();
		this.id = id;
		this.nom = nom;
		this.module = module;
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
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	
	
}
