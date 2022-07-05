package boxes;

import java.util.Collection;

// Exercise 32: Different Boxes
public abstract class Box {
	
	public abstract void add(Thing thing);

    public void add(Collection<Thing> things) {
        for (Thing thing : things) {
            add(thing);
        }
    }

    public abstract boolean isInTheBox(Thing thing);
}
