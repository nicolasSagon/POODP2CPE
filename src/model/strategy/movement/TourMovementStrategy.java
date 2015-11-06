package model.strategy.movement;

import model.Couleur;

public class TourMovementStrategy extends AbstractMovementStrategy {

	
	private static AbstractMovementStrategy instance = null;
	public static AbstractMovementStrategy getInstance() {
		if (instance == null)
			instance = new TourMovementStrategy();
		return instance;
	}
	
	private TourMovementStrategy() {}
	
	@Override
	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal,
			boolean premierCoup, Couleur couleur) {
		boolean ret = false;

		if ((yFinal == yInit) || (xFinal == xInit)) {
			ret = true;
		}

		return ret;
	}
}
