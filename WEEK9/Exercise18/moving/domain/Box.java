package moving.domain;

import java.util.ArrayList;
import java.util.List;

// Exercise 18: Moving
// Exercise 18.3: Moving Box
public class Box implements Thing {
	private List<Thing> things;
	private int max;
	
	
	public Box(int boxesVolume) {
		// receives the box maximum capacity as parameter
		this.things = new ArrayList<Thing>();
		this.max = boxesVolume;
	}
	
	public boolean addThing(Thing thing) {
		// adds an item which implements the interface Thing to the box
		// If it does not fit in the box, the method returns false, otherwise true
		// The box must store the things into a list.
		if (thing.getVolume() + this.getVolume() <= this.max) {
			this.things.add(thing);
			return true;
		}
		return false;
	}
	
	public int getVolume() {
		int currentVolume = 0;
		
		for (Thing thing : this.things) {
			currentVolume += thing.getVolume();
		}
		return currentVolume;
	}
	// Exercise 18.4: Packing Items
	public String toString() {
		return this.getVolume() + " dm^3";
	}
}
