package fr.ece.ing4.bouvet.test;
import fr.ece.ing4.bouvet.beans.*;
import fr.ece.ing4.bouvet.dao.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import  java.sql.*;
import java.util.ArrayList;

public class DAOTest {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Utilisateur> list = UtilisateurDAO.getAllUtilisateurs();
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getNom());
		}
	}
}
