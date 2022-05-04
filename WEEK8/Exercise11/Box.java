package Week08;

import java.util.ArrayList;

// Exercise 11: Boxes and Things
// Exercise 11.2: Box
public class Box implements ToBeStored {
	private double maxWeight;
	private ArrayList<ToBeStored> item;
	
	public Box(double maxWeight) {
		this.maxWeight = maxWeight;
		this.item = new ArrayList<ToBeStored>();
	}

	public void add(ToBeStored items) {
		if ((this.maxWeight - this.weight()) >= items.weight()) {
			this.item.add(items);
		}
	}
	
	public double weight() {
		// Exercise 11.3: Box weight
		double weight = 0;
		for (ToBeStored item : this.item) {
			weight += item.weight();
		}
		return weight;
		
		//return 0;
	}
	
	public String toString() {
		return "Box: " + this.item.size() + " things, total weight " + this.weight() + " kg";
	}
}
