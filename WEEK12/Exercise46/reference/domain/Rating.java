package reference.domain;

// Exercise 46.2: Rating
public enum Rating {
	BAD(-5), 
    MEDIOCRE(-3), 
    NOT_WATCHED(0), 
    NEUTRAL(1), 
    FINE(3), 
    GOOD(5);
	
	private int value;
	
	private Rating(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
