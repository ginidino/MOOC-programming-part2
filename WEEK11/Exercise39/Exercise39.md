# Exercise 39: Axe Click Effect
In this exercise, implement a calculator to count the number of clicks. In the exercise, the application logic (counting) and the ui logic are divided from each other.

## Exercise 39.1: PersonalCalculator
Implement the class `ClickListener` in the package `clicker.ui`; the class implements the interface `ActionListener`. `ClickListener` receives two objects as constructor parameters: an object which implements the interface `Calculator` and a `JLabel` object.

Implement the `actionPerformed` method so that the `Calculator` object increases by one at first, and after it, the calculator value is set as text of the `JLabel` object. The text of the `JLabel` object can be modified with the method `setText`.

```java
Calculator calc = new PersonalCalculator();
System.out.println("Value: " + calc.giveValue());
calc.increase();
System.out.println("Value: " + calc.giveValue());
calc.increase();
System.out.println("Value: " + calc.giveValue());
```
```
Value: 0
Value: 1
Value: 2
```

## Exercise 39.2: ClickListener
Implement the class `ClickListener` in the package `clicker.ui`; the class implements the interface `ActionListener`. `ClickListener` receives two objects as constructor parameters: an object which implements the interface `Calculator` and a JLabel object.

Implement the `actionPerformed` method so that the `Calculator` object increases by one at first, and after it, the calculator value is set as text of the `JLabel` object. The text of the `JLabel` object can be modified with the method `setText`.

## Exercise 39.3: User Interface
Modify the class `UserInterface`; now the user interface has to receive a `Calculator` object as constructor parameter: you need a new constructor. Add the necessary ui components to your `UserInterface`. Also, set the action event listener you implemented in the previous section to the button.

Use the functionality provided by the class `BorderLayout` to manage the layout of the ui components. Also, change the Main class so that the user interface is assigned a `PersonalCalculator` object. When the `"Click!"` button in the user interface has been pressed twice, the application looks like below, more or less.
