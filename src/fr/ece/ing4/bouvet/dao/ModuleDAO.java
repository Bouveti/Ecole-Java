package fr.ece.ing4.bouvet.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.ece.ing4.bouvet.beans.Module;
import fr.ece.ing4.bouvet.connection.DBAction;

public class ModuleDAO {
	
	private static ArrayList<Module> listModule;
	private static Module Module;
	
	public static ArrayList<Module> getAllModule() throws SQLException{
		String req ="SELECT * FROM Module;";
		DBAction.DBConnexion();
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		while (DBAction.getRes().next())
		{
			Module.setId(DBAction.getRes().getInt(1));
			Module.setSpecialite(DBAction.getRes().getInt(2));
			Module.setNom(DBAction.getRes().getString(3));
			
			listModule.add(new Module(Module.getId(),Module.getNom(),
					Module.getSpecialite()));
		}
		DBAction.DBClose();		
		return listModule;		
	}

}
