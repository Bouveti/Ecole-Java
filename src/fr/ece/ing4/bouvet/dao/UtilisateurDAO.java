package fr.ece.ing4.bouvet.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.ece.ing4.bouvet.beans.*;
import fr.ece.ing4.bouvet.connection.DBAction;
import com.mysql.jdbc.SQLError;

public class UtilisateurDAO {

	private static Utilisateur utilisateurTemp;
	private static ArrayList<Utilisateur> listTemp;
	
	public static ArrayList<Utilisateur> getAllUtilisateurs() throws SQLException{
		
		listTemp = new ArrayList<Utilisateur>();
		utilisateurTemp = new Utilisateur();
		
		String req = "SELECT * FROM Utilisateur";

		//Connexion
		DBAction.DBConnexion();
		//Execution de la requete + init
		DBAction.setRes(DBAction.getStm().executeQuery(req));
				
		while(DBAction.getRes().next())
		{
			//Création de l'objet temp à travers le résultat de la requete
			utilisateurTemp.setId(DBAction.getRes().getInt(1));
			utilisateurTemp.setNom(DBAction.getRes().getString(2));
			utilisateurTemp.setLogin(DBAction.getRes().getString(3));
			utilisateurTemp.setPassword(DBAction.getRes().getString(4));
					
			listTemp.add(new Utilisateur(utilisateurTemp.getId(),utilisateurTemp.getNom(),utilisateurTemp.getLogin(),utilisateurTemp.getPassword()));
		}
		//Fermeture de la connexion
		DBAction.DBClose();

		//Retour du résultat
		
		return listTemp;
	}
}