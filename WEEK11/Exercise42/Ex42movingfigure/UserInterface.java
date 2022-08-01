package Ex42movingfigure;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

// Exercise 42: A Moving Figure
// Exercise 42.3: Drawing Board
public class UserInterface implements Runnable {
	private JFrame frame;
	private Figure figure;

	public UserInterface(Figure figure) {
		this.figure = figure;
	}

	@Override
	public void run() {
		this.frame = new JFrame("A Moving Figure");
		this.frame.setPreferredSize(new Dimension(400, 400));
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		createComponents(frame.getContentPane());
		
		this.frame.pack();
		this.frame.setVisible(true);
	}

	private void createComponents(Container container) {
		DrawingBoard board = new DrawingBoard(this.figure);
		container.add(board);
		
		this.frame.addKeyListener(new KeyboardListener(board, this.figure));	// Exercise 42.4: Keyboard Listener
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
}