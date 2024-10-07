package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
	public static void main(String[] args) {
		try {
			//créer serveur  sur le port spécifique
		int port=1000;
		ServerSocket serverSocket=new ServerSocket(port);
		
			// Attente de  la connexion d'un client et accepter
		Socket socket=serverSocket.accept();
		 System.out.println("Connexion avec client");
		
			// Obtenation de référence de flux entrant
		InputStream in=socket.getInputStream();
			// Obtenation de référence de flux sortant
		OutputStream out=socket.getOutputStream();
			//création d’un stream convertissant les bytes reçus en char
		InputStreamReader reader=new InputStreamReader(in);
			// Créer un flux de lecture avec tampon pour lire flux de caractéres
		BufferedReader entree=new BufferedReader(reader);
		String message;
		  // Boucle de lecture des messages envoyés par le client
		  while((message=entree.readLine())!=null) {
			  System.out.println(message);
			  // Si le client envoie "exit", le serveur peut fermer la connexion
			  if("exit".equalsIgnoreCase(message)) { 
				 
				  break;
			  }
				  
		  }
		// Ferme les flux et le socket
		  entree.close();
          socket.close();
          serverSocket.close();
		
		}
		catch(UnknownHostException e) {e.printStackTrace();}
		catch(IOException  e) {e.printStackTrace();}	
		
	}
}
