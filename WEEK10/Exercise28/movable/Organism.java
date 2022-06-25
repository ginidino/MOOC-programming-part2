package movable;

// Exercise 28: Groups
// Exercise 28.1: Implementing Organism
public class Organism implements Movable {
	private int x;
	private int y;
	
	public Organism(int x, int y) {
		// it receives the x and y initial coordinates of the object
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "x: " + this.x + "; y: " + this.y;
	}

	@Override
	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
}
