package containers;

// Exercise 30: Container
public class Container {
	private double capacity;
	private double volume;

	public Container(double capacity) {
		// an improper capacity (<=0) creates a useless container, whose capacity is 0
		if (capacity > 0.0) {
			this.capacity = capacity;
		} else {
			this.capacity = 0.0;
		}
		
		this.volume = 0.0;
	}
	
	public double getVolume() {
		// returns the volume of product in the container
		return this.volume;
	}
	
	public double getOriginalCapacity() {
		// returns the original capacity of the container, that is to say what the constructor was originally given
		return this.capacity;
	}
	
	public double getCurrentCapacity() {
		// returns the actual capacity of the container
		return this.capacity - this.volume;
	}
	
	public void addToTheContainer(double amount) {
		// adds the specified amount of things to the container
		// If the amount is negative, nothing changes
		// if a part of that amount fits but not the whole of it, the container is filled up and the left over is thrown away
		// adds product to container if product is too large adds until container full and throws away res
		if (amount < 0) {
			return;
		}
		if (amount <= getCurrentCapacity()) {
			this.volume += amount;
		} else {
			this.volume = this.capacity;
		}
	}
	
	public double takeFromTheContainer(double amount) {
		// take the specified amount form the container, the method returns what we receive
		// If the specified amount is negative, nothing happens and zero is returned
		// If we ask for more than what there is in the container, the method returns all the contents
		if (amount < 0) {
			return 0.0;
		}
		if (amount > this.volume) {
			double all = this.volume;
			this.volume = 0.0;
			return all;
		}
		this.volume -= amount;
		
		return amount;
	}
	
	@Override
	public String toString() {
		return "volume = " + this.volume + ", free space " + getCurrentCapacity();
	}
}
