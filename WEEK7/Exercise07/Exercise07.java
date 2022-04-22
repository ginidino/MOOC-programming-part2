package Week7;

import java.util.ArrayList;
import java.util.Scanner;

// Exercise 7: Dictionary
public class Exercise07 {
	public static void main(String[] args) {
		// Exercise 7.1: Class Dictionary
		Dictionary dictionary = new Dictionary();
	    dictionary.add("원숭이", "monkey");
	    dictionary.add("바나나", "banana");
	    dictionary.add("하프시코드", "harpsichord");

	    System.out.println(dictionary.translate("원숭이"));
	    System.out.println(dictionary.translate("당근"));
	    System.out.println();
	    
	    // Exercise 7.2: Amount of Words
	    Dictionary dictionaries = new Dictionary();
	    dictionaries.add("원숭이", "monkey");
	    dictionaries.add("바나나", "banana");
	    System.out.println(dictionaries.amountOfWords());

	    dictionaries.add("하프시코드", "harpsichord");
	    System.out.println(dictionaries.amountOfWords());
	    System.out.println();
	    
	    // Exercise 7.3: Listing All Words
	    ArrayList<String> translations = dictionary.translationList();
	    for(String translation: translations) {
	        System.out.println(translation);
	    }
	    System.out.println();
	    
	    // Exercise 7.4: The Beginning of a Text User Interface
	    Scanner reader = new Scanner(System.in);
	    Dictionary dict = new Dictionary();

	    TextUserInterface ui = new TextUserInterface(reader, dict);
	    ui.start();
	}
}
