package Ex39clicker.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import Ex39clicker.applicationlogic.Calculator;

// Exercise 39: Axe Click Effect
// Exercise 39.3: User Interface
public class UserInterface implements Runnable {
	private JFrame frame;
	private Calculator calc;

	public UserInterface(Calculator calc) {
		this.calc = calc;
	}

	@Override
	public void run() {
		this.frame = new JFrame("Calculator");
		this.frame.setPreferredSize(new Dimension(500, 200));
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		createComponents(this.frame.getContentPane());
		
		this.frame.pack();
		this.frame.setVisible(true);
	}

	private void createComponents(Container container) {
		GridLayout layout = new GridLayout(2, 0);
		container.setLayout(layout);
		
		JLabel text = new JLabel(Integer.toString(this.calc.giveValue()));
		JButton click = new JButton("Click!");
		
		ClickListener listener = new ClickListener(text, this.calc);
		click.addActionListener(listener);
		
		container.add(text);
		container.add(click);
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
}