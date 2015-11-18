package fr.ece.ing4.bouvet.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.ece.ing4.bouvet.beans.Specialite;
import fr.ece.ing4.bouvet.connection.DBAction;

public class SpecialiteDAO {
	
	private static ArrayList<Specialite> listSpecialite;
	private static Specialite specialite;
	
	public static ArrayList<Specialite> getAllSpecialite() throws SQLException{
		
		listSpecialite = new ArrayList<Specialite>();
		specialite = new Specialite();
		
		String req ="SELECT * FROM Specialite;";
		DBAction.DBConnexion();
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		while (DBAction.getRes().next())
		{
			specialite.setId(DBAction.getRes().getInt(1));
			specialite.setNom(DBAction.getRes().getString(2));
			
			listSpecialite.add(new Specialite(specialite.getId(),specialite.getNom()));
		}
		DBAction.DBClose();		
		return listSpecialite;	

	}
}
