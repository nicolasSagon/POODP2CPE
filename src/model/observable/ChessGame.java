package model.observable;

import java.util.List;

import model.Coord;
import model.Couleur;
import model.Echiquier;
import model.PieceIHM;

public class ChessGame extends AbstractObservable {

	private Echiquier echiquier;
	private String lastDepl;

	public ChessGame() {
		echiquier = new Echiquier();
		lastDepl = "";
	}
	
	public void init() {
		this.notifyAll(this.toString(), this.getPiecesIHM());
	}

	public List<PieceIHM> getPiecesIHM() {
		return echiquier.getPiecesIHM();
	}
	
	public void move(Coord origin, Coord target) {
		lastDepl = "Déplacement de " + origin.x + "," + origin.y + " vers " + target.x + "," + target.y + " : ";
		boolean isMoveOk = echiquier.isMoveOk(origin.x, origin.y, target.x, target.y);
		if (isMoveOk) {
			boolean moveOk = echiquier.move(origin.x, origin.y, target.x, target.y);
			if (moveOk) {
				echiquier.switchJoueur();
			}
		}
		this.notifyAll(this.toString(), this.getPiecesIHM());
	}
	
	public String toString() {
		return lastDepl + echiquier.getMessage() + "\n" + echiquier;
	}
	
	public boolean isEnd() {
		return echiquier.isEnd();
	}
	
	public String getMessage()  {
		return echiquier.getMessage();
	}
	
	public Couleur getColorCurrentPlayer() {
		return this.echiquier.getColorCurrentPlayer();
	}
}
