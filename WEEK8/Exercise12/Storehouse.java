package Week08;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Exercise 12: Online Shop

public class Storehouse {
	private Map<String, Integer> prodPrice; // Exercise 12.1: Storehouse
	private Map<String, Integer> prodStock; // Exercise 12.2: Product Stock
	
	public Storehouse() {
		this.prodPrice = new HashMap<String, Integer>();
		this.prodStock = new HashMap<String, Integer>();
	}

	public void addProduct(String product, int price, int stock) {
		// adding to the storehouse a product whose price and number of stocks are the parameter values
		this.prodPrice.put(product, price); // Exercise 12.1: Storehouse
		this.prodStock.put(product, stock); // Exercise 12.2: Product Stock
		
	}
	// Exercise 12.1: Storehouse
	public int price(String product) {
		// returns the price of the parameter product; 
		// if the product is not available in the storehouse, the method returns -99
		if (this.prodPrice.containsKey(product)) {
			return this.prodPrice.get(product);
		} else {
			return -99;
		}
	}
	// Exercise 12.2: Product Stock
	public int stock(String product) {
		// returns the stock of the parameter product
		if (this.prodStock.containsKey(product)) {
			return this.prodStock.get(product);
		}
		return 0;
	}
	// Exercise 12.2: Product Stock
	public boolean take(String product) {
		// decreases the stock of the parameter product by one,
		// and it returns true if the object was available in the storehouse. 
		// If the product was not in the storehouse, the method returns false, the product stock cannot go below zero
		if (this.prodStock.containsKey(product)) {
			if (this.prodStock.get(product) > 0) {
				this.prodStock.put(product, this.prodStock.get(product) - 1);
				return true;
			}
		}
		return false;
	}
	// Exercise 12.3: Listing the Products
	public Set<String> products() {
		// returns a name set of the products contained in the storehouse
		Set<String> set = new HashSet<String>();
		for (String key : this.prodPrice.keySet()) {
			set.add(key);
		}
		return set;
	}
}
