package farmsimulator;

// Exercise 31: Farm Simulator
// Exercise 31.1: Bulk Tank
public class BulkTank {
	private double capacity;
	private double volume;
	
	public BulkTank() {
		this.capacity = 2000;
		this.volume = 0;
	}
	
	public BulkTank(double capacity) {
		this.capacity = capacity;
		this.volume = 0;
	}
	
	public double getCapacity() {
		return this.capacity;
	}
	
	public double getVolume() {
		return this.volume;
	}
	
	public double howMuchFreeSpace() {
		return this.capacity - this.volume;
	}
	
	public void addToTank(double amount) {
		// adds to the tank only as much milk as it fits
		if (amount <= howMuchFreeSpace()) {
			this.volume += amount;
		} else {
			this.volume = this.capacity;
		}
	}
	
	public double getFromTank(double amount) {
		// takes the required amount from the tank, or as much as there is left
		if (amount >= this.volume) {
			this.volume = 0;
			return this.volume;
		} else {
			this.volume -= amount;
			return this.volume;
		}
	}
	
	public String toString() {
		return Math.ceil(this.volume) + "/" + Math.ceil(this.capacity);
	}
}
