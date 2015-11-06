package model.strategy.ihmstrategy;

import java.awt.Color;
import java.awt.Component;
import java.util.List;

import javax.swing.JPanel;

import model.Coord;

public class UpdateUnabledMoveStrategy implements IIHMStrategy {

	@SuppressWarnings("unchecked")
	@Override
	public void updateIHM(Component chessBoard, Object data) {
		
		for (Coord coord : (List<Coord>) data) {
			JPanel panel = (JPanel) ((JPanel) chessBoard).getComponent(coord.y
					* 8 + coord.x);
			panel.setBackground(Color.green);
		}
	}

}
