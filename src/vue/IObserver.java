package vue;

import java.util.List;

import model.PieceIHM;

public interface IObserver {
	
	public void update(String data, List<PieceIHM> list);

}
