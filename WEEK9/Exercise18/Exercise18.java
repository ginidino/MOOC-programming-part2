package Week09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import moving.domain.Box;
import moving.domain.Item;
import moving.domain.Thing;
import moving.logic.Packer;

// Exercise 18: Moving
public class Exercise18 {
	public static void main(String[] args) {
		// Exercise 18.1: Things and Items
		Thing item = new Item("toothbrash", 2);
	    System.out.println(item);
	    System.out.println();
	    
	    // Exercise 18.2: Comparable Item
	    List<Item> items = new ArrayList<Item>();
	    items.add(new Item("passport", 2));
	    items.add(new Item("toothbrash", 1));
	    items.add(new Item("circular saw", 100));

	    Collections.sort(items);
	    System.out.println(items);
	    System.out.println();
	    
	    // the things we want to pack
	    List<Thing> things = new ArrayList<Thing>();
	    things.add(new Item("passport", 2));
	    things.add(new Item("toothbrash", 1));
	    things.add(new Item("book", 4));
	    things.add(new Item("circular saw", 8));

	    // Exercise 18.4: Packing Items
	    // we create a packer which uses boxes whose valume is 10
	    Packer packer = new Packer(10);

	    // we ask our packer to pack things into boxes
	    List<Box> boxes = packer.packThings(things);

	    System.out.println("number of boxes: " + boxes.size());

	    for (Box box : boxes) {
	        System.out.println("  things in the box: " + box.getVolume() + " dm^3");
	    }
	}
}
