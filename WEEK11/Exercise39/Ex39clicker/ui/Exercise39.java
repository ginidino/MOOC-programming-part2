package Ex39clicker.ui;

import javax.swing.SwingUtilities;
import Ex39clicker.applicationlogic.Calculator;
import Ex39clicker.applicationlogic.PersonalCalculator;

// Exercise 39: Axe Click Effect
// Exercise 39.2: ClickListener
// Exercise 39.3: User Interface
public class Exercise39 {
	public static void main(String[] args) {
		Calculator calc = new PersonalCalculator();
		UserInterface ui = new UserInterface(calc);
        SwingUtilities.invokeLater(ui);
	}
}
