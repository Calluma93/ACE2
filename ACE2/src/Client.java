import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Socket{
	
	transient Scanner s = new Scanner(System.in);	
	private String messageToServer;
	static public Socket socket;
	public ObjectOutputStream OOS;
	public ObjectInputStream OIS;
	
public void sendToServer(){
	try{
		        
			messageToServer = s.nextLine();
			
			OOS = new ObjectOutputStream(socket.getOutputStream());	
			OOS.writeObject(messageToServer);
			OOS.flush();
			
	}catch(IOException i){
		i.printStackTrace();

	}
}
		
public void receiveFromServer(){
	try{
			
		System.out.println("Receiving message from the server...");
		OIS = new ObjectInputStream(socket.getInputStream());				
				
		Message message = (Message) OIS.readObject();
		System.out.println("Message received from server");
		System.out.println("Original message sent from the client: " + message.getClientMessage());
		System.out.println("Amount of characters: " + message.getCharacterCount());
		System.out.println("Amount of digits: " + message.getDigitCount());
			
	}catch(IOException i){
		i.printStackTrace();

	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
}

public static void main(String[] args) throws IOException {
	
		Client client = new Client();
		socket = new Socket(InetAddress.getLocalHost(), 6100);
		System.out.println("Type message you wish to send.");
			
		client.sendToServer();
		client.receiveFromServer();
			
		client.close();
}

}
