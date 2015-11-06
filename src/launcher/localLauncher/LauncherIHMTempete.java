package launcher.localLauncher;

import javax.swing.JFrame;

import vue.ChessGameIHM;
import model.strategy.movement.AbstractMovementStrategy;

public class LauncherIHMTempete {

	public static void main(String[] args) {
		AbstractMovementStrategy.setMode(1);
		JFrame frame = new ChessGameIHM();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
