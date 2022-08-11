package reader.criteria;

import reader.Criterion;

// Exercise 47: Flexible Filtering Criteria
// LengthAtLeast
public class LengthAtLeast implements Criterion {
	private int length;

	public LengthAtLeast(int length) {
		this.length = length;
	}

	@Override
	public boolean complies(String line) {
		return line.length() >= this.length;
	}
}