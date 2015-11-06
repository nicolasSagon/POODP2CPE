package model.strategy.movement;

import model.Couleur;

public abstract class AbstractMovementStrategy {

	private static int mode = 0;

	public static void setMode(int mode) {
		AbstractMovementStrategy.mode = mode;
	}

	public static AbstractMovementStrategy getNewStrategy(String type, int x) {
		//System.out.println("AbstractMovementStrategy - type = " + type + " - x = " + x);
		if (AbstractMovementStrategy.mode == 1) {
			//System.out.println("AbstractMovementStrategy.mode == 1");
			if (type.equals("Tour") || type.equals("Fou") || type.equals("Cavalier")) {
				switch (x) {
				case 0:
				case 7:
					//System.out.println("Devient une tour batard!");
					return AbstractMovementStrategyFactory
							.createMovementStrategy("Tour");
				case 1:
				case 6:
					//System.out.println("Devient un cavalier batard!");
					return AbstractMovementStrategyFactory
							.createMovementStrategy("Cavalier");
				case 2:
				case 5:
					//System.out.println("Devient un fou batard!");
					return AbstractMovementStrategyFactory
							.createMovementStrategy("Fou");
				default:
					//System.out.println("Redevient normal batard!");
					return AbstractMovementStrategyFactory
							.createMovementStrategy(type);
				}
			}
		}
		return null;
	}

	public boolean isMoveOk(int xInit, int yInit, int xFinal, int yFinal,
			Couleur couleur) {
		return isMoveOk(xInit, yInit, xFinal, yFinal, false, couleur);
	}

	public abstract boolean isMoveOk(int xInit, int yInit, int xFinal,
			int yFinal, boolean premierCoup, Couleur couleur);

}
