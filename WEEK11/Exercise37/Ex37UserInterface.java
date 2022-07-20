package Week11;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

// Exercise 37: Survey
public class Ex37UserInterface implements Runnable {
	private JFrame frame;

	@Override
	public void run() {
		this.frame = new JFrame("Survey");
		this.frame.setPreferredSize(new Dimension(200, 300));
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
		
		createComponents(frame.getContentPane());
		
		this.frame.pack();
		this.frame.setVisible(true);
	}

	private void createComponents(Container container) {
		BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
		container.setLayout(layout);
		
		container.add(new JLabel("Are you?"));
		JCheckBox yes = new JCheckBox("Yes!");
        JCheckBox no = new JCheckBox("No!");
        container.add(yes);
        container.add(no);
        
        container.add(new JLabel("Why?"));
        JRadioButton noButton = new JRadioButton("No reason.");
        JRadioButton fun = new JRadioButton("Because it is fun!");
        
        ButtonGroup multipleChoice = new ButtonGroup();
        multipleChoice.add(noButton);
        multipleChoice.add(fun);
        
        container.add(noButton);
        container.add(fun);
        
        JButton done = new JButton("Done!");
        container.add(done);   
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
}
