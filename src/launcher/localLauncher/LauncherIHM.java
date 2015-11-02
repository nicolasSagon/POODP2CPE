package launcher.localLauncher;

import javax.swing.JFrame;

import controller.controllerLocal.ChessGameControllerClient;
import vue.ChessGameIHM;



/**	
 * @author francoise.perrin
 * Lance l'exécution d'un jeu d'échec en mode console.
 */
public class LauncherIHM {
	
	public static void main(String[] args) {	
		/*JFrame frame = new ChessGameIHM();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);*/
		
		ChessGameControllerClient c = new ChessGameControllerClient();
		c.run();
		for(;;);
	}

}
