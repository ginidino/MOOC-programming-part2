package wormgame.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import wormgame.Direction;
import wormgame.domain.Worm;

// Exercise 49: Worm Game
// Exercise 49.5: Keyboard listener
public class KeyboardListener implements KeyListener {
	private Worm worm;
	
	public KeyboardListener(Worm worm) {
		this.worm = worm;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.worm.setDirection(Direction.LEFT);
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.worm.setDirection(Direction.RIGHT);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			this.worm.setDirection(Direction.UP);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			this.worm.setDirection(Direction.DOWN);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}