package fr.ece.ing4.bouvet.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Socket socket;

		try {
		
		     socket = new Socket(InetAddress.getLocalHost(),2009);	
	             socket.close();

		}catch (UnknownHostException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
