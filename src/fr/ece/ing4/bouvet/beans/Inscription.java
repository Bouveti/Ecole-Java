package fr.ece.ing4.bouvet.beans;

import java.io.Serializable;

public class Inscription implements Serializable {
	
	private static final String className="InscriptionClass";
	private int id;
	private int eleve;
	private int module;
	private String role;
	private int state;
	
	public Inscription(int id, int eleve, int module, String role,int state) {
		super();
		this.id = id;
		this.eleve = eleve;
		this.module = module;
		this.role = role;
		this.state = state;
	}
	
	public Inscription(){
		this(0,0,0,"",0);
	}
	
	public String toString(){
		return this.className+"_"+this.id + "_" + this.eleve + "_" + this.module+ 
				"_" + this.role + "_" + this.state;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
