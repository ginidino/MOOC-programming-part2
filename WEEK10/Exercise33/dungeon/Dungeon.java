package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Exercise 33: Dungeon
public class Dungeon {
	private int length;
	private int height;
	private int vampires;
	private int moves;
	private boolean vampireMove;
	private Scanner reader;
	private List<Character> stringOfMoves;
	private char[][] map;

	public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
		this.length = length;
		this.height = height;
		this.vampires = vampires;
		this.moves = moves;
		this.vampireMove = vampiresMove;
		this.reader = new Scanner(System.in);
		this.stringOfMoves = new ArrayList<Character>();
		this.map = new char[this.length][this.height];
	}

	public void run() {
		for (int i = 0; i < this.length; i++) {
			for (int j = 0; j < this.height; j++) {
				this.map[i][j] = '.';
			}
		}
		
		player();
		System.out.println(movesLeft());
		System.out.println();
		initialPositions();
        printDungeon();
		
		while(true) {
			if (this.vampires == 0) {
				System.out.println("\nYou win!");
                break;
			} else if (this.moves == 0) {
				System.out.println("\nYou lose...");
                break;
			}
			
			String readMove = this.reader.nextLine();
			for (int i = 0; i < readMove.length(); i++) {
				this.stringOfMoves.add(readMove.charAt(i));
			}
			
			movement(this.stringOfMoves);
			getVampires();
            vampireMovement(this.stringOfMoves);
            System.out.println();
            this.moves--;
			System.out.println(movesLeft());
            System.out.println();
            initialPositions();
            printDungeon();
		}
	}

	public void player() {
		Random random = new Random();
		
		this.map[0][0] = '@';
		
		for (int i = 0; i < this.vampires; i++) {
			this.map[random.nextInt(this.length)][random.nextInt(this.height)] = 'V';
		}
		
		if (this.map[0][0] == 'V') {
			this.map[0][0] = '@';
			this.map[random.nextInt(this.length)][random.nextInt(this.height)] = 'V';
		}
	}
	
	public int movesLeft() {
		return this.moves;
	}
	
	public void initialPositions() {
		for (int i = 0; i < this.length; i++) {
			for (int j = 0; j < this.height; j++) {
				if (this.map[i][j] == '@') {
					System.out.println("@: " + i + " " + j);
                    break;
				}
			}
		}
		
		for (int x = 0; x < this.length; x++) {
			for (int y = 0; y < this.height; y++) {
				if (this.map[x][y] == 'V') {
					System.out.println("V: " + x + " " + y);
				}
			}
		}
		System.out.println();
	}

	public void printDungeon() {
		for(int i = 0; i < this.length; i++) {
            for(int j = 0; j < this.height; j++) {
                System.out.print(this.map[i][j]);
            }
            System.out.println();
        }
	}
	
	public void movement(List<Character> moves) {
		for (char x : moves) {
            if (x == 'w') {
                moveUp();
            } else if (x == 'a') {
                moveLeft();
            } else if (x == 's') {
                moveDown();
            } else if (x == 'd') {
                moveRight();
            }
        }
        
        moves.clear();
	}

	public int getVampires() {
		int count = 0;
		for(int i = 0; i < this.length; i++) {
            for(int j = 0; j < this.height; j++) {
                if(this.map[i][j] == 'V'){
                    count++;
                }
            }
        }
		
		if (count < this.vampires) {
			this.vampires = count;
		}
		return this.vampires;
	}
	
	public void vampireMovement(List<Character> moves) {
		Random random = new Random();
		
		this.vampireMove = true;
		while(this.vampireMove == true) {
			for (int i = 0; i < this.length; i++) {
				for (int j = 0; j < this.height; j++) {
					if (this.map[i][j] == 'V') {
						this.map[random.nextInt(this.length)][random.nextInt(this.height)] = 'V';
						this.map[i][j] = '.';
					}
				}
			}
			this.vampireMove = false;
		}
	}
	
	public void moveUp() {
		for (int i = 0; i < this.length; i++) {
			for (int j = 0; j < this.height; j++) {
				
			}
		}
	}
	
	public void moveDown() {
		for (int i = 0; i < this.length; i++) {
			for (int j = 0; j < this.height; j++) {
				if (this.map[i][j] == '@') {
					this.map[i + 1][j] = '@';
					this.map[i][j] = '.';
					break;
				}
			}
		}
	}
	
	public void moveLeft() {
		for (int i = 0; i < this.length; i++) {
			for (int j = 0; j < this.height; j++) {
				if (this.map[i][j] == '@') {
					this.map[i][j - 1] = '@';
					this.map[i][j] = '.';
					break;
				}
			}
		}
	}
	
	public void moveRight() {
		for (int i = 0; i < this.length; i++) {
			for (int j = 0; j < this.height; j++) {
				if (this.map[i][j] == '@') {
					this.map[i][j + 1] = '@';
					this.map[i][j] = '.';
					break;
				}
			}
		}
	}
}