package fr.ece.ing4.bouvet.beans;

public class Specialite {
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
