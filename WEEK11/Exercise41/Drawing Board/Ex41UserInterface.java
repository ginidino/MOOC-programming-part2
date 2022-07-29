package Week11;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

// Exercise 41: Drawing Board
public class Ex41UserInterface implements Runnable {
	private JFrame frame;

	@Override
	public void run() {
		this.frame = new JFrame("Drawing Board");
		this.frame.setPreferredSize(new Dimension(400, 400));
		
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		createComponents(this.frame.getContentPane());
		
		this.frame.pack();
		this.frame.setVisible(true);
	}
	
	private void createComponents(Container container) {
		container.add(new DrawingBoard());
	}
}