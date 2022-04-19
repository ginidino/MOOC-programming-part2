package TEST;

public class Thing {
	private String name;
	private int weight;

	public Thing(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public String getName() {
		// returns the thing's name
		return this.name;
	}
	
	public int getWeight() {
		// returns the thing's weight
		return this.weight;
	}
	
	public String toString() {
		return this.name + " (" + this.weight + " kg)";
	}
}