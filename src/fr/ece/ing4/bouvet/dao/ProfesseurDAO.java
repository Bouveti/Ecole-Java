package fr.ece.ing4.bouvet.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.ece.ing4.bouvet.beans.Professeur;
import fr.ece.ing4.bouvet.connection.DBAction;

public class ProfesseurDAO {
	
	private static ArrayList<Professeur> listProfesseur;
	private static Professeur professeur;
	
	public static ArrayList<Professeur> getAllProfesseur() throws SQLException{
		
		listProfesseur = new ArrayList<Professeur>();
		professeur = new Professeur();
		
		String req ="SELECT * FROM Professeur;";
		DBAction.DBConnexion();
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		while (DBAction.getRes().next())
		{
			professeur.setId(DBAction.getRes().getInt(1));
			professeur.setModule(DBAction.getRes().getInt(2));
			professeur.setSpecialite(DBAction.getRes().getInt(3));
			professeur.setNom(DBAction.getRes().getString(4));
			
			listProfesseur.add(new Professeur(professeur.getId(),professeur.getNom(),
					professeur.getModule(),professeur.getSpecialite()));
		}
		DBAction.DBClose();		
		return listProfesseur;		
	}

}
