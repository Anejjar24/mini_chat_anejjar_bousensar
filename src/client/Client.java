package client;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
public static void main(String[] args) {
		
		try {
			// récupération de l'adresse IP du serveur
			//byte[] ipAddress=new byte[] {(byte)192,(byte)168,(byte)80,(byte)118};
			//InetAddress address=InetAddress.getByAddress(ipAddress);
			
			
			// L'atblissement d'une connexion avec le serveur sur le port spécifié
			int port=1000;
			InetAddress address=InetAddress.getByName("localhost");
			Socket socket=new Socket(address,port);
			
			// Obtenation de référence de flux entrant
			InputStream in=socket.getInputStream();
			
			// Obtenation de référence de flux sortant
			OutputStream out=socket.getOutputStream();
			
			
			// crée un PrintWriter pour envoyer des chaînes de caractères
			PrintWriter sortie=new PrintWriter(out);
			
			// Crée un Scanner pour lire l'entrée utilisateur
			Scanner scanner=new Scanner(System.in);
			
			
			String message;
			
			while(true) {
				
				 // Demande à l'utilisateur d'entrer un message
				System.out.println("Ecrivez votre message : ");
				message=scanner.nextLine();
				
				
				// Si l'utilisateur entre "exit", on sort de la boucle
				if("exit".equalsIgnoreCase(message))
					break;
				
				 // Envoie le message au serveur
				sortie.println(message);
				
				 // Force l'envoi immédiat du message
				sortie.flush();
				
				//System.out.println("Message envoyé : " + message);
				
			}
			
			// Ferme les flux et le socket
            scanner.close();
            sortie.close();
            socket.close();
		}
		catch(IOException  e) {e.printStackTrace();}
	
		
		
	}
}
