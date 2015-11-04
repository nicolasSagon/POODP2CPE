package controller.controllerLocal;

import java.util.List;

import model.Communication;
import model.Coord;
import model.observable.ChessGame;
import vue.IObserver;

public class ChessGameControllerServer extends ChessGameController implements IObserver{


	public ChessGameControllerServer(ChessGame model) {
		super(model);
	}

	@Override
	public void update(String dataStr, Object dataObj) {
		Communication message = (Communication) dataObj;
		switch (message.getCommand()) {
		case 1:
			@SuppressWarnings("unchecked")
			List<Coord> coords = (List<Coord>) (message.getData());
			this.move(coords.get(0).x, coords.get(0).y, coords.get(1).x,
					coords.get(1).y);
			break;
		case 2:
			((ChessGameController) this).init();
			break;
		}		
	}
}
