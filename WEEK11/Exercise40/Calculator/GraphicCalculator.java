package Week11;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

// Exercise 40: Calculator
// Exercise 40.2: Basic Functionality
// Exercise 40.3: Cozy Management
public class GraphicCalculator implements Runnable {
	private JFrame frame;
	private JTextField input;
    private JTextField output;
    private JButton zero;

	@Override
	public void run() {
		this.frame = new JFrame("Calculator");
		this.frame.setPreferredSize(new Dimension(500, 300));
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		createComponents(this.frame.getContentPane());
		
		this.frame.pack();
		this.frame.setVisible(true);
	}
	// Exercise 40.1: The Layout
	private void createComponents(Container container) {
		GridLayout layout = new GridLayout(3,1);
        container.setLayout(layout);
        
        this.output = new JTextField("0");
        this.output.setEditable(false);
        
        this.input = new JTextField();
        
        container.add(output);
        container.add(input);
        container.add(createPanel(), BorderLayout.SOUTH);
	}
	// Exercise 40.1: The Layout
	private JPanel createPanel() {
		JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,3));
        
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        this.zero = new JButton("Z");
        
        this.zero.setEnabled(false);
        
        plus.addActionListener(new Calculator(this.input, this.output, this.zero, plus, minus));
        minus.addActionListener(new Calculator(this.input, this.output, this.zero, plus, minus));
        this.zero.addActionListener(new Calculator(this.input, this.output, this.zero, plus, minus));
        
        panel.add(plus);
        panel.add(minus);
        panel.add(zero);
        
        return panel;
	}
	
	public JFrame getFrame() {
        return this.frame;
    }
}