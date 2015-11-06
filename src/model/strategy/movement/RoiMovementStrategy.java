package model.strategy.movement;

import model.Couleur;

public class RoiMovementStrategy extends AbstractMovementStrategy {

	
	private static AbstractMovementStrategy instance = null;
	public static AbstractMovementStrategy getInstance() {
		if (instance == null)
			instance = new RoiMovementStrategy();
		return instance;
	}
	
	private RoiMovementStrategy() {}
	
	@Override
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal,
			boolean premierCoup, Couleur couleur) {
		boolean ret = false;

		if ((Math.abs(yFinal - yInit) <= 1)
				&& (Math.abs(xFinal - xInit) <= 1)) {
			ret = true;
		}

		return ret;
	}
}
