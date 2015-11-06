package model.strategy.movement;

import tools.Introspection;

public abstract class AbstractMovementStrategyFactory {

	public static AbstractMovementStrategy createMovementStrategy(String type) {
		try {
			return (AbstractMovementStrategy) Introspection.invokeStatic(
					"model.strategy.movement." + type + "MovementStrategy",
					null, "getInstance");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
