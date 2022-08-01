package Ex42movingfigure;

import java.awt.Graphics;

// Exercise 42: A Moving Figure
// Exercise 42.2: Circle
public class Circle extends Figure {
	private int diameter;

	public Circle(int x, int y, int diameter) {
		super(x, y);
		this.diameter = diameter;
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.fillOval(super.getX(), super.getY(), this.diameter, this.diameter);
	}
}