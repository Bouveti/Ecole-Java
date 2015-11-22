package fr.ece.ing4.bouvet.test;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import fr.ece.ing4.bouvet.beans.Eleve;
import fr.ece.ing4.bouvet.beans.Inscription;
import fr.ece.ing4.bouvet.beans.Module;
import fr.ece.ing4.bouvet.beans.Utilisateur;

import java.io.*;

public class Client {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub

		Socket socket;
		String res;
		String resSplited;
		String[] resFull;
		ObjectInputStream ois = null;

		ArrayList<Utilisateur> listUser = new ArrayList<Utilisateur>();
		ArrayList<Eleve> listEleve = new ArrayList<Eleve>();
		ArrayList<Inscription> listInscriptions = new ArrayList<Inscription>();
		ArrayList<Module> listModule = new ArrayList<Module>();

		try {
			socket = new Socket(InetAddress.getLocalHost(), 2009);
			InputStream is = socket.getInputStream();

			// try {
			ois = new ObjectInputStream(is);
			System.out.println("j'y passe");
			// ta lecture de fichier
			// } catch (EOFException e)
			// {
			System.out.println("kek");
			// ferme le fichier dans ce cas
			// }
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
					System.out.println(resFull[i + 1]);
					listEleve.add(new Eleve(Integer.parseInt(resFull[i + 1]), resFull[i + 2],
							Integer.parseInt(resFull[i + 3]), Integer.parseInt(resFull[i + 4])));
				} else if (resFull[i].equalsIgnoreCase("UtilisateurClass")) {
					System.out.println(resFull[i + 1]);
					listUser.add(new Utilisateur(Integer.parseInt(resFull[i + 1]), resFull[i + 2], resFull[i + 3],
							resFull[i + 4]));
				} else if (resFull[i].equalsIgnoreCase("UtilisateurClass")) {
					System.out.println(resFull[i + 1]);
					listUser.add(new Utilisateur(Integer.parseInt(resFull[i + 1]), resFull[i + 2], resFull[i + 3],
							resFull[i + 4]));
				} else if (resFull[i].equalsIgnoreCase("InscriptionClass")) {
					System.out.println(resFull[i + 1]);
					listUser.add(new Utilisateur(Integer.parseInt(resFull[i + 1]), resFull[i + 2], resFull[i + 3],
							resFull[i + 4]));
				} else if (resFull[i].equalsIgnoreCase("UtilisateurClass")) {
					System.out.println(resFull[i + 1]);
					listUser.add(new Utilisateur(Integer.parseInt(resFull[i + 1]), resFull[i + 2], resFull[i + 3],
							resFull[i + 4]));
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
			// System.out.println("error 1");
			e.printStackTrace();
		} catch (IOException e) {
			// System.out.println("error 2");
			e.printStackTrace();
		}

	}

}
