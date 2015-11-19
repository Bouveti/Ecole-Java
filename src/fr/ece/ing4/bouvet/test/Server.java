package fr.ece.ing4.bouvet.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			
		ServerSocket s = new ServerSocket(2009);
		while(true){
			Socket connex = s.accept();
			System.out.println("Hello T'es Co GG !");
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
