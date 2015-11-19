package fr.ece.ing4.bouvet.connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

	public Serveur (/*int port*/) throws IOException{

		ServerSocket s = new ServerSocket(2009);
		while(true){
			Socket connex = s.accept();
			System.out.println("Hello T'es Co GG !");
			
			/*new Thread(new Evaluateur(connex)).start();
			DataInputStream dis = new DataInputStream(connex.getInputStream());
			DataOutputStream dos = new DataOutputStream(connex.getOutputStream());

			int a = dis.readInt();
			char op = dis.readChar();
			int b = dis.readInt();
			
			dis.close();
			dos.close();*/
			
			
		}
	}
}