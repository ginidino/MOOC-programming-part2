package dictionary;

import java.util.Set;

// Exercise 24: Multiple Entry Dictionary
public interface MultipleEntryDictionary {
	void add(String word, String translation);
    Set<String> translate(String word);
    void remove(String word);
}
