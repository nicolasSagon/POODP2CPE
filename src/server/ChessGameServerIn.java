package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import model.observable.ChessGameEnLigne;

public class ChessGameServerIn implements Runnable {


	private ObjectInputStream in;
	private Communication message = null;
	private ChessGameEnLigne chessGame;
	
	public ChessGameServerIn(Socket socket, ChessGameEnLigne chessGame){
		chessGame = chessGame;
		try {
			this.in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {

		while(true){
			try {

				message = (Communication)in.readObject();
				System.out.println("Réception commande " + message.getCommand());
				chessGame.processCommand(message);

			} catch (IOException | ClassNotFoundException e) {

				e.printStackTrace();
			}
		}
		
	}

}
