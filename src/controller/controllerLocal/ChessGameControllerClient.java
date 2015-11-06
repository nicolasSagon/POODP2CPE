package controller.controllerLocal;

import java.util.ArrayList;
import java.util.List;

import model.Communication;
import model.Coord;
import model.Couleur;
import model.observable.AbstractObservable;

public class ChessGameControllerClient extends AbstractObservable implements
		IChessGameController{
	
	public ChessGameControllerClient() {
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		List<Coord> coords = new ArrayList<Coord>();
		coords.add(0, new Coord(xInit, yInit));
		coords.add(1,new Coord(xFinal, yFinal));
		Communication communication = new Communication(1, coords);
		this.notifyAll("", communication);
		return true;
	}

	@Override
	public boolean isEnd() {
		return false;
	}

	@Override
	public String getMessage() {
		return null;
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		return null;
	}
	
	public void init() {
		Communication communication = new Communication(2, null);
		this.notifyAll("", communication);
	}

	@Override
	public void getUnabledMove(Coord c) {
		Communication communication = new Communication(3, c);
		this.notifyAll("", communication);
		
	}

}
