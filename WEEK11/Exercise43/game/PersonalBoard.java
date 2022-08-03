package game;

import java.util.Random;
import gameoflife.GameOfLifeBoard;

// Exercise 43: Game of Life
public class PersonalBoard extends GameOfLifeBoard {
	private Random rand;

	public PersonalBoard(int width, int height) {
		super(width, height);
	}

	@Override
    public void turnToLiving(int x, int y) {
        if (x <= super.getWidth() && y <= super.getHeight()) {
            if (x >= 0 && y >= 0) {
                super.getBoard()[x][y] = true;
            }
        }
    }

	@Override
	public void turnToDead(int x, int y) {
		if (x <= super.getWidth() && y <= super.getHeight()) {
			if (x >= 0 && y >= 0) {
				super.getBoard()[x][y] = false;
			}
		}
	}

	@Override
	public boolean isAlive(int x, int y) {
		if (x < super.getWidth() && y < super.getHeight()) {
			if (x >= 0 && y >= 0) {
				return super.getBoard()[x][y];
			}
		}
		return false;
	}

	@Override
	public void initiateRandomCells(double probabilityForEachCell) {
		if (probabilityForEachCell == 0.0) {
			for (int x = 0; x < super.getWidth(); x++) {
				for (int y = 0; y < super.getHeight(); y++) {
					turnToDead(x, y);
				}
			}
		}
		this.rand = new Random();
		
		if (probabilityForEachCell == 1.0) {
			for (int x = 0; x < super.getWidth(); x++) {
				for (int y = 0; y < super.getHeight(); y++) {
					turnToLiving(x, y);
				}
			}
		}
		
		if (probabilityForEachCell > 0.0 && probabilityForEachCell < 1.0) {
			for (int x = 0; x < super.getWidth(); x++) {
				for (int y = 0; y < super.getHeight(); y++) {
					double prob = this.rand.nextDouble();
					
					if (prob <= probabilityForEachCell) {
						turnToLiving(x, y);
					} else {
						turnToDead(x, y);
					}
				}
			}
		}
	}

	@Override
	public int getNumberOfLivingNeighbours(int cx, int cy) {
		int num = 0;
		for (int y = 0; y < super.getHeight(); y++) {
			for (int x = 0; x < super.getWidth(); x++) {
				if (x == (cx - 1) && y == cy || x == (cx + 1) && y == cy) {
					if (isAlive(x, y)) {
						num++;
					}
				} else if (y == (cy - 1) && x == cx || y == (cy + 1) && x == cx) {
					if (isAlive(x, y)) {
						num++;
					}
				} else if (x == (cx + 1) && y == (cy + 1) || y == (cy - 1) && x == (cx - 1)) {
					if (isAlive(x, y)) {
						num++;
					}
				} else if (x == (cx + 1) && y == (cy - 1) || x == (cx - 1) && y == (cy + 1)) {
					if (isAlive(x, y)) {
						num++;
					}
				}
			}
		}
		return num;
	}

	@Override
	public void manageCell(int x, int y, int livingNeighbours) {
		if (isAlive(x, y)) {
			if (livingNeighbours < 2) {
				turnToDead(x, y);
			} else if (livingNeighbours > 3) {
				 turnToDead(x, y);
			}
		} else if (!isAlive(x, y)) {
			if (livingNeighbours == 3) {
                turnToLiving(x, y);
            }
		}
	}
}