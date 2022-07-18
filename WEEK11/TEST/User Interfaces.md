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

### Buttons
add buttons to your user interface using the class `JButton`. Adding a JButton object to your user interface is similar to adding a JLabel object.
```java
private void createComponents(Container container) {
    JButton button = new JButton("Click!");
    container.add(button);
}
```
Next, try to add both text and a button to our user interface.
```
private void createComponents(Container container) {
    JButton button = new JButton("Click!");
    container.add(button);
    JLabel text = new JLabel("Text.");
    container.add(text);
}
```
We can only see the last component we added and the program is not working as expected.

## Setting up UI Components
Every UI component has its own place in the user interface. Component positions are defined by the UI *Layout Manager*. Previously, when you tried to add various components to a `Container` object, only one component was displayed. All `Container` objects have a default UI layout manager, BorderLayout.

BorderLayout places UI components in five areas: the center of the user interface and four compass points. When using the Container's `add` method, you can provide another parameter to clarify where to place the component. The BorderLayout class accepts five class variables: `BorderLayout.NORTH`, `BorderLayout.EAST`, `BorderLayout.SOUTH`, `BorderLayout.WEST`, and `BorderLayout.CENTER`.

The UI layout manager you want to use is assigned to the `Container` object in the parameter of the `setLauout` method. In addition to UI components, the `add` method can also assign where the component should be placed.

```java
private void createComponents(Container container) {
    // the following line is not essential in this case, because BorderLayout is default in JFrame
    container.setLayout(new BorderLayout());

    container.add(new JButton("North"), BorderLayout.NORTH);
    container.add(new JButton("East"), BorderLayout.EAST);
    container.add(new JButton("South"), BorderLayout.SOUTH);
    container.add(new JButton("West"), BorderLayout.WEST);
    container.add(new JButton("Center"), BorderLayout.CENTER);

    container.add(new JButton("Default (Center)"));
}
```

### BoxLayout

With BoxLayout, UI components are added to the user interface either horizontally or vertically. The BoxLayout constructor is given as parameters a Container object (where you added the UI component) and the layout direction of the UI component. The layout direction can be either `BoxLayout.X_AXIS` (components set horizontally) or `BoxLayout.Y_AXIS` (components set vertically). Unlike BorderLayout, BoxLayout doesn't have a limited number of places. This means you can add as many components as you want to the container.

Arranging the user interface with `BoxLayout` works just like using `BorderLayout`. 
1. create a layout manager and assign it to a `Container` object using the `setLayout` method. 
2. You can then use the add method to `add` components to the Container object.   

No additional parameters specifying the location are required.
```
private void createComponents(Container container) {
    BoxLayout layout = new BoxLayout(container, BoxLayout.X_AXIS);
    container.setLayout(layout);

    container.add(new JLabel("First!"));
    container.add(new JLabel("Second!"));
    container.add(new JLabel("Third!"));
}
```
No major changes are required to set the component vertically. Modify the orientation parameter of the `BoxLayout` constructor, `BoxLayout.Y_AXIS`.
```java
private void createComponents(Container container) {
    BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
    container.setLayout(layout);

    container.add(new JLabel("First!"));
    container.add(new JLabel("Second!"));
    container.add(new JLabel("Third!"));
}
```
You can use other layout managers to create user interfaces with the components set up appropriately. Below is an example of a user interface with components placed vertically. First there is the text and then there is the selection. You can use ButtonGroup and JRadioButton to create multiple exclusion ranges for a set of buttons. That is, "turning on one of those buttons turns off all other buttons in the group".
```java
private void createComponents(Container container) {
    BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
    container.setLayout(layout);

    container.add(new JLabel("Choose meat or fish:"));

    JRadioButton meat = new JRadioButton("Meat");
    JRadioButton fish = new JRadioButton("Fish");

    ButtonGroup buttonGroup = new ButtonGroup();
    buttonGroup.add(meat);
    buttonGroup.add(fish);

    container.add(meat);
    container.add(fish);
}
```
