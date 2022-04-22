package Week7;

import java.util.ArrayList;
import java.util.HashMap;

// Exercise 7: Dictionary
public class Dictionary {
	private HashMap<String, String> dict;
	
	public Dictionary() {
		this.dict = new HashMap<String, String>();
	}
	// Exercise 7.1: Class Dictionary
	public void add(String word, String translation) {
		// adding a new translation to the dictionary
		this.dict.put(word, translation);
		
	}
	// Exercise 7.1: Class Dictionary
	public String translate(String word) {
		// returning the translation of its parameter. If the word is unknown, it returns null
		if(this.dict.containsKey(word)) {
			return this.dict.get(word);
		} else {
			return null;
		}
	}
	// Exercise 7.2: Amount of Words
	public int amountOfWords() {
		// returns the amount of words in the dictionary
		return this.dict.size();
	}
	// Exercise 7.3: Listing All Words
	public ArrayList<String> translationList() {
		// returning strings which stand for a content list of your dictionary in the form key = value
		ArrayList<String> list = new ArrayList<String>();
		for (String key : this.dict.keySet()) {
			list.add(key + " = " + this.dict.get(key));
		}
		return list;
	}
}
