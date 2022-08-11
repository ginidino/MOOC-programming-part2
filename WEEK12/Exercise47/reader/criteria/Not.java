package reader.criteria;

import reader.Criterion;

// Exercise 47: Flexible Filtering Criteria
// Exercise 47.5: Negation
public class Not implements Criterion {
	private Criterion criterion;

	public Not(Criterion criterion) {
        this.criterion = criterion;
    }

    @Override
    public boolean complies(String line) {
        return !criterion.complies(line);
    }
}