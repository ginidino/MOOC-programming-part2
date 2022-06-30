package containers;

public class ProductContainerRecorder extends ProductContainer {
	private ContainerHistory history;
	
	// Exercise 30.6: Product Container Recorder, Phase 1
	public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
		super(productName, capacity);
		super.addToTheContainer(initialVolume);
		this.history = new ContainerHistory();
		this.history.add(initialVolume);
	}
	// Exercise 30.6: Product Container Recorder, Phase 1
	public String history()  {
		// returns the container history in the following form: [0.0, 119.2, 21.2]
		return this.history.toString();
	}
	// Exercise 30.7: Product Container Recorder, Phase 2
	@Override
	public void addToTheContainer(double amount) {
		super.addToTheContainer(amount);
		this.history.add(super.getVolume());
	}
	// Exercise 30.7: Product Container Recorder, Phase 2
	@Override
	public double takeFromTheContainer(double amount) {
		this.history.add(super.getVolume() - amount);
		return super.takeFromTheContainer(amount);
	}
	// Exercise 30.8: Product Container Recorder, Phase 3
	public void printAnalysis() {
		// prints the history information regarding the product
		System.out.println("Product: " + super.getName());
        System.out.println("History: " + this.history());
        System.out.println("Greatest product amount: " + this.history.maxValue());
        System.out.println("Smallest product amount: " + this.history.minValue());
        System.out.println("Average: " + this.history.average());
        System.out.println("Greatest change: " + this.history.greatestFluctuation());
        System.out.println("Variance: " + this.history.variance());
	}
}
