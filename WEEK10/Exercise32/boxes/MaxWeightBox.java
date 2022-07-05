package boxes;

import java.util.ArrayList;
import java.util.List;

// Exercise 32: Different Boxes
// Exercise 32.2: Maximum Weight Box
public class MaxWeightBox extends Box {
	private int maxWeight;
	private List<Thing> things;

	public MaxWeightBox(int maxWeight) {
		// determines the box maximum weight
		this.maxWeight = maxWeight;
		this.things = new ArrayList<Thing>();
	}

	@Override
	public void add(Thing thing) {
		int currentWeight = 0;
		for (Thing t : this.things) {
			currentWeight += t.getWeight();
		}
		if (thing.getWeight() + currentWeight <= this.maxWeight) {
			this.things.add(thing);
		}
	}

	@Override
	public boolean isInTheBox(Thing thing) {
		for (Thing t : this.things) {
			if (t.equals(thing)) {
				return true;
			}
		}
		return false;
	}
}
