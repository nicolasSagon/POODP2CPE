package model.strategy.ihmstrategy;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tools.ChessImageProvider;
import model.Coord;
import model.PieceIHM;

public class UpdateListPieceStrategy implements IIHMStrategy {

	public UpdateListPieceStrategy() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateIHM(Component chessBoard, Object data) {

		for (int i = 0; i < 64; i++) {

			JPanel square = ((JPanel) ((JPanel) chessBoard).getComponent(i));
			
			int row = (i / 8) % 2;
			if (row == 0)
				square.setBackground(i % 2 == 0 ? Color.blue : Color.white);
			else
				square.setBackground(i % 2 == 0 ? Color.white : Color.blue);

			square.removeAll();
		}
		
		for (PieceIHM piece : (java.util.List<PieceIHM>) data) {
			for (Coord coord : piece.getList()) {
				JLabel pion;
				pion = new JLabel(new ImageIcon(
						ChessImageProvider.getImageFile(piece.getTypePiece(),
								piece.getCouleur())));
				JPanel panel = (JPanel) ((JPanel) chessBoard)
						.getComponent(coord.y * 8 + coord.x);
				panel.add(pion);
			}
		}

	}

}
