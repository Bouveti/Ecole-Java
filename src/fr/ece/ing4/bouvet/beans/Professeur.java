package fr.ece.ing4.bouvet.beans;

import java.io.Serializable;

public class Professeur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String className="ProfesseurClass";
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
	
	public String toString(){
		return Professeur.className+"_"+this.id + "_" + this.nom + "_" + this.module
				+"_"+this.specialite;
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
