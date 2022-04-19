package Week7;

import java.util.ArrayList;

//Exercise 4: Thing, Suitcase, and Container
public class Container {
	private ArrayList<Suitcase> suitcases;
	private int maxWeight;

	// Exercise 4.6: Container
	public Container(int maxWeight) {
		// which is given the maximum weight limit
		this.suitcases = new ArrayList<Suitcase>();
		this.maxWeight = maxWeight;
	}
	// Exercise 4.6: Container
	public void addSuitcase(Suitcase suitcase) {
		// adds the suitcase as a parameter to the container
		int weight = 0;
		for (Suitcase sc : suitcases) {
			weight += sc.totalWeight();
		}
        	if (this.maxWeight - weight >= suitcase.totalWeight()) {
            		this.suitcases.add(suitcase);
        	}
	}
	
	public int totalWeight() {
		int weight = 0;
        	for (Suitcase suitcase : suitcases) {
            		weight += suitcase.totalWeight();
        	}
		return weight;
	}
	// Exercise 4.7: The Container Contents
	public void printThings() {
		for (Suitcase suitcase : suitcases) {
			suitcase.printThings();
		}
	}
	// Exercise 4.6: Container
	public String toString() {
		// returns a string in the form "x suitcases (y kg)"
		int weight = 0;
		for (Suitcase suitcase : suitcases) {
			weight += suitcase.totalWeight();
		}
		return suitcases.size() + " suitcases " + "(" + weight + " kg)";
	}
}
