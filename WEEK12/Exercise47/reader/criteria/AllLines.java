package reader.criteria;

import reader.Criterion;

// Exercise 47: Flexible Filtering Criteria
// Exercise 47.1: All Lines
public class AllLines implements Criterion {

	@Override
	public boolean complies(String line) {
		return true;
	}
}