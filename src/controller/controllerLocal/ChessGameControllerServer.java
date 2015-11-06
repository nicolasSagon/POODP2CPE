package controller.controllerLocal;

import java.util.List;

import model.Communication;
import model.Coord;
import model.Couleur;
import model.observable.ChessGame;
import vue.IObserver;

public class ChessGameControllerServer extends ChessGameController implements
		IObserver {

	private Couleur couleur;

	public ChessGameControllerServer(ChessGame model, Couleur couleur) {
		super(model);
		this.couleur = couleur;
	}

	@Override
	public void update(String dataStr, Object dataObj) {
		Communication message = (Communication) dataObj;
		switch (message.getCode()) {
		case 1:
			if (this.getColorCurrentPlayer() == couleur) {
				@SuppressWarnings("unchecked")
				List<Coord> coords = (List<Coord>) (message.getData());
				this.move(coords.get(0).x, coords.get(0).y, coords.get(1).x,
						coords.get(1).y);
			} else {
				this.init();
			}
			break;
		case 2:
			this.init();
			break;
		case 3:
			this.getUnabledMove((Coord) message.getData());
			break;
		}

	}
}
