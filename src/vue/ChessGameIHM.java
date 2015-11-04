package vue;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import tools.ChessImageProvider;
import model.Coord;
import model.PieceIHM;
import controller.controllerLocal.ChessGameController;
import controller.controllerLocal.IChessGameController;

@SuppressWarnings("serial")
public class ChessGameIHM extends JFrame implements MouseListener,
		MouseMotionListener, IObserver {

	private JLayeredPane layeredPane;
	private JPanel chessBoard;
	private JLabel chessPiece;
	private int xAdjustment;
	private int yAdjustment;
	private IChessGameController chessGameController = null;
	private int indexStartMove;

	public ChessGameIHM(IChessGameController controller) {		
		this.init();
		this.chessGameController = controller;
	}

	public ChessGameIHM() {
		this.init();
		this.chessGameController = new ChessGameController(this);
		((ChessGameController)this.chessGameController).init();
	}
	
	private void init() {
		Dimension boardSize = new Dimension(600, 600);

		// Use a Layered Pane for this this application
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane);
		layeredPane.setPreferredSize(boardSize);
		layeredPane.addMouseListener(this);
		layeredPane.addMouseMotionListener(this);

		// Add a chess board to the Layered Pane

		chessBoard = new JPanel();
		layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
		chessBoard.setLayout(new GridLayout(8, 8));
		chessBoard.setPreferredSize(boardSize);
		chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);

		for (int i = 0; i < 64; i++) {
			JPanel square = new JPanel(new BorderLayout());
			chessBoard.add(square);

			int row = (i / 8) % 2;
			if (row == 0)
				square.setBackground(i % 2 == 0 ? Color.blue : Color.white);
			else
				square.setBackground(i % 2 == 0 ? Color.white : Color.blue);
		}
	}

	public void mousePressed(MouseEvent e) {
		chessPiece = null;
		Component c = chessBoard.findComponentAt(e.getX(), e.getY());
		indexStartMove = getComponentId(c);

		if (c instanceof JPanel)
			return;

		Point parentLocation = c.getParent().getLocation();
		xAdjustment = parentLocation.x - e.getX();
		yAdjustment = parentLocation.y - e.getY();
		chessPiece = (JLabel) c;
		chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
		chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
		layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
	}

	// Move the chess piece around

	public void mouseDragged(MouseEvent me) {
		if (chessPiece == null)
			return;

		chessPiece
				.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
	}

	// Drop the chess piece back onto the chess board

	public int getComponentId(Component c) {

		for (int i = 0; i < chessBoard.getComponentCount(); i++) {

			if (chessBoard.getComponent(i) == c.getParent()
					|| chessBoard.getComponent(i) == c)
				return i;
		}

		return -1;
	}

	public void mouseReleased(MouseEvent e) {
		if (chessPiece == null)
			return;

		Component c = chessBoard.findComponentAt(e.getX(), e.getY());
		int id = getComponentId(c);

		int xInit = indexStartMove % 8;
		int yInit = (indexStartMove - xInit) / 8;

		int xFinal = id % 8;
		int yFinal = (id - xFinal) / 8;

		chessGameController.move(xInit, yInit, xFinal, yFinal);

		chessPiece.setVisible(false);
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(String dataStr, Object dataObj) {

		System.out.println(dataStr);

		// TODO Auto-generated method stub
		for (int i = 0; i < 64; i++) {
			((JPanel) chessBoard.getComponent(i)).removeAll();
		}
		for (PieceIHM piece : (java.util.List<PieceIHM>) dataObj) {
			for (Coord coord : piece.getList()) {
				JLabel pion;
				pion = new JLabel(new ImageIcon(
						ChessImageProvider.getImageFile(piece.getTypePiece(),
								piece.getCouleur())));
				JPanel panel = (JPanel) chessBoard.getComponent(coord.y * 8
						+ coord.x);
				panel.add(pion);
			}
		}
		this.revalidate();
		this.repaint();
	}
}