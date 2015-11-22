package fr.ece.ing4.bouvet.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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

	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub

		System.out.println("Lancement du serveur");
		s = new ServerSocket(2009);
		Socket connex = s.accept();
		System.out.println("Hello T'es Co GG !");

		//ObjectInputStream ois;
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
		System.out.println("TETESTESTESTETSETSTSTESTS");
		
		//Utilisateur user = new Utilisateur(50,"aaaaa","aaaa@aaaa.com","password");
		try {
			OutputStream os =  connex.getOutputStream();
			oos = new ObjectOutputStream(os);
			oos.writeObject(all);			
			
			/*System.out.println(((Utilisateur)oos.readObject()).toString());

			oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									new File("game.txt"))));

			oos.writeObject(user);
			oos.close();

			ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(
									new File("game.txt"))));

			try {
				System.out.println("Affichage de l'user :");
				System.out.println("*************************\n");
				System.out.println(((Utilisateur)ois.readObject()).toString());

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}*/

			oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}     	




		/*new Thread(new Evaluateur(connex)).start();
			DataInputStream dis = new DataInputStream(connex.getInputStream());
			DataOutputStream dos = new DataOutputStream(connex.getOutputStream());

			int a = dis.readInt();
			char op = dis.readChar();
			int b = dis.readInt();

			dis.close();
			dos.close();*/


		/*ServerSocket socketserver  ;
		Socket socketduserveur ;
		socketserver = new ServerSocket(2009);
		try {

			socketduserveur = socketserver.accept(); 
			System.out.println("Un zéro s'est connecté !");
		        socketserver.close();
		        socketduserveur.close();

		}catch (IOException e) {
			e.printStackTrace();
		}*/
	}
}
