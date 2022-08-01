package Ex42movingfigure;

import java.awt.Graphics;
import javax.swing.JPanel;

// Exercise 42: A Moving Figure
// Exercise 42.3: Drawing Board
public class DrawingBoard extends JPanel {
	private Figure figure;
	
	public DrawingBoard(Figure figure) {
		this.figure = figure;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.figure.draw(g);
	}
}