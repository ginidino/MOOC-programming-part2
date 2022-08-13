package wormgame.domain;

import java.util.ArrayList;
import java.util.List;
import wormgame.Direction;

// Exercise 49: Worm Game
// Exercise 49.2: Worm
public class Worm {
	private int x;
	private int y;
	private Direction direction;
	private List<Piece> worm;
	private boolean grow;
	
	public Worm(int originalX, int originalY, Direction originalDirection) {
		this.x = originalX;
		this.y = originalY;
		this.direction = originalDirection;
		this.worm = new ArrayList<Piece>();
		this.worm.add(new Piece(x, y));
		this.grow = false;
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	public void setDirection(Direction dir) {
		this.direction = dir;
	}
	
	public int getLength() {
		return this.worm.size();
	}
	
	public List<Piece> getPieces() {
		return this.worm;
	}
	
	public void move() {
		int newX = this.worm.get(this.worm.size() - 1).getX();
		int newY = this.worm.get(this.worm.size() - 1).getY();
		
		if (this.direction == Direction.UP) {
			newY--;
		} else if (this.direction == Direction.DOWN) {
			newY++;
		} else if (this.direction == Direction.LEFT) {
			newX--;
		} else if (this.direction == Direction.RIGHT) {
			newX++;
		}
		
		if (getLength() > 2 && !this.grow) {
			this.worm.remove(0);
		}
		
		if (this.grow =true) {
			this.grow = false;
		}
		
		this.worm.add(new Piece(newX, newY));
	}
	
	public void grow() {
		this.grow = true;
	}
	
	public boolean runsInto(Piece piece) {
		for (int i = 0; i < getLength(); i++) {
			if (this.worm.get(i).getX() == piece.getX() && this.worm.get(i).getY() == piece.getY()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean runsIntoItself() {
		for (int i = 0; i < getLength() - 1; i++) {
			if (this.worm.get(i).getX() == wormHead().getX() && this.worm.get(i).getY() == wormHead().getY()) {
				return true;
			}
		}
		return false;
	}
	
	public Piece wormHead() {
        return worm.get(getLength() - 1);
    }
}
