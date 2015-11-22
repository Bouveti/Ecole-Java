package fr.ece.ing4.bouvet.beans;

import java.io.Serializable;

public class Utilisateur implements Serializable {
	private static final String className="UtilisateurClass";
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
	
	public String toString(){
		return Utilisateur.className+"_"+this.id + "_" + this.nom + "_" + this.login + 
				"_" + this.password;
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
