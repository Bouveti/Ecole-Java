package fr.ece.ing4.bouvet.beans;

public class Inscription {
	private int id;
	private int eleve;
	private int module;
	private String role;
	
	public Inscription(int id, int eleve, int module, String role) {
		super();
		this.id = id;
		this.eleve = eleve;
		this.module = module;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEleve() {
		return eleve;
	}

	public void setEleve(int eleve) {
		this.eleve = eleve;
	}

	public int getModule() {
		return module;
	}

	public void setModule(int module) {
		this.module = module;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
