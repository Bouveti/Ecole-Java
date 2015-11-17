package fr.ece.ing4.bouvet.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.ece.ing4.bouvet.beans.Note;
import fr.ece.ing4.bouvet.connection.DBAction;

public class NoteDAO {
	
	private static ArrayList<Note> listNote;
	private static Note Note;
	
	public static ArrayList<Note> getAllNote() throws SQLException{
		String req ="SELECT * FROM Note;";
		DBAction.DBConnexion();
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		while (DBAction.getRes().next())
		{
			Note.setId(DBAction.getRes().getInt(1));
			Note.setEleve(DBAction.getRes().getInt(2));
			Note.setModule(DBAction.getRes().getInt(3));
			Note.setNote(DBAction.getRes().getInt(4));
			Note.setType(DBAction.getRes().getString(5));
			Note.setCoefficient(DBAction.getRes().getFloat(6));
			
			listNote.add(new Note(Note.getId(),Note.getEleve(),
					Note.getModule(),Note.getNote(),Note.getType(),Note.getCoefficient()));
		}
		DBAction.DBClose();		
		return listNote;		
	}

}
