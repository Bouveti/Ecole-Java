package fr.ece.ing4.bouvet.beans;

import java.io.Serializable;

public class Module implements Serializable {
	
	private static final String className="ModuleClass";
	private int id;
	private String nom;
	private int specialite;
	
	public Module(int id, String nom, int specialite) {
		super();
		this.id = id;
		this.nom = nom;
		this.specialite = specialite;
	}
	
	public Module(){
		this(0,"",0);
	}
	
	public String toString(){
		return this.className+"_"+this.id + "_" + this.nom + "_" + this.specialite;
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

	public int getSpecialite() {
		return specialite;
	}

	public void setSpecialite(int specialite) {
		this.specialite = specialite;
	}
}
