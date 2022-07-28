package Week11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

// Exercise 40: Calculator
// Exercise 40.2: Basic Functionality
// Exercise 40.3: Cozy Management
public class Calculator implements ActionListener {
	private JTextField input;
	private JTextField output;
	private JButton zero;
	private JButton plus;
	private JButton minus;

	public Calculator(JTextField input, JTextField output, JButton zero, JButton plus, JButton minus) {
		this.input = input;
		this.output = output;
		this.zero = zero;
		this.plus = plus;
		this.minus = minus;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.plus) {
			sum();
		} else if (e.getSource() == this.minus) {
			minus();
		} else {
			reset();
		}
	}

	public void sum() {
		int in = 0;
        int out = 0;
        
        try {
            
            in = Integer.parseInt(input.getText());
            out = Integer.parseInt(output.getText());

            out += in;

            this.input.setText("");
            this.output.setText("" + out);
            if(Integer.parseInt(this.output.getText()) == 0){
                this.zero.setEnabled(false);
            } else {
                this.zero.setEnabled(true);
            }
        } catch (NumberFormatException nfe){
            this.input.setText("");
        }
	}

	public void minus() {
		int in = 0;
        int out = 0;
        
        try {
            
            in = Integer.parseInt(input.getText());
            out = Integer.parseInt(output.getText());

            out -= in;

            this.input.setText("");
            this.output.setText("" + out);
            if(Integer.parseInt(this.output.getText()) == 0){
                this.zero.setEnabled(false);
            } else {
                this.zero.setEnabled(true);
            }
        } catch (NumberFormatException nfe){
            this.input.setText("");
        }
	}

	public void reset() {
		this.input.setText("");
        this.output.setText("0");
        this.zero.setEnabled(false);
	}
}