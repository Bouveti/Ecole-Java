package fr.ece.ing4.bouvet.beans;

public class Module {
	private int id;
	private String nom;
	private Specialite specialite;
	
	public Module(int id, String nom, Specialite specialite) {
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

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
}
