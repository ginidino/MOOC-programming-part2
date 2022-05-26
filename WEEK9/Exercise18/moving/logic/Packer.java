package moving.logic;

import java.util.ArrayList;
import java.util.List;

import moving.domain.Box;
import moving.domain.Thing;

public class Packer {
	private List<Box> boxes;
	private Box box;
	private int boxesVolume;

	public Packer(int boxesVolume) {
		this.boxes = new ArrayList<Box>();
		this.box = new Box(boxesVolume);
		this.boxesVolume = boxesVolume;
	}

	public List<Box> packThings(List<Thing> things) {
		this.boxes.add(box);
		for (Thing thing : things) {
			if (!this.box.addThing(thing)) {
				this.box = new Box(boxesVolume);
				this.boxes.add(this.box);
				this.box.addThing(thing);
			}
		}
		return this.boxes;
		/*Box box = new Box(this.boxesVolume);
		for (Thing thing : things) {
			box.addThing(thing);
			this.boxes.add(box);
		}
		return this.boxes;*/
	}
}
