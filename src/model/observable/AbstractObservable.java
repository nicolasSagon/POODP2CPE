package model.observable;

import java.util.ArrayList;
import java.util.List;

import vue.IObserver;

public abstract class AbstractObservable {
	
	private List<IObserver> observers;
	
	public AbstractObservable() {
		observers = new ArrayList<IObserver>();
	}

	
	public void addObserver(IObserver observer) {
		observers.add(observer);
	}
	
	public void notifyAll(String data) {
		for(IObserver observer : observers) {
			observer.update(data);
		}
	}
	
}
