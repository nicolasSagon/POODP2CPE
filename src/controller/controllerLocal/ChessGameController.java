package controller.controllerLocal;

import java.util.Observer;

import model.Coord;
import model.observable.ChessGame;

public class ChessGameController {
	
	private ChessGame chessGame;
	
	public ChessGameController(Observer vue)
	{
		this.chessGame = new ChessGame();
		chessGame.addObserver(vue);
		this.chessGame.init();
	}
	
	public void move(Coord a, Coord b)
	{
		chessGame.move(a, b);
	}

}
