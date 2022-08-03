package game;

import java.util.Scanner;
import gameoflife.GameOfLifeBoard;

public class GameOfLifeTester {
	private static Scanner reader = new Scanner(System.in);
	private GameOfLifeBoard board;

	public GameOfLifeTester(GameOfLifeBoard board) {
		this.board = board;
	}

	public void play() {
		draw();
		while (continueTurn()) {
			try {
				this.board.playTurn();
			} catch (Exception e) {

			}
			draw();
		}
	}

	public void draw() {
		if (this.board == null) {
			return;
		}
		
		System.out.println();
		
		for (int y = 0; y < this.board.getHeight(); y++) {
			for (int x = 0; x < this.board.getWidth(); x++) {
				if (this.board.isAlive(x, y)) {
					System.out.print("X");
				} else {
					System.out.println(" ");
				}
			}
			
			System.out.println();
		}
	}
	
	private static boolean continueTurn() {
		printCommands();
		if ("".equals(reader.nextLine())) {
			return true;
		}
		
		System.out.println("Thanks!");
		return false;
	}

	private static void printCommands() {
		System.out.print("Press enter to continue, any other key quits: ");
	}
}