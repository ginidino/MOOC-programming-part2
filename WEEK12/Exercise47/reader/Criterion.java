package reader;

// Exercise 47: Flexible Filtering Criteria
public interface Criterion {
	boolean complies(String line);
}
