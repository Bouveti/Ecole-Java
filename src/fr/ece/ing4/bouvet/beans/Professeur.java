package fr.ece.ing4.bouvet.beans;

public class Professeur {
	private int id;
	private String nom;
	private int module;
	private int specialite;
	
	public Professeur(int id, String nom, int module, int specialite) {
		super();
		this.id = id;
		this.nom = nom;
		this.module = module;
		this.specialite = specialite;
	}
	
	public Professeur(){
		this(0,"",0,0);
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
	public int getModule() {
		return module;
	}
	public void setModule(int module) {
		this.module = module;
	}
	public int getSpecialite() {
		return specialite;
	}
	public void setSpecialite(int specialite) {
		this.specialite = specialite;
	}
	
	
}
