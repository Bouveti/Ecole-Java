package fr.ece.ing4.bouvet.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.ece.ing4.bouvet.beans.Professeur;
import fr.ece.ing4.bouvet.connection.DBAction;

public class ProfesseurDAO {
	
	private static ArrayList<Professeur> listProfesseur;
	private static Professeur Professeur;
	
	public static ArrayList<Professeur> getAllProfesseur() throws SQLException{
		String req ="SELECT * FROM Professeur;";
		DBAction.DBConnexion();
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		while (DBAction.getRes().next())
		{
			Professeur.setId(DBAction.getRes().getInt(1));
			Professeur.setModule(DBAction.getRes().getInt(2));
			Professeur.setSpecialite(DBAction.getRes().getInt(3));
			Professeur.setNom(DBAction.getRes().getString(4));
			
			listProfesseur.add(new Professeur(Professeur.getId(),Professeur.getNom(),
					Professeur.getModule(),Professeur.getSpecialite()));
		}
		DBAction.DBClose();		
		return listProfesseur;		
	}

}
