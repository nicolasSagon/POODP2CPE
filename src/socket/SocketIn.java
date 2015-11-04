package socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import model.observable.AbstractObservable;

public class SocketIn extends AbstractObservable implements Runnable{
	
	private ObjectInputStream in;
	Socket socket;
	
	public SocketIn(Socket socket) {
		this.socket = socket;
		try {
			this.in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Object message = in.readObject();
				this.notifyAll("", message);
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
