package Week7;

import java.util.Scanner;

// Exercise 7: Dictionary
public class TextUserInterface {
	private Scanner reader;
	private Dictionary dict;
	
	// Exercise 7.4: The Beginning of a Text User Interface
	public TextUserInterface(Scanner reader, Dictionary dict) {
		this.reader = new Scanner(System.in);
		this.dict = dict;
	}
	// Exercise 7.5: Adding and Translating Words
	public void start() {
		// starts the interface
		// Exercise 7.4: The Beginning of a Text User Interface
		System.out.println("Statements:");
        System.out.println("  add - adds a word pair to the dictionary");
        System.out.println("  translate - asks a word and prints its translation");
        System.out.println("  quit - quit the text user interface");
        System.out.println();
		
		while (true) {
			System.out.print("Statement: ");
			String command = reader.nextLine();
			
			if (command.equals("quit")) {
				System.out.println("Cheers!");
				break;
			}
			// Exercise 7.4: The Beginning of a Text User Interface
			/*if (!(command.equals("quit"))) {
				System.out.println("Unknown statement \n");
			}*/
			if (command.equals("add")) {
				System.out.print("In Korean: ");
				String kWord = reader.nextLine();
				System.out.print("Translation: ");
				String eWord = reader.nextLine();
				this.dict.add(kWord, eWord);
				System.out.println();
			} else if (command.endsWith("translate")) {
				System.out.print("Give a word: ");
				String givenWord = reader.nextLine();
				System.out.print("Translation: " + this.dict.translate(givenWord) + "\n");
				System.out.println();
			} else {
				System.out.println("Unknown statement");
			}
		}
	}
}
