package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import wormgame.domain.Apple;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;
import wormgame.Direction;
import java.util.Random;

// Exercise 49: Worm Game
// Exercise 49.3: Worm Game, Part 1 & Exercise 49.4: Worm Game, Part 2
public class WormGame extends Timer implements ActionListener {
	private int width;
	private int height;
	private Worm worm;
	private Apple apple;
	private boolean continues;
	private Updatable updatable;

	public WormGame(int width, int height) {
		super(1000, null);
		this.width = width;
		this.height = height;
		this.continues = true;
		this.worm = new Worm(width / 2, height / 2, Direction.DOWN);
		this.apple = new Apple(new Random().nextInt(this.width), new Random().nextInt(this.height));
		
		while (this.worm.runsInto(apple)) {
			this.apple = new Apple(new Random().nextInt(this.width), new Random().nextInt(this.height));
		}
	}
	
	public Worm getWorm() {
		return this.worm;
	}
	
	public void setWorm(Worm worm) {
		this.worm = worm;
	}
	
	public Apple getApple() {
		return this.apple;
	}
	
	public void setApple(Apple apple) {
		this.apple = apple;
	}
	
	public boolean continues() {
		return this.continues;
	}
	
	public void setUpdatable(Updatable updatable) {
		this.updatable = updatable;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!this.continues) {
			return;
		}
		
		this.worm.move();
		
		if (this.worm.runsInto(apple)) {
			this.worm.grow();
			while (this.worm.runsInto(apple)) {
				this.apple = new Apple(new Random().nextInt(this.width), new Random().nextInt(this.height));
			}
		} else if (this.worm.runsIntoItself()) {
			this.continues = false;
		} else if (this.worm.wormHead().getX() == this.width || this.worm.wormHead().getX() < 0) {
			this.continues = false;
		} else if (this.worm.wormHead().getY() == this.height || this.worm.wormHead().getY() < 0) {
			this.continues = false;
		}
		
		this.updatable.update();
		setDelay(1000 / this.worm.getLength());
	}
}