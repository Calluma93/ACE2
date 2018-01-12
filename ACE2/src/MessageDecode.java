import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class MessageDecode implements Runnable{

	public ObjectOutputStream OOS;
	public ObjectInputStream OIS;
	private static Socket clientSocket;
	public String userMessage;
	
	MessageDecode(Socket clientSocket){
		MessageDecode.clientSocket = clientSocket;
	}

public void run() {
	try {
		
		OOS = new ObjectOutputStream(clientSocket.getOutputStream());
		OIS = new ObjectInputStream(clientSocket.getInputStream());
		
		Message message =  new MessageImplementation();
		
		System.out.println("Receiving message from the client...");	
		userMessage = (String) OIS.readObject();
		
		System.out.println("Message received from client");		
		message.setCounts(userMessage);

		OOS.writeObject(message);
		OOS.flush();
		
		System.out.println("Reply sent to client");
		
		OOS.close();
		OIS.close();
		
	}catch(IOException e){
			e.printStackTrace();
			
	}catch(ClassNotFoundException e){
			e.printStackTrace();
	}
	
}

}
