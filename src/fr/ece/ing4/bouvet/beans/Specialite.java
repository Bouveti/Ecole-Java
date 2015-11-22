package fr.ece.ing4.bouvet.beans;

import java.io.Serializable;

public class Specialite implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String className="SpecialiteClass";
	private int id;
	private String nom;
	
	public Specialite(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	public Specialite(){
		this(0,"");
	}
	public String toString(){
		return Specialite.className+"_"+this.id + "_" + this.nom;
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
}
