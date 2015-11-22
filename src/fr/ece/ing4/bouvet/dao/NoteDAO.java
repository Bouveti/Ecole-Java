package fr.ece.ing4.bouvet.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.ece.ing4.bouvet.beans.Note;
import fr.ece.ing4.bouvet.connection.DBAction;

public class NoteDAO {
	
	private static ArrayList<Note> listNote;
	private static Note note;
	
	public static ArrayList<Note> getAllNote() throws SQLException{
		
		listNote = new ArrayList<Note>();
		note = new Note();
		
		String req ="SELECT * FROM Note;";
		DBAction.DBConnexion();
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		while (DBAction.getRes().next())
		{
			note.setId(DBAction.getRes().getInt(1));
			note.setEleve(DBAction.getRes().getInt(2));
			note.setModule(DBAction.getRes().getInt(3));
			note.setNote(DBAction.getRes().getInt(4));
			note.setType(DBAction.getRes().getString(5));
			note.setCoefficient(DBAction.getRes().getFloat(6));
			
			listNote.add(new Note(note.getId(),note.getEleve(),
					note.getModule(),note.getNote(),note.getType(),note.getCoefficient()));
		}
		DBAction.DBClose();		
		return listNote;		
	}

	public static int insertNote(Note note){
		
		int result = -1;
		DBAction.DBConnexion();
		
		String req = "INSERT INTO NOTE (ID, ELEVE_IDELEVE, MODULE_IDMODULE, NOTE, TYPE, COEFFICIENT)VALUES("+ note.getId()+","
																								+ note.getEleve()+","
																								+ note.getModule()+","
																								+ note.getNote()+",\""
																								+ note.getType()+"\","
																								+ note.getCoefficient()+");";
		 
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
