package controller.controllerLocal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

import model.Couleur;
import model.PieceIHM;

public class ChessGameControllerClient implements Runnable, IChessGameController {

	private Socket socket;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			socket = new Socket(InetAddress.getLocalHost(), 2000);
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			List<PieceIHM> result = (List<PieceIHM>)input.readObject();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		// TODO Auto-generated method stub
		return null;
	}	
	
}
