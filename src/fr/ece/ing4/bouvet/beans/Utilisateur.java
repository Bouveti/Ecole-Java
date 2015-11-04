package fr.ece.ing4.bouvet.beans;

public class Utilisateur {
	private int id;
	private String nom;
	private String login;
	private String password;
	
	public Utilisateur(int id, String nom, String login, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.login = login;
		this.password = password;
	}
	
	public Utilisateur(){
		this(0,"","","");
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
