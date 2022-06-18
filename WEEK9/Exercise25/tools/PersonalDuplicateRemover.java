package tools;

import java.util.HashSet;
import java.util.Set;

// Exercise 25: Duplicate Remover
public class PersonalDuplicateRemover implements DuplicateRemover {
	private Set<String> entries;
	private int duplicate;
	
	public PersonalDuplicateRemover() {
		this.entries = new HashSet<String>();
		this.duplicate = 0;
	}

	@Override
	public void add(String characterString) {
		// stores a characterString if it's not a duplicate
		if(!this.entries.contains(characterString)) {
			this.entries.add(characterString);
		} else {
			this.duplicate++;
		}
	}

	@Override
	public int getNumberOfDetectedDuplicates() {
		// returns the number of detected duplicates
		return this.duplicate;
	}

	@Override
	public Set<String> getUniqueCharacterStrings() {
		// returns an object which implements the interface Set<String>.
		// Object should have all unique characterStrings (no duplicates!). 
		// If there are no unique characterStrings, method returns an empty set.
		return this.entries;
	}

	@Override
	public void empty() {
		// removes stored characterStrings and resets the amount of detected duplicates
		this.entries.removeAll(entries);
		this.duplicate = 0;
	}
}
