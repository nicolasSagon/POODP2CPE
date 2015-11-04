package controller.controllerLocal;
import vue.IObserver;
import model.Coord;
import model.Couleur;
import model.PieceIHM;
import model.observable.ChessGame;

public class ChessGameController implements IChessGameController {
	
	private ChessGame chessGame;
	
	public ChessGameController(ChessGame model)
	{
		this.chessGame = model;
	}
	
	public ChessGameController(IObserver vue)
	{
		this.chessGame = new ChessGame();
		chessGame.addObserver(vue);
	}
	
	public void move(Coord cInit, Coord cFinal) {
		move(cInit.x, cInit.y, cFinal.x, cFinal.y);
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		chessGame.move(new Coord(xInit, yInit), new Coord(xFinal, yFinal));
		return true;
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
	
	public void init() {
		this.chessGame.init();
	}

}
