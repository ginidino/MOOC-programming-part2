# Exercise 49: Worm Game
In this exercise, we create the structure and functionality for the following worm game.

## Exercise 49.1: Piece and Apple
Create the class `Piece` in `wormgame.domain`. The class `Piece` has the constructor `public Piece(int x, int y)`, which receives the position of the piece as parameter. Moreover, the class `Piece` has the following methods.

- `public int getX()` returns the x coordinate of the piece, which was assigned in the constructor.
- `public int getY()` returns the y coordinate of the piece, which was assigned in the constructor.
- `public boolean runsInto(Piece piece)` returns true if the object has the same coordinates as the Piece instance received as paramater.
- `public String toString()` returns the piece position following the pattern (x,y). For instance. (5,2) if the value of x is 5 and the value of y is 2.

Also implement the class `Apple` in `wormgame.domain`, and let `Apple` inherit `Piece`.

## Exercise 49.2: Worm
Implement the class `Worm` in the package `wormgame.domain`. The class `Wor`m has the constructor `public Worm(int originalX, int originalY, Direction originalDirection)`, which creates a new worm whose direction is the parameter `originalDirection`. `Worm` is composed of a list of instances of the class `Piece`. 
> Attention: the pre-made enum `Direction` can be found in the package `wormgame`.

When it's created, Worm's length is one, but its "mature" length is three. Worm has to grow by one piece while it moves. When its length is three, Worm grows only by eating.

Implement the following methods

- `public Direction getDirection()` return's Worm's direction.
- `public void setDirection(Direction dir)` sets a new direction for the worm. The worm starts to move in the new direction when the method move is called again.
- `public int getLength()` returns the Worm's length. The Worm's length has to be equal to the length of the list returned by the method `getPieces()`.
- `public List<Piece> getPieces()` returns a list of Piece objects which the worm is composed of. The pieces in the list are in order, with the worm head at the end of the list.
- `public void move()` moves the worm one piece forward.
- `public void grow()` grows the worm by one piece. The worm grows together with the following `move` method call; after the first move method call the worm does not grow any more.
- `public boolean runsInto(Piece piece)` checks whether the worm runs into the parameter piece. If so -- that is, if a piece of the worm runs into the parameter piece -- the method returns the value `true`; otherwise it returns `false`.
- `public boolean runsIntoItself()` check whether the worm runs into itself. If so -- that is, if one of the worm's pieces runs into another piece -- the method returns the value `true`. Otherwise it returns `false`.

The functionality of `public void grow()` and `public void move()` has to be implemented so that the worm grows only with the following move.

Motion should be implemented in a way that the worm is always given a new piece. The position of the new piece depends on the moving direction: if moving left, the new piece location should on the left of the head piece, i.e. the x coordinate of the head should be smaller by one. If the location of the new piece is under the old head -- if the worm's direction is down, the y coordinate of the new piece should be by one bigger than the y coordinate of the head (when we draw, we will have to get accustometd to a coordinate system where the y axe is reverse).

When the worm moves, a new piece is added to the list, and the first piece is deleted from the beginning of the list. In this way, you don't need to update the coordinates of each single piece. Implement the growth so that the first piece is deleted if the `grow` method has just been called.

> Attention! The worm has to grow constantly if its length is less than 3.
```java
        Worm worm = new Worm(5, 5, Direction.RIGHT);
        System.out.println(worm.getPieces());
        worm.move();
        System.out.println(worm.getPieces());
        worm.move();
        System.out.println(worm.getPieces());
        worm.move();
        System.out.println(worm.getPieces());

        worm.grow();
        System.out.println(worm.getPieces());
        worm.move();
        System.out.println(worm.getPieces());

        worm.setDirection(Direction.LEFT);
        System.out.println(worm.runsIntoItself());
        worm.move();
        System.out.println(worm.runsIntoItself());
```
```
[(5,5)]
[(5,5), (6,5)]
[(5,5), (6,5), (7,5)]
[(6,5), (7,5), (8,5)]
[(6,5), (7,5), (8,5)]
[(6,5), (7,5), (8,5), (9,5)]
false
true
```

## Exercise 49.3: Worm Game, Part 1
Let's modify the class `WormGame` which is contained in `wormgame.game`, and encapsulates the functionality of the game. The class `WormGame` inherits the class `Timer`, which provides the time functionality to update the game. In order to work, the class `Timer` requires a class which implements the interface `ActionListener`, and we have implemented it in `WormGame`.

Modify the functionality of `WormGame`'s constructor so that the game's `Worm` is created in the constructor. Create the worm so that the position of the worm depends on the parameters received in the constructor of the class WormGame. The worm's x coordinate has to be `width / 2`, the y coordinate `height / 2` , and the direction `Direction.DOWN`.

Also create an apple inside the constructor. The apple coordinates have to be random, but the apple x coordinate has to be contained between `[0, width]`, and the y coordinate between `[0, height]`.

Also add the following methods to the WormGame:

- `public Worm getWorm()` returns the WormGame worm.
- `public void setWorm(Worm worm)` sets on the game the method parameter worm. If the method `getWorm` is called after the worm has been set up, it has to return a reference to the same worm.
- `public Apple getApple()` returns the apple of the WormGame.
- `public void setApple(Apple apple)` sets the method parameter apple on the worm game. If the method `getApple` is called after the apple has been set up, it has to return a reference to the same apple.

## Exercise 49.4: Worm Game, Part 2
Modify the functionality of the method `actionPerformed` so that it would implement the following tasks in the given order.

- Move the worm
- If the worm runs into the apple, it eats the apple and calls the grow method. A new apple is randomly created.
- If the worm runs into itself, the variable `continue` is assigned the value `false`
- Call `update`, which is a method of the variable `updatable` which implements the interface `Updatable`.
- Call the `setDelay` method which is inherited from the `Timer` class. The game velocity should grow with respect to the worm length. The call `setDelay(1000 / worm.getLength())`; will work for it: in the call we expect that you have defined the object variable `worm`.
