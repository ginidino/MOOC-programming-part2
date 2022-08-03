# Exercise 43: Game of Life
In this exercise, implement the application logic of a Game of Life, inheriting a pre-made application body.

> ATTENTION: your task won't be extremely difficult, but the exercise descriptions may look a bit confusing, at first. Read the instruction carefully, or ask for help if you can't get started. The exercise is definitely worth of your energies, because the result is beautiful!

Game of Life rules:

- Every living cell dies if they have less than two living neighbours.
- Every living cell keeps on living during the following iteration (i.e. turn) if they have two or three living neighbours.
- Every living cell dies if they have more than three living neighbours.
- Every dead cell is turned back to life if they have exactly three living neighbours.

The abstract class GameOfLifeBoard provides the following functionality
- `public GameOfLifeBoard(int length, int height)` creates a game board of the defined dimensions
- `public boolean[][] getBoard()` provides access to the game board, which is a bidimensional table containing boolean values – as you may guess from the method return value! We come back to bidimensional boards later on when needed.
- `public int getWidth()` returns the board width
- `public int getHeight()` returns the board height
- `public void playTurn()` simulates a turn of the game

The class GameOfLifeBoard has also got the following abstract method, which you will have to implement.
- `public abstract void turnToLiving(int x, int y)` animates the cell whose coordinates are (x, y), that is to say it assigns the value true to it. If the coordinates are outside the board, nothing happens.
- `public abstract void turnToDead(int x, int y)` kills the cell whose coordinates are (x, y), that is to say it assigns the value false to it. If the coordinates are outside the board, nothing happens.
- `public abstract boolean isAlive(int x, int y)` tells whether the cell at (x, y) is alive. If the coordinates are outside the board, the method returns false.
- `public abstract void initiateRandomCells(double probabilityForEachCell)` initiates all the cells of the board: every cell is alive with a probability of probabilityForEachCell. The probability is a double value between [0, 1]. If a method is called with value 1, all the cells have to be alive. Accordingly, if the probability is 0, all the cells have to be dead.
- `public abstract int getNumberOfLivingNeighbours(int x, int y)` tells the number of living neighbours for the cell at (x, y).
- `public abstract void manageCell(int x, int y, int livingNeighbours)` managese the cell (x, y) according to the rules of the Game of Life.

## Exercise 43.1: GameOfLife implementation, Part 1
Create the class `PersonalBoard` into the package `game`; `PersonalBoard` inherits the class `GameOfLifeBoard` which is in the package `gameoflife`. 
> Note that the package `gameoflife` is not visible in your project, but it comes together with the class library. In the class `PersonalBoard`, implement the constructor `public PersonalBoard(int width, int height)`, which calls the superclass constructor with the given parameters:
```java
import gameoflife.GameOfLifeBoard;

public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    // ..
```
You can first replace all the abstract methods with non-abstract ones, which do not do anything particular anyway, so far. However, because the methods are not abstract, this class can create instances, differently than the abstract class GameOfLifeBoard.

Implement the following methods

- `public abstract void turnToLiving(int x, int y)` animates the cell whose coordinates are (x, y), that is to say it assigns the value true to it. If the coordinates are outside the board, nothing happens.
- `public abstract void turnToDead(int x, int y)` kills the cell whose coordinates are (x, y), that is to say it assigns the value false to it. If the coordinates are outside the board, nothing happens.
- `public abstract boolean isAlive(int x, int y)` tells whether the cell at (x, y) is alive. If the coordinates are outside the board, the method returns false.

> Hint: You have access to the bidimensional table of the superclass through the superclass method `getBoard()`. Bidimensional tables are used as normal tables, but they are assigned two indexes. The first index tells the row and the second tells the column. For instance, the following program chunk creates a 10 x 10 table, and prints the value at (3,1).
```java
boolean[][] values = new boolean[10][10];
System.out.println(values[3][1]);
```
Accordingly, we can print the value at (x,y) of our `PersonalBoard`'s superclass, in the following way:
```java
boolean[][] board = getBoard();
System.out.println(board[x][y]);
```
And an index (x,y) can be assigned a value in the following way:
```java
boolean[][] board = getBoard();
board[x][y] = true;
```
Or straight, using a helping variable:
```java
getBoard()[x][y] = true;
```
Test your implementation with the following program.
```java
package game;

public class Main {
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

        GameOfLifeTester tester = new GameOfLifeTester(board);
        tester.play();
    }
}
```
The output should look like the following:
```
Press enter to continue, otherwise quit: <enter>

  X X

X     X
 XXXXX

Press enter to continue, otherwise quit: stop
Thanks!
```

## Exercise 43.2: GameOfLife implementation, Part 2
Implement the method `public abstract void initiateRandomCells(double probabilityForEachCell)` initiates all the cells of the board: every cell is alive with a probability of probabilityForEachCell. The probability is a double value between [0, 1].

Test the method. Given the value 0.0, there should be no cell alive; given the value 1.0, all the cells should be alive (i.e. visible in the form of X characters). With the value 0.5, around fifty precent of the cells should be alive.
```java
PersonalBoard board = new PersonalBoard(3, 3);
board.initiateRandomCells(1.0);

GameOfLifeTester tester = new GameOfLifeTester(board);
tester.play();
```
```
Press enter to continue, otherwise quit: <enter>

XXX
XXX
XXX
Press enter to continue, otherwise quit: stop
Thanks!
```
## Exercise 43.3: GameOfLife Implementation, part 3
Implement the method `getNumberOfLivingNeighbours(int x, int y)`, which calculates the number of neighbour cells which are alive. Central cells have eight neighbours, the ones on the side have five, and the ones in the corner have only three.

Test the method with the following sentences (of course, you can create your own test instances!):
```java
PersonalBoard board = new PersonalBoard(7, 5);

board.turnToLiving(0, 1);
board.turnToLiving(1, 0);
board.turnToLiving(1, 2);
board.turnToLiving(2, 2);
board.turnToLiving(2, 1);

System.out.println("Neighbours alive (0,0): " + board.getNumberOfLivingNeighbours(0, 0));
System.out.println("Neighbours alive (1,1): " + board.getNumberOfLivingNeighbours(1, 1));
```
The print output should look like the following:
```
Neighbours alive (0,0): 2
Neighbours alive (1,1): 5
```
## Exercise 43.4: GameOfLife Implementation, Part 4
Only one method is missing: `manageCell(int x, int y, int livingNeighbours)`. Game of Life rules were the following:

- Every living cell dies if they have less than two living neighbours.
- Every living cell keeps on living during the following iteration (i.e. turn) if they have two or three living neighbours.
- Every living cell dies if they have more than three living neighbours.
- Every dead cell is turned back to life if they have exactly three living neighbours.

Implement the method `manageCell(int x, int y, int livingNeighbours)` according to the following rules. It's good to program and test one rule at one time!
