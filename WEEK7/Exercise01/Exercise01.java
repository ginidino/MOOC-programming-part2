package Week7;

public class Exercise01 {
	public static void main(String[] args) {
		printWithSmileys("\\:D/");
		printWithSmileys("87.");
	}

	private static void printWithSmileys(String characterString) {
		int length = characterString.length();
		int lenEven = length + 1;
		int lenOdd = length + 2;
		String smileys = ":)";
		
		if (length % 2 == 0) {
			printSmiley(lenEven);
			System.out.println(smileys + " " + characterString + " " + smileys);
			printSmiley(lenEven);
		} else if (length % 2 == 1) {
			printSmiley(lenOdd);
			System.out.println(smileys + " " + characterString + "  " + smileys);
			printSmiley(lenOdd);
		}
	}

	private static void printSmiley(int length) {
		String smileys = ":)";
		for (int i = 0; i < length; i++) {
			System.out.print(smileys);
		}
		System.out.println();
	}
}
