# Drawing
`Container` functionality is *not the only reason* to use the JPanel class. This class is also used as a drawing board, inherit from the `JPanel` class and override the `protected void paintComponent(Graphics graphics)` method. The parameter of the method `paintComponent` receives from the user interface an object which implements the abstract class `Graphics`.

Create a `DrawingBoard JPanel` class that inherits from `JPanel` and overrides the `paintComponent` method.
```java
public class DrawingBoard extends JPanel {

    public DrawingBoard() {
        super.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
    }
}
```
The above drawing board does not contain specific drawing functions. You can define the colour of the drawing board as white by calling the `setBackground` method of the superclass in the constructor. The `setBackGround` method takes an instance of the `Color` class as a parameter. The `Color` class contains the most common colours as class variables. For example, I use the `Color.WHITE` class variable to get white.

The overridden `paintComponent` method calls the superclass's `paintComponent` method and does nothing else.   
Add a drawing board to the `createComponents` method of the `UserInterface` class.
```java
private void createComponents(Container container) {
    container.add(new DrawingBoard());
}
```
Start user interface - background colour is white. The size of the user interface is set to 300x300 through the method `setPreferredSize`, and its title is `"Drawing Board"`.

Drawing on the board is possible using the methods provides by the `Graphics` object.    
Modify the method `paintComponent` of `DrawingBoard` and let's draw two rectangles using the method fillRect of the `Graphics` object.
```java
@Override
protected void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);

    graphics.fillRect(50, 80, 100, 50);
    graphics.fillRect(200, 20, 50, 200);
}
```
The method fillRect receives as parameter the x and y coordinates of a rectangle, + the rectangle width and height.    
In fact, above, first draw a rectangle starting with pixels with coordinates (50, 80). This pixel is 100 pixels long and 50 pixels high. Then draw a rectangle 50 px long and 100 px high, starting at (200, 20).

Java's `Graphics` object (and most other programming language libraries) expect the y-axis values to increase downwards. The coordinate system origin, i.e. the point (0,0), is in the upper left corner. The `Graphics` object always knows which UI component we are drawing on, and based on that we can define the position of the point to draw.

The location of the UI origin can be made clear with the help of the following program: First, draw a green rectangle 10 px long and 200 px high, starting at the point (0,0). Then draw a black rectangle 200 pixels long and 10 pixels high, starting at the point (0,0). The drawing color is defined by the `setColor` method of the `Graphics` object.
```java
@Override
protected void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);

    graphics.setColor(Color.GREEN);
    graphics.fillRect(0, 0, 10, 200);
    graphics.setColor(Color.BLACK);
    graphics.fillRect(0, 0, 200, 10);
}
```
> This coordinate system reversibility depends on how the user interface size is modified. When modifying the size of the user interface, "drag the lower right corner" to reduce or increase the size. In this way the picture on the screen moves while changing the UI size. Since the grid starts from the top left corner, the drawing position is always the same, but the visible part changes.

Extending the previous example to draw an avatar object independent of the user interface.   
Create an `Avatar` class. A circle with the coordinates of the point where it appears and is 10 pixels in diameter. The position of the avatar can be changed by calling the `move` method.
```java
import java.awt.Graphics;

public class Avatar {

    private int x;
    private int y;

    public Avatar(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int movingX, int movingY) {
        this.x += movingX;
        this.y += movingY;
    }

    public void draw(Graphics graphics) {
        graphics.fillOval(x, y, 10, 10);
    }
}
```
Modify the drawing board by providing an instance of the `Avatar` as a constructor parameter.   
`DrawingBoard`'s `paintComponent` method delegates responsibility to an instance of the `Avatar` class, rather than drawing the character itself.
```java
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingBoard extends JPanel {

    private Avatar avatar;

    public DrawingBoard(Avatar avatar) {
        super.setBackground(Color.WHITE);
        this.avatar = avatar;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        avatar.draw(graphics);
    }
}
```
Try specifying an `Avatar` as a parameter for the user interface. `Avatar` is a user interface independent object and we only want to draw from the user interface. It is essential to change the UI constructor to accept an `Avatar` object. Furthermore, in the `createComponents` method we provide an instance of the `Avatar` class as a parameter to the `DrawingBoard` object.
```java
public class UserInterface implements Runnable {

    private JFrame frame;
    private Avatar avatar;

    public UserInterface(Avatar avatar) {
        this.avatar = avatar;
    }

// ...

    private void createComponents(Container container) {
        DrawingBoard drawingBoard = new DrawingBoard(avatar);
        container.add(drawingBoard);
    }
// ...
```
Now, user interface can be started giving it an `Avatar` object as constructor parameter.
```java
UserInterface ui = new UserInterface(new Avatar(30, 30));
SwingUtilities.invokeLater(ui);
```
Added ability to move avatar.      
Move using keyboard: When the user presses the left arrow, the avatar should move to the left. Pressing the right arrow should move the avatar to the right.
* Requires an action event listener to listen to the keyboard. Interface `KeyListener` defines the functionality required to listen to the keyboard.

