package Ex42movingfigure;

import javax.swing.SwingUtilities;

// Exercise 42: A Moving Figure
public class Exercise42 {
	public static void main(String[] args) {
		// Exercise 42.3: Drawing Board
		// UserInterface ui = new UserInterface(new Circle(50, 50, 250));
        // SwingUtilities.invokeLater(ui);
        
		// Exercise 42.5: Square and Box
        // UserInterface ui = new UserInterface(new Square(50, 50, 250));
        // SwingUtilities.invokeLater(ui);
        
		// Exercise 42.5: Square and Box
        // UserInterface ui = new UserInterface(new Box(50, 50, 100, 300));
        // SwingUtilities.invokeLater(ui);
		
		CompoundFigure truck = new CompoundFigure();

        truck.add(new Box(220, 110, 75, 100));
        truck.add(new Box(80, 120, 200, 100));
        truck.add(new Circle(100, 200, 50));
        truck.add(new Circle(220, 200, 50));

        UserInterface ui = new UserInterface(truck);
        SwingUtilities.invokeLater(ui);
	}
}
