package fr.ece.ing4.bouvet.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.ece.ing4.bouvet.beans.Specialite;
import fr.ece.ing4.bouvet.connection.DBAction;

public class SpecialiteDAO {
	
	private static ArrayList<Specialite> listSpecialite;
	private static Specialite Specialite;
	
	public static ArrayList<Specialite> getAllSpecialite() throws SQLException{
		String req ="SELECT * FROM Specialite;";
		DBAction.DBConnexion();
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		while (DBAction.getRes().next())
		{
			Specialite.setId(DBAction.getRes().getInt(1));
			Specialite.setNom(DBAction.getRes().getString(2));
			
			listSpecialite.add(new Specialite(Specialite.getId(),Specialite.getNom()));
		}
		DBAction.DBClose();		
		return listSpecialite;	

}
