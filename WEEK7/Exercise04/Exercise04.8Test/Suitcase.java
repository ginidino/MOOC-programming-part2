package TEST;

import java.util.ArrayList;

public class Suitcase {
	private ArrayList<Thing> things;
	private int maxWeight;
	private String name;

	public Suitcase(int maxWeight) {
		this.things = new ArrayList<Thing>();
		this.maxWeight = maxWeight;
	}

	public void addThing(Thing thing) {
		int weight = totalWeight();
        weight += thing.getWeight();
        if (weight <= this.maxWeight) {
            things.add(thing);
        }
	}
	public int totalWeight() {
		int weight = 0;
		for (Thing thing : things) {
			weight += thing.getWeight();
		}
		return weight;
	}
	public void printThings() {
		for (Thing thing : things) {
			System.out.println(thing);
		}
	}
	
	public Thing heaviestThing() {
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
		int weight = totalWeight();

        if (things.size() == 0) {
            return "empty " + "(" + weight + " kg)";
        } else if (things.size() == 1) {
            return things.size() + " thing " + "(" + weight + " kg)";
        }
        return things.size() + " things " + "(" + weight + " kg)";
	}
}
