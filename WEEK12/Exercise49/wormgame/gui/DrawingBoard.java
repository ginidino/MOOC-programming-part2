package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

// Exercise 49: Worm Game
// Exercise 49.6: DrawingBoard
public class DrawingBoard extends JPanel implements Updatable {
	private WormGame wormGame;
	private int pieceLength;
	
	public DrawingBoard(WormGame wormGame, int pieceLength) {
		this.wormGame = wormGame;
		this.pieceLength = pieceLength;
	}
	
	@Override
    protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		for (Piece piece : this.wormGame.getWorm().getPieces()) {
			graphics.setColor(Color.BLACK);
			graphics.fill3DRect(pieceLength * piece.getX(), pieceLength * piece.getY(), pieceLength, pieceLength, true);
		}
		
		graphics.setColor(Color.RED);
		graphics.fillOval(pieceLength * this.wormGame.getApple().getX(), pieceLength * this.wormGame.getApple().getY(), pieceLength, pieceLength);
	}

	@Override
	public void update() {
		super.repaint();
	}
}