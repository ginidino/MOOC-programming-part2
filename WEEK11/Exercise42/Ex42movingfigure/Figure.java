package Ex42movingfigure;

import java.awt.Graphics;

// Exercise 42: A Moving Figure
// Exercise 42.1: Figure: an Abstract Class
public abstract class Figure {
	private int x;
	private int y;

	public Figure(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
	
	public abstract void draw(Graphics graphics);
}
