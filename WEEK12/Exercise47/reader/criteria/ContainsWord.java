package reader.criteria;

import reader.Criterion;

// Exercise 47: Flexible Filtering Criteria
public class ContainsWord implements Criterion {
	String word;
	
	public ContainsWord(String word) {
		this.word = word;
	}

	@Override
	public boolean complies(String line) {
		return line.contains(word);
	}
}