package Ex39clicker.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import Ex39clicker.applicationlogic.Calculator;

// Exercise 39: Axe Click Effect
// Exercise 39.2: ClickListener
public class ClickListener implements ActionListener {
	private JLabel label;
	private Calculator calc;

	public ClickListener(JLabel label, Calculator calc) {
		this.label = label;
		this.calc = calc;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.calc.increase();
		this.label.setText(Integer.toString(this.calc.giveValue()));
	}
}