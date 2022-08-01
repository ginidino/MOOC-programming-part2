## Exercise 42: A Moving Figure
create a program which allows the user to move the figures drawn on a board using their keyboard. Together with the program you find the body of a user interface, which you can modify as your program proceeds.

At first, we create a couple of classes to manage the figures. Later on we will be able to draw the figures to our board. Create all the classes of the program in the package `movingfigure`.

## Exercise 42.1: Figure: an Abstract Class
Create the abstract class `Figure`. `Figure`s have the object variables x and y, which tell the figure position on the board; they also have the method `public void move(int dx, int dy`), which moves the figures according to the parameter coordinate movements. For instance, if the position is (100,100), at the beginning, after calling the method move(10,-50) the position will be (110,50). The class constructor `public Figure(int x, int y)` has to define the original position of the figure. Additionally, implement also the methods `public int getX()` and `public int getY()`.

The class also has to have the abstract method `public abstract void draw(Graphics graphics)`, which draws the figure on the drawing board. The figure drawing method is implemented in the classes which inherit Figure.

## Exercise 42.2: Circle
Create the class `Circle` which inherits Figure. `Circle` has a diameter, whose value is defined by the constructor `public Circle(int x, int y, int diameter)`. The Circle position is stored into the object variables defined in its parent class.

The circle defines the method `draw` so that it would draw a circle of the right size, in the place defined by the coordinates, and using the method `fillOval` of the Graphics object; the first two parameters of the method are taken for the position of the circle. Take example from the relative method in the Avatar example. For more information about the methods of Graphics objects.

Exercise 42.3: Drawing Board
Create the class `DrawingBoard` which inherits JPanel; you can take example from the drawing board in the previous exercise, for instance. `DrawingBoard` receives a Figure object as parameter. Override `JPanel`'s method protected void `paintComponent(Graphics g)` so that it first calls the superclass' `paintComponent` method, and then the draw method of the figure which was assigned to the drawing board.

Modify the class` UserInterface` so that it would receive a `Figure` object as constructor parameter. Assign `DrawingBoard` to the user interface together with the `createComponents(Container container)` method, and assign to the drawing board the figure which was given to the user interface as constructor parameter.

Finally, test that the following sample code draws a circle on the screen.
```java
UserInterface ui = new UserInterface(new Circle(50, 50, 250));
SwingUtilities.invokeLater(ui);
```

## Exercise 42.4: Keyboard Listener
Let's extend our drawing board, so that we could move the figures using our keyboard arrows. Create the class `KeyboardListener` which implements the interface KeyListener. The class `KeyboardListener` has two constructor parameters: an instance of the class `Component` and one of the class Figure.

The instance of Component is given to the keyboard listener so that the component would be updated each time the keyboard is pressed. The component is updated with the method call repaint, which is inherited from he class `Component`. The type of the class `DrawingBoard` is `Component`, because `Component` is the upper class of the class which inherits `JPanel`.

Implement the method `keyPressed(KeyEvent e)` of the interface `KeyListener`; when the user presses the left arrow, the figure moves one point left. Pressing right, the figure moves one point right. Pressing up it moves one point up, and pressing down the figure moves one point down. Note that the y axe grows from the upper side of the window downwards. The arrow key codes are `KeyEvent.VK_LEFT`, `KeyEvent.VK_RIGHT`, `KeyEvent.VK_UP`, and `KeyEvent.VK_DOWN`. Leave empty the other methods required by the interface `KeyListener`.

Always call class `Component`'s method `repaint` in the end of keylistener event.

Add keylistener in the `UserInterface`'s method `addListeners`. `KeyListener` must be connected to `JFrame`-object.

Exercise 42.5: Square and Box
Let `Square` and `Box` inherit the class `Figure`. Square has the constructor `public Square(int x, int y, int sideLength)`; the constructor of box is `public Box(int x, int y, int width, int height)`. Use the method `fillRect` of a graphic object to draw the figures.

Make sure that squares and boxes are drawn and move right on the `DrawingBoard`.
```java
UserInterface ui = new UserInterface(new Square(50, 50, 250));
SwingUtilities.invokeLater(ui);
```
```java
UserInterface ui = new UserInterface(new Box(50, 50, 100, 300));
SwingUtilities.invokeLater(ui);
```
## Exercise 42.6: Compound Figure
Let `CompoundFigure` inherit `Figure`. Compound figure contains other figures which are stored in an `ArrayList`. `CompoundFigure` has the method `public void add(Figure f)`, which adds a new `Figure` object to the compound figure. Compound figures do not have their own position, and it is not important what values are assigned to x and y coordinates. Compound figures draw themselves by asking their parts to draw themselves; the same thing happens when a compound figure moves. This means that the inherited method `move` has to be overwritten!

You can test whether your compound figure moves and is drawn well using the following code:
```java
CompoundFigure truck = new CompoundFigure();

truck.add(new Box(220, 110, 75, 100));
truck.add(new Box(80, 120, 200, 100));
truck.add(new Circle(100, 200, 50));
truck.add(new Circle(220, 200, 50));

UserInterface ui = new UserInterface(truck);
SwingUtilities.invokeLater(ui);
```

> Note how the object responsibilities are shared here. Each Figure is in charge of drawing and moving itself. Simple figures all move in the same way. Each simple figure has to manage their own drawing themselves. Compound figures move by asking their parts to move, and the same thing happens when it comes to be drawn. The drawing board knows a Figure object which, in fact, can be whatever simple figure or a compound figure: they are all drawn and moved in the same way. In fact, the drawing board works correctly regardless of the real type of the figure; the drawing board does not have to know the details of the figure. When the drawing board calls the method draw or move of the figure, the method of the real type of the figure is called, thanks to polymorphism.

> It's worth to notice that CompoundFigure can contain whatever Figure object, even another CompoundFigure! The class structure allows for highly complex figure formations, whereas figures move and draw themselves always in the same way.

> The class structure can also be expanded easily; for instance, a compound figure would work without needing changes even if we created new types which inherit Figure (say Triangle, Point, Line, exc.), and the same thing would apply to the drawing board and user interface.
