package Week10;

import dungeon.Dungeon;

// Exercise 33: Dungeon
public class Exercise33 {
	public static void main(String[] args) {
		Dungeon dungeon = new Dungeon(10, 10, 5, 14, true);
		dungeon.run();
	}
}