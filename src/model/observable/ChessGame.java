package model.observable;

import java.util.List;
import java.util.Observable;

import model.Coord;
import model.Echiquier;
import model.PieceIHM;

public class ChessGame extends Observable {

	private Echiquier echiquier;
	private String lastDepl;

	public ChessGame() {
		echiquier = new Echiquier();
		lastDepl = "";
	}
	
	public void init() {
		this.notifyObservers(this.toString());
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
		this.notifyObservers(this.toString());
	}
	
	public String toString() {
		return lastDepl + echiquier.getMessage() + "\n" + echiquier;
	}
}
