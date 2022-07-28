# Exercise 40: Calculator
The goal of the exercise is creating a simple calculator.

Together with the exercise body, you find the main program which starts the calculator, as well as the class `GraphicCalculator` which contains a graphic user interface. The user interface has to follow exactly the following points, but you can plan the program structure as you wish. 
> Note: `GraphicCalculator` provides empty methods `run`, `createComponents` and `getFrame`.

## Exercise 40.1: The Layout
`JFrame` with the exercise body;    
Manage its layout using `GridLayout` with three lines and one column. `JTextField` has to be placed in the upper block and has to be used for the text output; it must be set off with the method call `setEnabled(false)`. The second block has to contain JTextField for the text input. Originally, the input field contains the text "0", and the input field is empty.

The lowest block has to contain `JPanel`, and this has to have the layout manager `GridLayout`, with one line and three columns. The panel has three `JButtons`, with texts `"+"`, `"-"` and `"Z"`.

## Exercise 40.2: Basic Functionality
The calculator basic functionality is the following. When the user writes a number n into the input field and presses +, the value of the output field is added n and the output field is updated with a new value. Accordingly, when the user writes a number n into the input field and presses -, the value of the output field is decreased by n, and the output field is updated with the new value. If the user presses Z, the output field value is reset to zero.

## Exercise 40.3: Cozy Management
Let's extend our program with the following features:

- If the output field is 0, the user can't press the Z button, i.e. the button has to be set off with the method call `setEnabled(false)`. Otherwise, the button has to be on.
- When the user presses any of the buttons +, -, Z the input field is wiped.
- If the input value is not an integer and the user presses one of the buttons +, -, Z, the input field is wiped and the value of the output field does not change (unless the button is Z).
