package fr.ece.ing4.bouvet.test;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import fr.ece.ing4.bouvet.beans.Utilisateur;

import java.io.*;

public class Client {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Socket socket;
		String res;
		String[] resFull;
		ObjectInputStream ois;

		try {
		
		     socket = new Socket(InetAddress.getLocalHost(),2009);
		     InputStream is= socket.getInputStream();
		     ois = new ObjectInputStream(is);
		     res=(String)ois.readObject().toString();
		     System.out.println(res);
		     resFull = res.split("_");
		     /*for (String retval: res.split("_")){
		         System.out.println(retval);
		      }*/
		     for (String resF : resFull) {
		         System.out.println(resF);
		      }
		     //Utilisateur user2 = new Utilisateur(Integer.parseInt(resFull[0]), resFull[1], resFull[2], resFull[3]);
		     //System.out.println(user2.getId());
		     
		     //System.out.println((Utilisateur)ois.readObject());
		     

		     //ObjectInputStream ois = new ObjectInputStream(is);
		     /*ois = new ObjectInputStream(
						new BufferedInputStream(
								new FileInputStream(
										new File("game.txt"))));

				try {
					System.out.println("Affichage de l'user :");
					System.out.println("*************************\n");
					System.out.println(ois.readObject().toString());

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

				ois.close();*/
	         socket.close();
	             

		}catch (UnknownHostException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
