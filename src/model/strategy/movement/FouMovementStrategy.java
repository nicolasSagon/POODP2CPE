package model.strategy.movement;

import model.Couleur;

public class FouMovementStrategy extends AbstractMovementStrategy {

	
	private static AbstractMovementStrategy instance = null;
	public static AbstractMovementStrategy getInstance() {
		if (instance == null)
			instance = new FouMovementStrategy();
		return instance;
	}
	
	private FouMovementStrategy() {}
	
	@Override
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal,
			boolean premierCoup, Couleur couleur) {

		boolean ret = false;

		if (Math.abs(yFinal - yInit) == Math.abs(xFinal - xInit)) {
			ret = true;
		}

		return ret;
	}

}
