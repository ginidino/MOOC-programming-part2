package containers;

// Exercise 30: Container
public class ProductContainer extends Container {
	private String productName;

	// Exercise 30.1: Product Container, Phase 1
	public ProductContainer(String productName, double capacity) {		
		// creates an empty product container. The product name and the container capacity are given as parameters
		super(capacity);
		this.productName = productName;
	}
	// Exercise 30.1: Product Container, Phase 1
	public String getName() {
		return this.productName;
	}
	// Exercise 30.2: Product Container, Phase 2
	public void setName(String newName) {
		// sets a new name to the product
		this.productName = newName;
	}
	// Exercise 30.2: Product Container, Phase 2
	public String toString() {
		return  this.productName + ": " + super.toString();
	}
}
