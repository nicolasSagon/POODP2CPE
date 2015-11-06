package model.strategy.movement;

import model.Couleur;

public class CavalierMovementStrategy extends AbstractMovementStrategy {

	
	private static AbstractMovementStrategy instance = null;
	public static AbstractMovementStrategy getInstance() {
		if (instance == null)
			instance = new CavalierMovementStrategy();
		return instance;
	}
	
	private CavalierMovementStrategy() {}

	@Override
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal,
			boolean premierCoup, Couleur couleur) {
		boolean ret = false;

		if ((Math.abs(xFinal - xInit) + Math.abs(yFinal - yInit)) == 3) {

			if ((Math.abs(xFinal - xInit) < 3)
					&& (Math.abs(yFinal - yInit) < 3)) {
				ret = true;
			}
		}

		return ret;
	}

}
