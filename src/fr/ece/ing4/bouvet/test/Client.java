package fr.ece.ing4.bouvet.test;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import fr.ece.ing4.bouvet.beans.Eleve;
import fr.ece.ing4.bouvet.beans.Inscription;
import fr.ece.ing4.bouvet.beans.Module;
import fr.ece.ing4.bouvet.beans.Note;
import fr.ece.ing4.bouvet.beans.Professeur;
import fr.ece.ing4.bouvet.beans.Specialite;
import fr.ece.ing4.bouvet.beans.Utilisateur;

import java.io.*;

public class Client {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub

		Socket socket;
		String res;
		String[] resFull;
		ObjectInputStream ois;

		ArrayList<Eleve> listEleve = new ArrayList<Eleve>();
		ArrayList<Inscription> listInscription = new ArrayList<Inscription>();
		ArrayList<Module> listModule = new ArrayList<Module>();
		ArrayList<Note> listNote = new ArrayList<Note>();
		ArrayList<Professeur> listProfesseur = new ArrayList<Professeur>();
		ArrayList<Specialite> listSpecialite = new ArrayList<Specialite>();
		ArrayList<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();

		try {
			socket = new Socket(InetAddress.getLocalHost(), 2009);
			InputStream is = socket.getInputStream();
			ois = new ObjectInputStream(is);
			res = (String) ois.readObject().toString();
			System.out.println(res);
			res = res.replaceAll("]", "");
			res = res.replaceAll("\\[", "");
			res = res.replaceAll(" ", "");
			resFull = res.split("[,_]");
			/*
			 * for (String resF : resFull) { System.out.println(resF); }
			 */
			for (int i = 0; i < resFull.length; i++) {
				if (resFull[i].equalsIgnoreCase("EleveClass")) {
					listEleve.add(new Eleve(Integer.parseInt(resFull[i + 1]), resFull[i + 2],
							Integer.parseInt(resFull[i + 3]), Integer.parseInt(resFull[i + 4])));
				} else if (resFull[i].equalsIgnoreCase("InscriptionClass")) {
					listInscription.add(new Inscription(Integer.parseInt(resFull[i + 1]),
							Integer.parseInt(resFull[i + 2]), Integer.parseInt(resFull[i + 3]), resFull[i + 4],
							Integer.parseInt(resFull[i + 5])));
				} else if (resFull[i].equalsIgnoreCase("ModuleClass")) {
					listModule.add(new Module(Integer.parseInt(resFull[i + 1]), resFull[i + 2],
							Integer.parseInt(resFull[i + 3])));
				} else if (resFull[i].equalsIgnoreCase("NoteClass")) {
					listNote.add(new Note(Integer.parseInt(resFull[i + 1]), Integer.parseInt(resFull[i + 2]),
							Integer.parseInt(resFull[i + 3]), Integer.parseInt(resFull[i + 4]), resFull[i + 5],
							Float.parseFloat(resFull[i + 6])));
				} else if (resFull[i].equalsIgnoreCase("ProfesseurClass")) {
					listProfesseur.add(new Professeur(Integer.parseInt(resFull[i + 1]), resFull[i + 2],
							Integer.parseInt(resFull[i + 3]), Integer.parseInt(resFull[i + 4])));
				} else if (resFull[i].equalsIgnoreCase("SpecialiteClass")) {
					listSpecialite.add(new Specialite(Integer.parseInt(resFull[i + 1]), resFull[i + 2]));
				} else if (resFull[i].equalsIgnoreCase("UtilisateurClass")) {
					System.out.println(resFull[i + 1]+" "+resFull[i + 2]+" "+resFull[i + 3]+" "+resFull[i + 4]+" /");
					listUtilisateur.add(new Utilisateur(Integer.parseInt(resFull[i + 1]), resFull[i + 2],
							resFull[i + 3], resFull[i + 4]));
				}
			}

			// Utilisateur user2 = new Utilisateur(Integer.parseInt(resFull[0]),
			// resFull[1], resFull[2], resFull[3]);

			// System.out.println((Utilisateur)ois.readObject());

			// ObjectInputStream ois = new ObjectInputStream(is);
			/*
			 * ois = new ObjectInputStream( new BufferedInputStream( new
			 * FileInputStream( new File("game.txt"))));
			 * 
			 * try { System.out.println("Affichage de l'user :");
			 * System.out.println("*************************\n");
			 * System.out.println(ois.readObject().toString());
			 * 
			 * } catch (ClassNotFoundException e) { e.printStackTrace(); }
			 * 
			 * ois.close();
			 */
			socket.close();

		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}