package tools;

import java.util.Set;

// Exercise 25: Duplicate Remover
public interface DuplicateRemover {
	void add(String characterString);
    int getNumberOfDetectedDuplicates();
    Set<String> getUniqueCharacterStrings();
    void empty();
}
