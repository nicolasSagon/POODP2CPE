package model.observable;

import model.Coord;
import server.Communication;

public class ChessGameEnLigne extends ChessGame {

	public ChessGameEnLigne() {
		super();
	}

	public synchronized void processCommand(Communication communication) {
		switch (communication.getCommand()) {
			case 1:
				Coord[] coords = (Coord[])communication.getData();
				if (coords.length == 2)
					this.move(coords[0], coords[1]);
				break;
			case 2:
				break;
		}
	}

}
