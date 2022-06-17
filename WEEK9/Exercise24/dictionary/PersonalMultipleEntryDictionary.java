package dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Exercise 24: Multiple Entry Dictionary
public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {
	private Map<String, Set<String>> dictionary;
	
	public PersonalMultipleEntryDictionary() {
		this.dictionary = new HashMap<String, Set<String>>();
	}
	
	@Override
	public void add(String word, String entry) {
		// adds a new entry to a word, maintaining the old ones
		if(!this.dictionary.containsKey(word)) {
			this.dictionary.put(word, new HashSet<String>());
		}
		Set<String> translations = this.dictionary.get(word);
		translations.add(entry);
	}

	@Override
	public Set<String> translate(String word) {
		// returns a Set object, with all the entries of the word, or a null reference, if the word is not in the dictionary
		if(!this.dictionary.containsKey(word)) {
			return null;
		}
		return this.dictionary.get(word);
	}

	@Override
	public void remove(String word) {
		// removes a word and all its entries from the dictionary
		this.dictionary.remove(word);
	}
}
