package game;

// Exercise 43: Game of Life
public class Exercise43 {
	public static void main(String[] args) {
		PersonalBoard board = new PersonalBoard(7, 5);

        board.turnToLiving(2, 0);
        board.turnToLiving(4, 0);

        board.turnToLiving(3, 3);
        board.turnToLiving(3, 3);

        board.turnToLiving(0, 2);
        board.turnToLiving(1, 3);
        board.turnToLiving(2, 3);
        board.turnToLiving(3, 3);
        board.turnToLiving(4, 3);
        board.turnToLiving(5, 3);
        board.turnToLiving(6, 2);
        
        board.initiateRandomCells(1.0);
        
        board.turnToLiving(0, 1);
        board.turnToLiving(1, 0);
        board.turnToLiving(1, 2);
        board.turnToLiving(2, 2);
        board.turnToLiving(2, 1);

        System.out.println("Neighbours alive (0,0): " + board.getNumberOfLivingNeighbours(0, 0));
        System.out.println("Neighbours alive (1,1): " + board.getNumberOfLivingNeighbours(1, 1));

        GameOfLifeTester tester = new GameOfLifeTester(board);
        tester.play();
	}
}