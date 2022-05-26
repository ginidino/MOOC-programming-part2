package moving.domain;

// Exercise 18: Moving
// Exercise 18.1: Things and Items
public class Item implements Thing, Comparable<Item> {
	private String name;
	private int volume;
	
	public Item(String name, int volume) {
		this.name = name;
		this.volume = volume;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getVolume() {
		return this.volume;
	}
	
	public String toString() {
		return this.name + " (" + this.volume + " dm^3)";
	}
	// Exercise 18.2: Comparable Item
	public int compareTo(Item thing) {
		return this.volume - thing.getVolume();
	}
}
