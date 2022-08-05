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

## Managing Action Events
Action event listeners *listen* the UI components they are assigned to. Always when performing an action on our UI components -- pressing a button, for instance -- the UI component calls a particular method of all the action event listeners assigned to it. Action event listeners are classes which implement a particular interface, and whose instances can be assigned to UI components. When an action event happens, the UI component goes through all its action event listeners, and calls the method defined by the interface.

The most used action event listener interface with Swing user interfaces is __ActionListener__.    
    * The interface `ActionListener` defines the method `void actionPerformed(ActionEvent e)`, which receives an __ActionEvent__ object as parameter.

implement action event listener, which has to print a message only when we press the relative button. The class `MessageListener` implements `ActionListener` and prints the message `"Message received!"` when the method `actionPerformed` is called.

```java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Message received!");
		
	}
}
```
Next, create the a `JButton` for `UserInterface`, and add a instance of `MessageListener` to it. The class `JButton` can be added an action event listener by using the method defined in its parent class `AbstractButton: public void addActionListener(ActionListener actionListener)`.
```java
private void createComponents(Container container) {
    JButton button = new JButton("Send!");
    button.addActionListener(new MessageListener());

    container.add(button);
}
```
When press the button in `UserInterface` we can see the following message.
```
Message received!
```

### Handling Objects in the Action Event Listeners
To modify the state of an object -> the action event listener constructor has to be assigned a reference to the obejct concerned, in order to have access to the object in the action event listener. 

There are two `JTextArea`s -- where the user can input text, and a `JButton`. The user interface makes use of `GridLayout`, which makes the user interface look like a coordinate system. In the GridLayout constructor, we defined one line and three columns.
```java
private void createComponents(Container container) {
    GridLayout layout = new GridLayout(1, 3);
    container.setLayout(layout);

    JTextArea textAreaLeft = new JTextArea("The Copier");
    JTextArea textAreaRight = new JTextArea();
    JButton copyButton = new JButton("Copy!");

    container.add(textAreaLeft);
    container.add(copyButton);
    container.add(textAreaRight);
}
```
implement user interface so that the text in the left area would be copied into the right area when we press the `JButton`. This is possible by implementing an action event listener. 

Create the class `AreaCopier` which implements `ActionListener` and copies the text from one to the other `JTextArea`.
```java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class AreaCopier implements ActionListener {

    private JTextArea origin;
    private JTextArea destination;

    public AreaCopier(JTextArea origin, JTextArea destination) {
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.destination.setText(this.origin.getText());
    }
}
```
Adding the new action event listener to the `JButton` object is possible using the method `addActionListener`.
```java
private void createComponents(Container container) {
    GridLayout layout = new GridLayout(1, 3);
    container.setLayout(layout);

    JTextArea textAreaLeft = new JTextArea("The Copier");
    JTextArea textAreaRight = new JTextArea();
    JButton copyButton = new JButton("Copy!");

    AreaCopier copier = new AreaCopier(textAreaLeft, textAreaRight);
    copyButton.addActionListener(copier);

    container.add(textAreaLeft);
    container.add(copyButton);
    container.add(textAreaRight);
}
```
When press the button, the text in the left area is copied into the right one

## Separating Application and UI Logic
It's generally not a good idea to mix application logic (such as printing or calculation functions) and user interfaces in the same class. Programs are much harder to test and modify, and code is much harder to read. As the Single Responsibility Principle suggests, each class should have only one clear responsibility. Separating your application logic from your UI logic allows you to plan your interfaces properly and seamlessly. 

`PersonRecord` class and want to implement a user interface that records people
```java
public interface PersonRecord {
    void record(Person person);
    Person get(String id);

    void delete(Person person);
    void delete(String id);
    void deleteAll();

    Collection<Person> getAll();
}
```

### UI Implementation
It is a good idea to add components when implementing a user interface. To record a person, need fields for name and ID number and a button to add the person. Use Java's `JTextField` to input text and I use `JButton` class to implement the button. It also creates a JLabel text description that tells the user what to do.

Use `GridLayout` for UI layout   
- The user interface has 3 rows and 2 columns.add action event listeners later. The UI method `createComponents` looks like this:
```java
private void createComponents(Container container) {
    GridLayout layout = new GridLayout(3, 2);
    container.setLayout(layout);

    JLabel textName = new JLabel("Name: ");
    JTextField nameField = new JTextField();
    JLabel textID = new JLabel("ID: ");
    JTextField idField = new JTextField();

    JButton addButton = new JButton("Add!");
    // event listener

    container.add(textName);
    container.add(nameField);
    container.add(textID);
    container.add(idField);
    container.add(new JLabel(""));
    container.add(addButton);
}
```
Action event listeners need to know about the recording function (`PersonRecord` interface) and the fields it uses.

