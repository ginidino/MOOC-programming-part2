package Week08;

import java.util.Scanner;

// Exercise 12: Online Shop
// Exercise 12.8: Shop
public class Shop {
	private Storehouse store;
    private Scanner reader;

	public Shop(Storehouse store, Scanner scanner) {
		this.reader = new Scanner(System.in);
		this.store = store;
	}
	// the method to deal with a customer in the shop
	public void manage(String customer) {
		ShoppingBasket basket = new ShoppingBasket();
		System.out.println("Welcome to our shop " + customer);
        System.out.println("below is our sale offer: ");

        for (String product : store.products()) {
            System.out.println(product);
        }
        System.out.println();
        
        while (true) {
            System.out.print("what do you want to buy (press enter to pay): ");
            String product = reader.nextLine();
            if (product.isEmpty()) {
                break;
            }
            // here, you write the code to add a product to the shopping basket, if the storehouse is not empty
            // and decreases the storehouse stocks
            // do not touch the rest of the code!
            if (this.store.stock(product) > 0) {
            	this.store.take(product);
            	basket.add(product, this.store.price(product));
            }
        }
        System.out.println();
        
        System.out.println("your purchases are:");
        basket.print();
        System.out.println("basket price: " + basket.price());
	}
}
