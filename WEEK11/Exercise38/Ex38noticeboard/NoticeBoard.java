package Ex38noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

// Exercise 38: Notice Board
public class NoticeBoard implements Runnable {
	private JFrame frame;

	@Override
	public void run() {
		this.frame = new JFrame("Title");
        this.frame.setPreferredSize(new Dimension(500, 300));

        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(this.frame.getContentPane());

        this.frame.pack();
        this.frame.setVisible(true);
	}

	private void createComponents(Container container) {
		GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        
        JTextField textAreaTop = new JTextField("I was copied here from the JTextArea.");
        JButton copy = new JButton("Copy!");
        JLabel textAreaBottom = new JLabel();
        
        ActionEventListener copier = new ActionEventListener(textAreaTop, textAreaBottom);
        copy.addActionListener(copier);
        
        container.add(textAreaTop);
        container.add(copy);
        container.add(textAreaBottom);
	}
}