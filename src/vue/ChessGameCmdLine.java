package vue;



import controller.controllerLocal.ChessGameController;
import model.Coord;



/**
 * @author francoise.perrin
 * Inspiration Jacques SARAYDARYAN, Adrien GUENARD *
 * 
 */
public class ChessGameCmdLine implements IObserver {
	
	private ChessGameController chessGameController;
	
	public ChessGameCmdLine() {
		chessGameController = new ChessGameController(this);
		chessGameController.move(new Coord(0,6), new Coord(0,5));
		chessGameController.move(new Coord(1,1), new Coord(1,3));
		chessGameController.move(new Coord(0,5), new Coord(0,4));
		chessGameController.move(new Coord(1,3), new Coord(0,4));
		
	}

	@Override
	public void update(String dataStr, Object dataObj) {
		System.out.println(dataStr);		
	}

}
