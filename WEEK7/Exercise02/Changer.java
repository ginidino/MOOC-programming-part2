package Week7;

import java.util.ArrayList;

// Exercise 2.2: Changer-class
public class Changer {
	private ArrayList<Change> changes;
	
	public Changer() {
		// creates a new changer
		this.changes = new ArrayList<Change>();
	}

	public void addChange(Change change) {
		// adds a new Change to the Changer
		changes.add(change);
	}

	public String change(String characterString) {
		// executes all added Changes for the character string in the order of their adding and returns the changed character string
		for (Change change : changes) {
			characterString = change.change(characterString);
		}
		return characterString;
	}
}
