# User Interfaces
How to create a graphical user interface in Java.

User interface is a window that contains different types of buttons, text boxes, and menus. When programming user interfaces, you use Java's `Swing` component library, which provides classes for creating and handling user interfaces.

The basic element of a user interface is the `JFrame` class, which creates user interface components in its components section. The orthodox user interface implements the `Runnable` interface and starts from the main program. 

This course uses the following user interface body:
```java
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {

    private JFrame frame;

    public UserInterface() {
    }

    @Override
    public void run() {
        frame = new JFrame("Title");
        frame.setPreferredSize(new Dimension(200, 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
    }

    public JFrame getFrame() {
        return frame;
    }
}
```
Take a closer look at the user interface code above.
```java
public class UserInterface implements Runnable {
```
`UserInterface` class implements Java's `Runnable` interface to run threaded programs. Running a threaded program means executing different parts of the program concurrently.
```java
private JFrame frame;
```
The user interface contains as a variable a `JFrame` object, which is the basic element of a visible user interface. All user interface components are added to the `JFrame` object component container. Object variables cannot start outside of a method. 
> For example, initializing the object variable `JFrame` with the class definition `"private JFrame frame = new JFrame()"` avoids the user interface thread execution order and can lead to breakdowns.
```java
@Override
public void run() {
    frame = new JFrame("Title");
    frame.setPreferredSize(new Dimension(200, 100));

    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    createComponents(frame.getContentPane());

    frame.pack();
    frame.setVisible(true);
}
```
The `Runnable` interface defines a `public void run()` method which has to be implemented by all classes which implement the interface. 
First create a new `JFrame` with the title `"Title"` using the `public void run() method`. Then define a frame size that is 200 pixels wide and 100 pixels high.   
`frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);` This statement tells the `JFrame` object that the user interface should close when the user presses the cross icon.   

Then call the `createComponents` method defined at the bottom of the class.
- This method is provided with a `Container` object in the `JFrame` as a parameter, where you can add user interface components.

Finally, it calls the `frame.pack()` method, which packs the previously defined `JFrame` object and arranges the user interface components of the `Container` object contained within the `JFrame`. At the end, call the `frame.setVisible(true)` method to display the user interface to the user.
```java
private void createComponents(Container container) {which has to be implemented by all classes which implement the interface
}
```
In the `createComponents` method, you add user interface components to the `JFrame`'s container. 
> In this example, there are no UI components other than the `JFrame` window.    
`UserInterface` class also has a `getFrame` method that can be used to retrieve the `JFrame` object encapsulated in the class.
```java
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        SwingUtilities.invokeLater(ui);
    }
}
```
The Swing user interface is launched through the `invokeLater` method provided by the `SwingUtilities` class. `invokeLater` takes as a parameter an object that implements the `Runnable` interface. The method adds the `Runnable` object to the run queue and calls it as soon as possible. class `SwingUtilities` allows you to start new threads when needed.

## UI Components
The user interface consists of a background window (JFrame), a component container, and UI components set in the container. UI components are different kinds of buttons, text, and other items.

### Text
Text can be displayed with the help of the `JLabel` class. `JLabel` provides UI components to which text can be assigned and text can be modified. Text is assigned in the constructor or separately using the `setText` method.

Modify the UI container to display text   
Create a new JLabel text component inside the `createComponents` method. -> retrieve the `Container` object from the `JFrame` object and add the `JLabel` to the `Container` using the `add` method.
```java
private void createComponents(Container container) {
    JLabel text = new JLabel("Text field!");
    container.add(text);
}
```

