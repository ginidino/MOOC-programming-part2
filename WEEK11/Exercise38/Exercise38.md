# Exercise 38: Notice Board

The program has to be composed of the following classes, which are contained in the package `noticeboard`. 
- The class `NoticeBoard` is the user interface class, and it is started from the Main class. 
- The notice board has various different components:
  * `JTextField` 
  * `JButton`
  * `JLabel`
- Manage the layout of the ui components with `GridLayout`: 
  - the call `new GridLayout(3, 1` creates a new layout manager, which sets up three ui elements vertically.

The application also has to contain the class `ActionEventListener`, which implements the interface `ActionListener`. The action event listener is connected to the button, and when pressed, it has to copy the contents of the JTextField into JLabel. At the same time, it wipes the JTextField by setting its contents as "".

Make sure that the user interface is big enough to click on each button.
