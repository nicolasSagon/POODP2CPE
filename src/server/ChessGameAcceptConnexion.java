package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import model.observable.ChessGameEnLigne;


public class ChessGameAcceptConnexion implements Runnable {
	private ServerSocket socketserver = null;
	private Socket socket = null;
private ChessGameEnLigne chessGame;
	public Thread t1;
	public Thread t2;

	public ChessGameAcceptConnexion(ServerSocket ss, ChessGameEnLigne chessGame) {
		socketserver = ss;
		chessGame = chessGame;
	}

	public void run() {

		try {
			while (true) {

				socket = socketserver.accept();
				System.out.println("Un client vient de se connecter.");

				
				t1 = new Thread(new ChessGameServerIn(socket, chessGame));
				t1.start();

			}
		} catch (IOException e) {

			System.err.println("Erreur serveur");
		}

	}
}