Create a `PersonRecordListener` class that implements `ActionListener`. 
- As constructor parameters, the class is assigned an object that implements the `PersonRecord` interface and two `JTextField` objects representing the name and ID fields. 
- Create a new `Person` object in the `actionPerformed` method and record it using the record method of the `PersonRecord` object.
```java
public class PersonRecordListener implements ActionListener {

    private PersonRecord personRecord;
    private JTextField nameField;
    private JTextField idField;

    public PersonRecordListener(PersonRecord personRecord, JTextField nameField, JTextField idField) {
        this.personRecord = personRecord;
        this.nameField = nameField;
        this.idField = idField;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Person person = new Person(nameField.getText(), idField.getText());
        this.personRecord.record(person);
    }
}
```
In order to retrieve a `PersonRecord` reference to `PersonRecordListener`, the user interface must have access to it. Add the `private PersonRecord personRecord` object variable set in the constructor to the user interface. Also modify the constructor of the `UserInterface` class assigned a class that implements the `PersonRecord` interface.

```java
public class UserInteface implements Runnable {

    private JFrame frame;
    private PersonRecord personRecord;

    public UserInteface(PersonRecord personRecord) {
        this.personRecord = personRecord;
    }
    // ...
```
Now create an action event listener, `PersonRecordListener`, provided both a `PersonRecord` reference and fields are provided.
```java
private void createComponents(Container container) {
    GridLayout layout = new GridLayout(3, 2);
    container.setLayout(layout);

    JLabel nameText = new JLabel("Name: ");
    JTextField nameField = new JTextField();
    JLabel idText = new JLabel("ID: ");
    JTextField idField = new JTextField();

    JButton addButton = new JButton("Add!");
    PersonRecordListener listener = new PersonRecordListener(personRecord, nameField, idField);
    addButton.addActionListener(listener);

    container.add(nameText);
    container.add(nameField);
    container.add(idText);
    container.add(idField);
    container.add(new JLabel(""));
    container.add(addButton);
}
```

## Nested Container Objects
Sometimes we run into a situation where the `Container` object provided by `JFrame` doesn't fit our UI layout. We may want your user interface to look different, or you may want to group UI components based on their purpose. 
- For example, it is not easy to build a user interface using only the `Container` object provided by the `JFrame` class.

Able to place `Container` objects inside each other. The `JPanel` class allows nested container objects. You can add UI components to a JPanel instance the same way you add components to a `Container` instance of the `JFrame` class. You can also add an instance of `JPanel` to the `Container` object. This makes it possible to use many `Container` objects to develop a one user interface.

Using `JPanel` makes it easier to create user interfaces. Create a user interface with three buttons -- Execute, Test, and Send -- plus a text field. The button is itself a group, and we assign the button to a `JPanel` object that is placed at the bottom of a `Container` object obtained from the `JFrame` class.
```java
private void createComponents(Container container) {
    container.add(new JTextArea());
    container.add(createPanel(), BorderLayout.SOUTH);
}

private JPanel createPanel() {
    JPanel panel = new JPanel(new GridLayout(1, 3));
    panel.add(new JButton("Execute"));
    panel.add(new JButton("Test"));
    panel.add(new JButton("Send"));
    return panel;
}
```
The `JPanel` class provides the layout style to use as a constructor parameter. The JPanel class also has a `setLayout` method if the constructor needs a reference to the `Container` object used in the layout style.

If user interface has clear, separate, groups of components we can also *inherit* the `JPanel` class. 
- For example, the panel above could also be implemented in the following way:
```java
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

    public MenuPanel() {
        super(new GridLayout(1, 3));
        createComponents();
    }

    private void createComponents() {
        add(new JButton("Execute"));
        add(new JButton("Test"));
        add(new JButton("Send"));
    }
}
```
Now, able to create a `MenuPanel` instance in our user interface class.
```java
private void createComponents(Container container) {
    container.add(new JTextArea());
    container.add(new MenuPanel(), BorderLayout.SOUTH);
}
```
> Note: If need an action event listener, must provide as parameters all the objects required by the `MenuPanel` class.
