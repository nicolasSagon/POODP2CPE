package controller.controllerLocal;

import model.Coord;
import model.observable.ChessGame;

public class ChessGameController {
	
	private String message;
	@SuppressWarnings("unused")
	private ChessGame chessGame;
	
	public ChessGameController(ChessGame chessGame)
	{
		this.chessGame = chessGame;
	}
	
	public void move(Coord a, Coord b)
	{
		
	}
	
	public String getMessage()
	{
		return message;
	}

}
