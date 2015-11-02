package server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChessGameServerOut implements Runnable {

	private ObjectOutputStream out;
	private String message = null;

	public ChessGameServerOut(Socket socket) {
		try {
			this.out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void run() {

		while(true){
			System.out.print("Votre message : ");
			message = sc.nextLine();
			out.println(message);
			out.flush();
		}
	}

}
