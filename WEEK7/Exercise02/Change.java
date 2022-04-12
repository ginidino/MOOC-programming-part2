package Week7;

//Exercise 2: Character String Changer
//Exercise 2.1: Change-class
public class Change {
	private char toCharacter;
	private char fromCharacter;

	public Change(char fromCharacter, char toCharacter) {
		// creates an object that makes changes from character fromCharacter to toCharacter
		this.fromCharacter = fromCharacter;
		this.toCharacter = toCharacter;
	}

	public String change(String characterString) {
		// returns the changed version of the given character string
		String changed = "";
		for (int i = 0; i < characterString.length(); i++) {
			if (characterString.charAt(i) == this.fromCharacter) {
				changed += this.toCharacter;
			} else {
				changed += characterString.charAt(i);
			}
		}
		return changed;
		//return characterString.replace(fromCharacter, toCharacter);
	}
}
