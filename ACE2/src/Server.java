import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server{

	public static ServerSocket serverSocket;
		
public Server(){

	ExecutorService executor = Executors.newFixedThreadPool(2);
		
		while(true){
			Socket socket;
			
			try {
				socket = serverSocket.accept();
				System.out.println("Client has connected");
	            Runnable worker = new MessageDecode(socket);
	            executor.execute(worker);

			}
			
			catch(IOException e){
				e.printStackTrace();
			}
		}

}

public static void main(String[] args) throws IOException{
	
		System.out.println("Initialising Server...");
		serverSocket = new ServerSocket(6100);
		System.out.println("Server initialised on Port 6100");
	    new Server();
	    
}

}
