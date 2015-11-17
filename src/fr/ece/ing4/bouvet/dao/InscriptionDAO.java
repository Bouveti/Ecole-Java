package fr.ece.ing4.bouvet.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.ece.ing4.bouvet.beans.Inscription;
import fr.ece.ing4.bouvet.connection.DBAction;

public class InscriptionDAO {
	
	private static ArrayList<Inscription> listInscription;
	private static Inscription Inscription;
	
	public static ArrayList<Inscription> getAllInscription() throws SQLException{
		String req ="SELECT * FROM Inscription;";
		DBAction.DBConnexion();
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		while (DBAction.getRes().next())
		{
			Inscription.setId(DBAction.getRes().getInt(1));
			Inscription.setEleve(DBAction.getRes().getInt(2));
			Inscription.setModule(DBAction.getRes().getInt(3));
			Inscription.setRole(DBAction.getRes().getString(4));
			
			listInscription.add(new Inscription(Inscription.getId(),Inscription.getEleve(),
					Inscription.getModule(),Inscription.getRole()));
		}
		DBAction.DBClose();		
		return listInscription;		
	}

}
