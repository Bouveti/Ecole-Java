package fr.ece.ing4.bouvet.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.ece.ing4.bouvet.beans.Module;
import fr.ece.ing4.bouvet.connection.DBAction;

public class ModuleDAO {
	
	private static ArrayList<Module> listModule;
	private static Module module;
	
	public static ArrayList<Module> getAllModule() throws SQLException{
		
		listModule = new ArrayList<Module>();
		module = new Module();
		
		String req ="SELECT * FROM Module;";
		DBAction.DBConnexion();
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		while (DBAction.getRes().next())
		{
			module.setId(DBAction.getRes().getInt(1));
			module.setSpecialite(DBAction.getRes().getInt(2));
			module.setNom(DBAction.getRes().getString(3));
			
			listModule.add(new Module(module.getId(),module.getNom(),
					module.getSpecialite()));
		}
		DBAction.DBClose();		
		return listModule;		
	}

}
