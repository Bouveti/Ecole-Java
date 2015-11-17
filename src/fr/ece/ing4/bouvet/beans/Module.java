package fr.ece.ing4.bouvet.beans;

public class Module {
	private int id;
	private String nom;
	private int specialite;
	
	public Module(int id, String nom, int specialite) {
		super();
		this.id = id;
		this.nom = nom;
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

	public int getSpecialite() {
		return specialite;
	}

	public void setSpecialite(int specialite) {
		this.specialite = specialite;
	}
}
