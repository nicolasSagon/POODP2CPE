package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;

import socket.SocketIn;
import socket.SocketOut;
import vue.ChessGameIHM;
import vue.IObserver;
import controller.controllerLocal.ChessGameControllerClient;
import controller.controllerLocal.IChessGameController;

public class ChessGameClient {

	public static Socket socket = null;
	public static Thread t1;
	public static Thread t2;

	public static void main(String[] args) {
		try {

			System.out.println("Demande de connexion");
			socket = new Socket("127.0.0.1", 2000);
			System.out.println("Connexion établie avec le serveur, authentification :");

			SocketOut out = new SocketOut(socket);
			t1 = new Thread(out);
			
			IChessGameController controller = new ChessGameControllerClient();
			((ChessGameControllerClient) controller).addObserver((IObserver) out);
			
			JFrame frame = new ChessGameIHM(controller);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.pack();
			frame.setResizable(true);
			frame.setLocationRelativeTo(null);
			
			SocketIn threadIn = new SocketIn(socket);
			threadIn.addObserver((IObserver) frame);
			
			t2 = new Thread(threadIn);			
			t1.start();
			t2.start();

			((ChessGameControllerClient)controller).init();
			
			frame.setVisible(true);
		} catch (UnknownHostException e) {
			System.err.println("Impossible de se connecter à l'adresse "
					+ socket.getLocalAddress());
		} catch (IOException e) {
			System.err.println("Aucun serveur à l'écoute du port "
					+ socket.getLocalPort());
		}
	}
}
