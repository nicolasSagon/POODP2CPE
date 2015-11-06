package model.strategy.movement;

import model.Couleur;

public class ReineMovementStrategy extends AbstractMovementStrategy {

	
	private static AbstractMovementStrategy instance = null;
	public static AbstractMovementStrategy getInstance() {
		if (instance == null)
			instance = new ReineMovementStrategy();
		return instance;
	}
	
	private ReineMovementStrategy() {}
	
	@Override
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal,
			boolean premierCoup, Couleur couleur) {
		boolean ret = false;

		if (Math.abs(yFinal - yInit) == Math.abs(xFinal - xInit)
				|| ((yFinal == yInit) || (xFinal == xInit))) {
			ret = true;
		}

		return ret;
	}

}
