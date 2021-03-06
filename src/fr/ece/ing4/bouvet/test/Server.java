package fr.ece.ing4.bouvet.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.ece.ing4.bouvet.beans.Eleve;
import fr.ece.ing4.bouvet.beans.Inscription;
import fr.ece.ing4.bouvet.beans.Module;
import fr.ece.ing4.bouvet.beans.Note;
import fr.ece.ing4.bouvet.beans.Professeur;
import fr.ece.ing4.bouvet.beans.Specialite;
import fr.ece.ing4.bouvet.beans.Utilisateur;
import fr.ece.ing4.bouvet.dao.EleveDAO;
import fr.ece.ing4.bouvet.dao.InscriptionDAO;
import fr.ece.ing4.bouvet.dao.ModuleDAO;
import fr.ece.ing4.bouvet.dao.NoteDAO;
import fr.ece.ing4.bouvet.dao.ProfesseurDAO;
import fr.ece.ing4.bouvet.dao.SpecialiteDAO;
import fr.ece.ing4.bouvet.dao.UtilisateurDAO;

public class Server implements Serializable {

	private static final long serialVersionUID = 1L;
	private static ServerSocket s;

	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

		ObjectOutputStream oos;
		ArrayList<Eleve> Eleve = EleveDAO.getAllEleve();
		ArrayList<Inscription> Inscription = InscriptionDAO.getAllInscription();
		ArrayList<Module> Module = ModuleDAO.getAllModule();
		ArrayList<Note> Note = NoteDAO.getAllNote();
		ArrayList<Professeur> Professeur = ProfesseurDAO.getAllProfesseur();
		ArrayList<Specialite> Specialite = SpecialiteDAO.getAllSpecialite();
		ArrayList<Utilisateur> Utilisateur = UtilisateurDAO.getAllUtilisateurs();
		ArrayList<Object> all = new ArrayList<Object>();
		all.add(Eleve);
		all.add(Inscription);
		all.add(Module);
		all.add(Note);
		all.add(Professeur);
		all.add(Specialite);
		all.add(Utilisateur);

		System.out.println("Lancement du serveur");
		s = new ServerSocket(3500,1);
		while(true){
			Socket connex = s.accept();
			try {
					OutputStream os =  connex.getOutputStream();
					oos = new ObjectOutputStream(os);
					oos.writeObject(all);
					oos.flush();
					InputStream is= connex.getInputStream();
					ObjectInputStream ois = new ObjectInputStream(is);
					//Récupération + désérialisation
					String res = (String)ois.readObject().toString();
					System.out.println("res :"+res);
					res = res.replaceAll("]", "");
					res = res.replaceAll("\\[", "");
					res = res.replaceAll(" ", "");
					String[] resFull = res.split("[,_]");
					/*for (String resF : resFull) {				
						System.out.println(resF);
					}*/
					
					for(int i=0;i<resFull.length;i++)
					{
						if(resFull[i].equalsIgnoreCase("InscriptionClass"))
						{
							Inscription.add(new Inscription(Integer.parseInt(resFull[i+1]),
									Integer.parseInt(resFull[i+2]),
									Integer.parseInt(resFull[i+3]),
									resFull[i+4],
									Integer.parseInt(resFull[i+5])));
						}
						
						else if(resFull[i].equalsIgnoreCase("NoteClass"))
						{
							Note.add(new Note(Integer.parseInt(resFull[i+1]),
									Integer.parseInt(resFull[i+2]),
									Integer.parseInt(resFull[i+3]),
									Integer.parseInt(resFull[i+4]),
									resFull[i+5],
									Float.parseFloat(resFull[i+6])));
						}
					}
					
					for(int i=0; i<Inscription.size();i++){
						if (Inscription.get(i).getState() == 1)InscriptionDAO.insertInscription(Inscription.get(i));
						else if(Inscription.get(i).getState() == -1)InscriptionDAO.deleteInscriptionById(Inscription.get(i));	
					}
					
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
