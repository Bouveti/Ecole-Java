package fr.ece.ing4.bouvet.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.ece.ing4.bouvet.beans.Inscription;
import fr.ece.ing4.bouvet.connection.DBAction;

public class InscriptionDAO {
	
	private static ArrayList<Inscription> listInscription;
	private static Inscription inscription;
	
	public static ArrayList<Inscription> getAllInscription() throws SQLException{
		
		listInscription = new ArrayList<Inscription>();
		inscription = new Inscription();
		
		String req ="SELECT * FROM Inscription;";
		DBAction.DBConnexion();
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		while (DBAction.getRes().next())
		{
			inscription.setId(DBAction.getRes().getInt(1));
			inscription.setEleve(DBAction.getRes().getInt(2));
			inscription.setModule(DBAction.getRes().getInt(3));
			inscription.setRole(DBAction.getRes().getString(4));
			
			listInscription.add(new Inscription(inscription.getId(),inscription.getEleve(),
					inscription.getModule(),inscription.getRole(),0));
		}
		DBAction.DBClose();		
		return listInscription;		
	}
	
	public static int insertInscription(Inscription inscription){
			
			int result = -1;
			DBAction.DBConnexion();
			
			String req = "INSERT INTO INSCRIPTION (ID, ELEVE_IDELEVE, MODULE_IDMODULE, ROLE)VALUES("+ inscription.getId()+","
																									+ inscription.getEleve()+","
																									+ inscription.getModule()+","
																									+ "\""+inscription.getRole()+"\");";
			 
			try {
					result = DBAction.getStm().executeUpdate(req);
					System.out.println("Requete executee");
				 
				} catch (SQLException ex) {
					result = - ex.getErrorCode();
				}
			DBAction.DBClose();
			
			return result;
		}
		
		public static int deleteInscriptionById(Inscription inscription) {
			
			int result = -1;
			DBAction.DBConnexion();
			 
			String req = "DELETE FROM Inscription WHERE ID =" + inscription.getId()+";";
			
			try {
					result = DBAction.getStm().executeUpdate(req);
					System.out.println("Requete executee");
				 
				} catch (SQLException ex) {
					result = - ex.getErrorCode();
				}
			
			DBAction.DBClose();
			
			return result;
		}

}
