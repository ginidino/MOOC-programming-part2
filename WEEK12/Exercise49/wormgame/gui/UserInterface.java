package wormgame.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import wormgame.game.WormGame;

// Exercise 49: Worm Game
// Exercise 49.7: User Interface
public class UserInterface implements Runnable {
	private JFrame frame;
	private WormGame game;
	private DrawingBoard drawingBoard;
	private int sideLength;

	public UserInterface(WormGame game, int sideLength) {
		this.game = game;
		this.sideLength = sideLength;
	}

	@Override
	public void run() {
		int width = (this.game.getWidth() + 1) * this.sideLength + 10;
		int height = (this.game.getHeight() + 2) * this.sideLength + 10;
		
		this.frame = new JFrame("Worm Game");
		this.frame.setPreferredSize(new Dimension(width, height));
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		createComponents(this.frame.getContentPane());
		
		this.frame.pack();
		this.frame.setVisible(true);
	}

	private void createComponents(Container container) {
		this.drawingBoard = new DrawingBoard(this.game, this.sideLength);
		container.add(this.drawingBoard);
		
		this.frame.addKeyListener(new KeyboardListener(this.game.getWorm()));
	}

	public Updatable getUpdatable() {
		return null;
	}
	
	public JFrame getFrame() {
        return this.frame;
    }
}