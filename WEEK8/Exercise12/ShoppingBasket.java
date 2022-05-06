package Week08;

import java.util.HashMap;
import java.util.Map;

//Exercise 12: Online Shop
public class ShoppingBasket {
	private Map<String, Purchase> basket;
	
	public ShoppingBasket() {
		this.basket = new HashMap<String, Purchase>();
	}
	//Exercise 12.5: Shopping Basket
	public void add(String product, int price) {
		// adds a purchase to the shopping basket; 
		// the purchase is defined by the parameter product, and its price is the second parameter
		/*Purchase purchase = new Purchase(product, 1, price);
		if (this.basket.containsKey(product)) {
			purchase = this.basket.get(product);
		} else {
			this.basket.put(product, purchase);
		}*/
		// Exercise 12.7: Only One Purchase Object for One Product
		if (this.basket.containsKey(product)) {
			this.basket.get(product).increaseAmount();
		} else {
			Purchase purchase = new Purchase(product, 1, price);
			this.basket.put(product, purchase);
		}
	}
	//Exercise 12.5: Shopping Basket
	public int price() {
		// returns the shopping basket total price
		int totalPrice = 0;
		for (String key : this.basket.keySet()) {
			Purchase purchase = basket.get(key);
			totalPrice += purchase.price();
		}
		return totalPrice;
	} 
	// Exercise 12.6: Printing out the Shopping Basket
	public void print() {
		for (String key : this.basket.keySet()) {
			System.out.println(this.basket.get(key));
		}
	}
}
