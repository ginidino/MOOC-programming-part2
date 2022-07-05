package boxes;

import java.util.ArrayList;
import java.util.List;

// Exercise 32: Different Boxes
// Exercise 32.3: One-Thing Box and Black-Hole Box
public class BlackHoleBox extends Box {
	private List<Thing> things;
	
	public BlackHoleBox() {
		// any thing can be added to a black-hole box, but none will be found when you'll look for them
		this.things = new ArrayList<Thing>();
	}

	@Override
	public void add(Thing thing) {
		this.things.add(thing);
	}

	@Override
	public boolean isInTheBox(Thing thing) {
		// adding things must always work, but the method isInTheBox has to return always false
		return false;
	}

}
