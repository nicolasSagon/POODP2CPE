package launcher.localLauncher;

import model.observable.ChessGame;
import vue.ChessGameCmdLine;
import controller.controllerLocal.ChessGameController;


/**
 * @author francoise.perrin
 * Lance l'exécution d'un jeu d'échec en mode console.
 */
public class LauncherCmdLine {
	
	public static void main(String[] args) {		
		
		ChessGame chessGame;
		ChessGameController chessGameControler;		
		
		chessGame = new ChessGame();	
		chessGameControler = new ChessGameController(chessGame);
		
		new ChessGameCmdLine(chessGameControler);	
	}

}
