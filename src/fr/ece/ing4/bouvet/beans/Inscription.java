package fr.ece.ing4.bouvet.beans;

public class Inscription {
	private int id;
	private Eleve eleve;
	private Module module;
	
	public Inscription(int id, Eleve eleve, Module module) {
		super();
		this.id = id;
		this.eleve = eleve;
		this.module = module;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
}
