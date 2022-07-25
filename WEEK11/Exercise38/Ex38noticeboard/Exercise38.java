package Ex38noticeboard;

import javax.swing.SwingUtilities;

// Exercise 38: Notice Board
public class Exercise38 {
	public static void main(String[] args) {
		NoticeBoard ui = new NoticeBoard();
        SwingUtilities.invokeLater(ui);
	}
}