package fr.ece.ing4.bouvet.beans;

public class Note {
	private int id;
	private Eleve eleve;
	private Module module;
	private int note;
	private String type;
	private float coefficient;
	
	public Note(int id, Eleve eleve, Module module, int note, String type, float coefficient) {
		super();
		this.id = id;
		this.eleve = eleve;
		this.module = module;
		this.note = note;
		this.type = type;
		this.coefficient = coefficient;
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
