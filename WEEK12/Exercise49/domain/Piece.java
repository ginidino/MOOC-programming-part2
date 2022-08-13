package wormgame.domain;

// Exercise 49: Worm Game
// Exercise 49.1: Piece and Apple
public class Piece {
	private int x;
	private int y;

	public Piece(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean runsInto(Piece piece) {
		return this.x == piece.getX() && this.y == piece.getY();
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.append("(" + getX() + ", " + getY() + ")").toString();
	}
}
