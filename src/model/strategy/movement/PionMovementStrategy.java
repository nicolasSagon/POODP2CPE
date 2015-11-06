package model.strategy.movement;

import model.Couleur;

public class PionMovementStrategy extends AbstractMovementStrategy {

	
	private static AbstractMovementStrategy instance = null;
	public static AbstractMovementStrategy getInstance() {
		if (instance == null)
			instance = new PionMovementStrategy();
		return instance;
	}
	
	private PionMovementStrategy() {}
	
	@Override
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal, boolean premierCoup, Couleur couleur) {
		boolean ret = false;

		if ((xFinal == xInit)
				&& (Math.abs(yFinal - yInit) <= 1 || 
				(Math.abs(yFinal - yInit) <= 2 && premierCoup==true))) {

			if ((Couleur.NOIR.equals(couleur) && (yFinal - yInit > 0))
					|| (Couleur.BLANC.equals(couleur) 
							&& (yFinal - yInit < 0))) {
				ret = true;
			}
		}

		return ret;
	}

}
