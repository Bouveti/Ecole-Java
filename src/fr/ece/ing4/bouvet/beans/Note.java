package fr.ece.ing4.bouvet.beans;

import java.io.Serializable;

public class Note implements Serializable {
	
	private static final String className="NoteClass";
	private int id;
	private int eleve;
	private int module;
	private int note;
	private String type;
	private float coefficient;
	
	public Note(int id, int eleve, int module, int note, String type, float coefficient) {
		super();
		this.id = id;
		this.eleve = eleve;
		this.module = module;
		this.note = note;
		this.type = type;
		this.coefficient = coefficient;
	}
	
	public Note(){
		this(0,0,0,0,"",0.0f);
	}
	
	public String toString(){
		return this.className+"_"+this.id + "_" + this.eleve + "_" + this.module
				+"_"+this.note + "_" + this.type + "_" + this.coefficient;
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

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
	}
}
