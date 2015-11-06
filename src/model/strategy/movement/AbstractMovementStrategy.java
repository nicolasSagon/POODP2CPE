package model.strategy.movement;

import java.util.HashMap;
import java.util.Map;

import model.Couleur;

public abstract class AbstractMovementStrategy {

	private static int mode = 0;
	private static Map<Integer, String> mapRegleTempete = new HashMap<Integer, String>() {
		{
			put(0, "Tour");
			put(7, "Tour");
			put(1, "Cavalier");
			put(6, "Cavalier");
			put(2, "Fou");
			put(5, "Fou");
		}
	};

	public static void setMode(int mode) {
		AbstractMovementStrategy.mode = mode;
	}

	public static AbstractMovementStrategy getNewStrategy(String type, int x) {
		// System.out.println("AbstractMovementStrategy - type = " + type +
		// " - x = " + x);
		if (AbstractMovementStrategy.mode == 1) {
			// System.out.println("AbstractMovementStrategy.mode == 1");
			if (type.equals("Tour") || type.equals("Fou")
					|| type.equals("Cavalier")) {
				if (!mapRegleTempete.containsKey(x)) {
					return AbstractMovementStrategyFactory
							.createMovementStrategy(type);
				} else {
					return AbstractMovementStrategyFactory
							.createMovementStrategy(mapRegleTempete.get(x));
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
