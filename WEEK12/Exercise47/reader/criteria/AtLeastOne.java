package reader.criteria;

import reader.Criterion;

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