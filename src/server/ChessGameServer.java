package server;

import java.io.IOException;
import java.net.ServerSocket;

import model.observable.ChessGameEnLigne;


public class ChessGameServer {
	
	private static ServerSocket ss = null;
	private static Thread t;
	private static ChessGameEnLigne chessGame;

	public static void main(String[] args) {

		try {
			ss = new ServerSocket(2000);
			System.out.println("Le serveur est à l'écoute du port " + ss.getLocalPort());

			chessGame = new ChessGameEnLigne();
			
			t = new Thread(new ChessGameAcceptConnexion(ss, chessGame));
			t.start();
			

		} catch (IOException e) {
			System.err.println("Le port "+ss.getLocalPort()+" est d�j� utilis� !");
		}

	}

}
