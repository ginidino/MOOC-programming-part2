package boxes;

// Exercise 32: Different Boxes
// Exercise 32.3: One-Thing Box and Black-Hole Box
public class OneThingBox extends Box {
	private Thing things;
	
	public OneThingBox() {
		this.things = null;
	}

	@Override
	public void add(Thing thing) {
		if (this.things == null) {
			this.things = thing;
		}
	}

	@Override
	public boolean isInTheBox(Thing thing) {
		if (thing == null || this.things == null) {
			return false;
		}
		return this.things.equals(thing);
	}

}