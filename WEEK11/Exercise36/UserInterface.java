package Week11;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

// Exercise 36: Greeter
public class UserInterface implements Runnable {
	private JFrame jframe;
	
	@Override
	public void run() {
		this.jframe = new JFrame("Swing on");
		this.jframe.setPreferredSize(new Dimension(400, 200));
		this.jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		createComponents(this.jframe.getContentPane());
		this.jframe.pack();
		this.jframe.setVisible(true);
	}

	private void createComponents(Container contanier) {
		JLabel text = new JLabel("Hi!");
		contanier.add(text);
	}
	
	public JFrame getFrame() {
        return this.jframe;
    }
}
