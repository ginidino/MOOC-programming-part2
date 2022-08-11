package reader.criteria;

import reader.Criterion;

// Exercise 47: Flexible Filtering Criteria
// Exercise 47.6: At Least One
public class AtLeastOne implements Criterion {
private Criterion[] criteria;
    
    public AtLeastOne(Criterion... criterion) {
        this.criteria = criterion;
    }
    
    @Override
    public boolean complies(String line) {
        for (Criterion criterion : criteria) {
            if (criterion.complies(line)) {
                return true;
            }
        }
        return false;
	}
}
