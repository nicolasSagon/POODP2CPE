package socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import vue.IObserver;
import model.Communication;

public class SocketOut implements Runnable, IObserver{
	

	private ObjectOutputStream out;

	public SocketOut(Socket socket) {
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
	}

	@Override
	public void update(String dataStr, Object dataObj) {
		try {
			out.writeObject(dataObj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
