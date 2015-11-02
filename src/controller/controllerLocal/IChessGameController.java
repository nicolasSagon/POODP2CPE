package controller.controllerLocal;

import model.Couleur;

public interface IChessGameController {
	public String toString();

	public boolean move(int xInit, int yInit, int xFinal, int yFinal);

	public boolean isEnd();

	public String getMessage();

	public Couleur getColorCurrentPlayer();
}
