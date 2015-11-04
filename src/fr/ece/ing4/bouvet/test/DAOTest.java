package fr.ece.ing4.bouvet.test;
import fr.ece.ing4.bouvet.beans.*;
import fr.ece.ing4.bouvet.dao.*;

import  java.sql.*;
import java.util.ArrayList;

public class DAOTest {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<Utilisateur> list = UtilisateurDAO.getAllUtilisateurs();
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getNom());			
		}
		
	}

}
