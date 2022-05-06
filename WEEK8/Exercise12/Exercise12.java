package Week08;

import java.util.Scanner;

// Exercise 12: Online Shop
public class Exercise12 {
	public static void main(String[] args) {
		// Exercise 12.1: Storehouse
		Storehouse store = new Storehouse();
        store.addProduct("milk", 3, 10);
        store.addProduct("coffee", 5, 7);

        System.out.println("prices:");
        System.out.println("milk: " + store.price("milk"));
        System.out.println("coffee: " + store.price("coffee"));
        System.out.println("sugar: " + store.price("sugar"));
        System.out.println();
        
        // Exercise 12.2: Product Stock
        store.addProduct("coffee", 5, 1);

        System.out.println("stocks:");
        System.out.println("coffee: " + store.stock("coffee"));
        System.out.println("sugar: " + store.stock("sugar"));

        System.out.println("we take a coffee " + store.take("coffee"));
        System.out.println("we take a coffee " + store.take("coffee"));
        System.out.println("we take sugar " + store.take("sugar"));

        System.out.println("stocks:");
        System.out.println("coffee: " + store.stock("coffee"));
        System.out.println("sugar: " + store.stock("sugar"));
        System.out.println();
        
        // Exercise 12.3: Listing the Products
        store.addProduct("milk", 3, 10);
        store.addProduct("coffee", 5, 6);
        store.addProduct("buttermilk", 2, 20);
        store.addProduct("jogurt", 2, 20);

        System.out.println("products:");
        for (String product : store.products()) {
            System.out.println(product);
        }
        System.out.println();
        
        // Exercise 12.4: Purchase
        Purchase purchase = new Purchase("milk", 4, 2);
        System.out.println("the total price of a purchase containing four milks is " + purchase.price());
        System.out.println(purchase);
        purchase.increaseAmount();
        System.out.println(purchase);
        System.out.println();
        
        //Exercise 12.5: Shopping Basket
        ShoppingBasket basket = new ShoppingBasket();
        basket.add("milk", 3);
        basket.add("buttermilk", 2);
        basket.add("cheese", 5);
        System.out.println("basket price: " + basket.price());
        basket.add("computer", 899);
        System.out.println("basket price: " + basket.price());
        System.out.println();
        
        // Exercise 12.6: Printing out the Shopping Basket
        basket.print();
        System.out.println();
        
        // Exercise 12.7: Only One Purchase Object for One Product
        ShoppingBasket baskets = new ShoppingBasket();
        baskets.add("milk", 3);
        baskets.print();
        System.out.println("basket price: " + baskets.price() +"\n");

        baskets.add("buttermilk", 2);
        baskets.print();
        System.out.println("basket price: " + baskets.price() +"\n");

        baskets.add("milk", 3);
        baskets.print();
        System.out.println("basket price: " + baskets.price() +"\n");

        baskets.add("milk", 3);
        baskets.print();
        System.out.println("basket price: " + baskets.price() +"\n");
        System.out.println();
        
        // Exercise 12.8: Shop
        Storehouse stores = new Storehouse();
        stores.addProduct("coffee", 5, 10);
        stores.addProduct("milk", 3, 20);
        stores.addProduct("milkbutter", 2, 55);
        stores.addProduct("bread", 7, 8);

        Shop shop = new Shop(store, new Scanner(System.in));
        shop.manage("Apple");
	}
}
