package Ex42movingfigure;

import java.awt.Graphics;

// Exercise 42: A Moving Figure
// Exercise 42.5: Square and Box
public class Square extends Figure {
	private int sideLength;

	public Square(int x, int y, int sideLength) {
		super(x, y);
		this.sideLength = sideLength;
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.fillRect(super.getX(), super.getY(), sideLength, sideLength);
	}
}