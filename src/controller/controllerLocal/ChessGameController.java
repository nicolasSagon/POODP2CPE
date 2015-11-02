package controller.controllerLocal;
import vue.IObserver;
import model.Coord;
import model.Couleur;
import model.PieceIHM;
import model.observable.ChessGame;

public class ChessGameController implements IChessGameController {
	
	private ChessGame chessGame;
	
	public ChessGameController(IObserver vue)
	{
		this.chessGame = new ChessGame();
		chessGame.addObserver(vue);
		this.chessGame.init();
	}
	
	public void move(Coord a, Coord b)
	{
		chessGame.move(a, b);
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {

		chessGame.move(new Coord(xInit, yInit), new Coord(xFinal, yFinal));
		return false;
	}

	@Override
	public boolean isEnd() {
		return chessGame.isEnd();
	}

	@Override
	public String getMessage() {
		return chessGame.getMessage();
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		return chessGame.getColorCurrentPlayer();
	}
	
	public java.util.List<PieceIHM> getPiecesIHM() {
		return chessGame.getPiecesIHM();
	}

}
