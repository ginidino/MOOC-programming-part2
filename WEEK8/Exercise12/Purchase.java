package Week08;

// Exercise 12: Online Shop
public class Purchase {
	private String product;
	private int amount;
	private int unitPrice;
	
	// Exercise 12.4: Purchase
	public Purchase(String product, int amount, int unitPrice) {
		// creates a purchase corresponding the parameter product. 
		// The product unit amount of purchase is clarified by the parameter amount, and the third parameter is the unit price
		this.product = product;
		this.amount = amount;
		this.unitPrice = unitPrice;
	}
	// Exercise 12.4: Purchase
	public int price() {
		// returns the purchase price. This is obtained by raising the unit amount by the unit price
		return this.amount * this.unitPrice;
	}
	// Exercise 12.4: Purchase
	public void increaseAmount() {
		// increases by one the purchase unit amount
		this.amount++;
		
	}
	// Exercise 12.4: Purchase
	public String toString() {
		return this.product + ": " + this.amount;
	}
}
