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

import fr.ece.ing4.bouvet.beans.Utilisateur;

public class Server implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("Lancement du serveur");
		ServerSocket s = new ServerSocket(2009);
		Socket connex = s.accept();
		System.out.println("Hello T'es Co GG !");

		ObjectInputStream ois;
		ObjectOutputStream oos;
		
		
		Utilisateur user = new Utilisateur(50,"aaaaa","aaaa@aaaa.com","password");
		try {
			OutputStream os =  connex.getOutputStream();
			oos = new ObjectOutputStream(os);
			oos.writeObject(user);
			
			
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
