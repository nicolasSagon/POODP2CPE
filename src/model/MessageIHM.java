package model;

import model.strategy.ihmstrategy.IIHMStrategy;

public class MessageIHM {
	
	private Object data;
	private IIHMStrategy strategy;

	public MessageIHM(Object data, IIHMStrategy strategy) {
		this.setData(data);
		this.setStrategy(strategy);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public IIHMStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(IIHMStrategy strategy) {
		this.strategy = strategy;
	}
}