The `KeyListener` interface calls to implement the `keyPressed`, `keyReleased`, and `keyTyped` methods. We are only interested in when the keyboard is pressed, so we can leave the `keyReleased` and `keyTyped` methods empty.   
Create a `KeyboardListener` class that implements the `KeyListener` interface. The class receives an `Avatar` object as a parameter, and the action event manager needs to move it.
```java
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    private Avatar avatar;

    public KeyboardListener(Avatar avatar) {
        this.avatar = avatar;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            avatar.move(-5, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            avatar.move(5, 0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}
```
`keyPressed` method: Receives a `KeyEvent` instance as a parameter from the user interface. The `KeyEvent` object knows the number associated with the key pressed thanks to the `getKeycode()` method. Different keys have different class variables in the `KeyEvent` class. 
- ex) the left arrow is `KeyEvent.VK_LEFT`.

We want to listen to the keystrokes directed to our user interface (we don't want to write to the text field, for instance), and therefore assign our keyboard listener to the `JFrame` instance.    
Modify our user interface and add the keyboard listener to the `JFrame` object.
```java
private void createComponents(Container container) {
    DrawingBoard drawingBoard = new DrawingBoard(avatar);
    container.add(drawingBoard);

    frame.addKeyListener(new KeyboardListener(avatar));
}
```
The application now listens for keystrokes and attaches them to instances of the `KeyboardListener` class.

But when trying the user interface it doesn't work. The avatar does not move on the screen.   
Able to add text output to the beginning of the `keyPressed` method to see what keystrokes the `KeyboardListener` has received.
```java
@Override
public void keyPressed(KeyEvent e) {
    System.out.println("Keystroke " + e.getKeyCode() +  " pressed.");

    // ...
```
When start the program and press some keys, get the following output:
```
Keystroke 39 pressed.
Keystroke 37 pressed.
Keystroke 40 pressed.
Keystroke 38 pressed.
```
Actually, the keyboard listener works, but the drawing board doesn't update.

### Drawing Board Repainting
User interface components usually have the functionality to repaint the component outer face, when needed. 
- ex) when a button is pressed, an instance of the `JButton` class can paint as if the button was pressed and later paint normally again.   
 
The drawing board we implemented does not have a pre-made update function. Instead, you should ask the drawing board to repaint when needed.

Each subclass of `Component` has a `public void repaint()` method, which, after being called, repaints the component. We want that `DrawingBoard` object would get repainted while the avatar moves. The logic is that the avatar moves in the `KeyboardListener` class and repaints there too.

To repaint, the keyboard listener needs a drawing board reference.
- Modify the `KeyboardListener` class to receive as parameters an `Avatar` object and a `Component` object to repaint. Call the `Component` object's repaint method after each `keyPressed` action event.
```java
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    private Component component;
    private Avatar avatar;

    public KeyboardListener(Avatar avatar, Component component) {
        this.avatar = avatar;
        this.component = component;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            avatar.move(-5, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            avatar.move(5, 0);
        }

        component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}
```
- Modify the `UserInterface`'s `createComponents` method and provide an instance of `DrawingBoard` as a parameter to the keyboard listener.
```java
private void createComponents(Container container) {
    DrawingBoard drawingBoard = new DrawingBoard(hahmo);
    container.add(drawingBoard);

    frame.addKeyListener(new KeyboardListener(avatar, drawingBoard));
}
```
The avatar's movements are now visible in the user interface as well. Whenever the user presses the keyboard, the user interface keyboard listener handles the call. At the end of each call, the `repaint` method of our drawing board is called, and the drawing board gets repainted.

### Pre-made Application Frameworks 
An application framework is a program that provides a set of standards and features for implementing a specific application. One way to create an application framework is to create a class that provides ready-made functionality so that the class can inherit from it and build specific applications. Application frameworks are generally broad and are conceived for a special purpose, for example programming games or developing web applications.
