package vue;

import java.util.Observable;
import java.util.Observer;

import controller.controllerLocal.ChessGameController;
import model.Coord;



/**
 * @author francoise.perrin
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD *
 * 
 */
public class ChessGameCmdLine implements Observer {
	
	private ChessGameController chessGameController;
	
	public ChessGameCmdLine() {
		chessGameController = new ChessGameController((Observer) this);
		while(true){
			
		}
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("test");
		System.out.println(arg1);		
	}

}
