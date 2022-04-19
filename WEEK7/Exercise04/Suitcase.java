package Week7;

import java.util.ArrayList;

// Exercise 4: Thing, Suitcase, and Container
// Exercise 4.2: Class Suitcase
public class Suitcase {
	private ArrayList<Thing> things;
	private int maxWeight;
	//private int weight;
	//private Thing thing;
	private String name;

	public Suitcase(int maxWeight) {
		this.things = new ArrayList<Thing>();
		this.maxWeight = maxWeight;
		//this.weight = 0;
		//this.thing = new Thing(name, weight);
	}

	public void addThing(Thing thing) {
		// adds the thing in the parameter to your suitcase. 
		// The method does not return any value.
		int weight = 0;
		for (int i = 0; i < things.size(); i++) {
			weight += thing.getWeight();
		}
		if (weight <= this.maxWeight) {
			things.add(thing);
		}
	}
	// Exercise 4.4: Every Thing
	public int totalWeight() {
		// returns the total weight of the things in your suitcase
		int weight = 0;
		for (Thing thing : things) {
			weight += thing.getWeight();
		}
		return weight;
	}
	// Exercise 4.4: Every Thing
	public void printThings() {
		// prints out all the things inside the suitcase
		for (Thing thing : things) {
			System.out.println(thing);
		}
	}
	
	public Thing heaviestThing() {
		// returns the thing which weighs the most
		if (this.things.isEmpty()) {
			return null;
		} else {
			Thing heaviest = this.things.get(0);
			
			for (Thing thing : things) {
				if (heaviest.getWeight() <= thing.getWeight()) {
					heaviest = thing;
				}
			}
			return heaviest;
		}
	}

	public String toString() {
		// returns a string in the form "x things (y kg)"
		// Exercise 4.2: Class Suitcase
		/*int weight = 0;
		for (Thing thing : things) {
			weight += thing.getWeight();
		}*/
		//return this.things.size() + " thing " + "("  + weight + " kg" + ")";
		// Exercise 4.3: Language Check
		/*if (this.things.size() >= 1) {
			return this.things.size() + " thing " + "("  + weight + " kg" + ")";
		} else {
			return "empty (0 kg)";
		}*/
		
		// using Exercise 4.4, totalWeight()
		if (this.things.size() >= 1) {
			return this.things.size() + " thing " + "("  + totalWeight() + " kg" + ")";
		} else {
			return "empty (0 kg)";
		}
	}
}
