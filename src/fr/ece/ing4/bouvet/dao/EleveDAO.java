package fr.ece.ing4.bouvet.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.ece.ing4.bouvet.beans.Eleve;
import fr.ece.ing4.bouvet.connection.*;

public class EleveDAO {
	
	private static ArrayList<Eleve> listEleve;
	private static Eleve eleve;
	
	public static ArrayList<Eleve> getAllEleve() throws SQLException{
		
		listEleve = new ArrayList<Eleve>();
		eleve = new Eleve();
		
		String req ="SELECT * FROM ELEVE;";
		DBAction.DBConnexion();
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		while (DBAction.getRes().next())
		{
			eleve.setId(DBAction.getRes().getInt(1));
			eleve.setProfesseur(DBAction.getRes().getInt(2));
			eleve.setSpecialite(DBAction.getRes().getInt(3));
			eleve.setNom(DBAction.getRes().getString(4));
			
			listEleve.add(new Eleve(eleve.getId(),eleve.getNom(),
					eleve.getProfesseur(),eleve.getSpecialite()));
		}
		DBAction.DBClose();		
		return listEleve;		
	}
}
