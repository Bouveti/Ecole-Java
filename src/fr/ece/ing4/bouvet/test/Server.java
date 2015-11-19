package fr.ece.ing4.bouvet.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			
		ServerSocket socketserver  ;
		Socket socketduserveur ;
		socketserver = new ServerSocket(2009);
		try {
		
			socketduserveur = socketserver.accept(); 
			System.out.println("Un zéro s'est connecté !");
		        socketserver.close();
		        socketduserveur.close();

		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
