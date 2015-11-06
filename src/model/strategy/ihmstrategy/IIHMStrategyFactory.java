package model.strategy.ihmstrategy;

public class IIHMStrategyFactory {

	private static IIHMStrategyFactory instance = null;
	
	private IIHMStrategyFactory() {
		
	}
	
	public static IIHMStrategyFactory getInstance() {
		if (instance == null)
			instance = new IIHMStrategyFactory();
		return instance;
	}
	
	public IIHMStrategy createUpdateListPieceStrategy() {	
		return new UpdateListPieceStrategy();
	}
	
	public IIHMStrategy createUptadeUnabledMoveStrategy(){
		return new UpdateUnabledMoveStrategy();
	}
	
}
