package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import socket.SocketIn;
import socket.SocketOut;
import vue.IObserver;
import controller.controllerLocal.ChessGameControllerServer;
import model.observable.ChessGame;

public class ChessGameServer {

	private static ServerSocket ss = null;
	private static ChessGame chessGame;
	private static Socket socketBlanche = null;
	private static Socket socketNoire = null;

	public static void main(String[] args) {

		try {
			ss = new ServerSocket(2000);
			System.out.println("Le serveur est à l'écoute du port "
					+ ss.getLocalPort());

			chessGame = new ChessGame();
			int nbConnection = 0;
			try {
				while (true) {
					Boolean isAccept = false;
					Socket socket = ss.accept();
					if (nbConnection == 0) {
						socketBlanche = socket;
						isAccept = true;

					} else if (nbConnection == 1) {
						socketNoire = socket;
						isAccept = true;
					}
					if (isAccept) {
						System.out.println("Un client viens de se connecter  ");

						ChessGameControllerServer controllerServer = new ChessGameControllerServer(
								chessGame);
						SocketIn inThread = new SocketIn(socket);
						inThread.addObserver((IObserver) controllerServer);

						Thread t1 = new Thread(inThread);
						t1.start();
						SocketOut chessGameServerOut = new SocketOut(socket);
						chessGame.addObserver((IObserver) chessGameServerOut);
						Thread t2 = new Thread(chessGameServerOut);
						t2.start();
					}
				}
			} catch (IOException e) {

				System.err.println("Erreur serveur");
			}

		} catch (IOException e) {
			System.err.println("Le port " + ss.getLocalPort()
					+ " est d�j� utilis� !");
		}

	}

}
