package Week09;

import mooc.logic.ApplicationLogic;
import mooc.ui.TextUserInterface;
import mooc.ui.UserInterface;

//Exercise 17: First Packages
//Exercise 17.3: Application Logic
public class Exercise17 {
	public static void main(String[] args) {
		UserInterface ui = new TextUserInterface();
		new ApplicationLogic(ui).execute(3);
	}
}
