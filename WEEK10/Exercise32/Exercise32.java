package Week10;

import boxes.BlackHoleBox;
import boxes.MaxWeightBox;
import boxes.OneThingBox;
import boxes.Thing;

// Exercise 32: Different Boxes
public class Exercise32 {
	public static void main(String[] args) {
		// Exercise 32.2: Maximum Weight Box
		MaxWeightBox coffeeBox = new MaxWeightBox(10);
        coffeeBox.add(new Thing("Saludo", 5));
        coffeeBox.add(new Thing("Pirkka", 5));
        coffeeBox.add(new Thing("Kopi Luwak", 5));

        System.out.println(coffeeBox.isInTheBox(new Thing("Saludo")));
        System.out.println(coffeeBox.isInTheBox(new Thing("Pirkka")));
        System.out.println(coffeeBox.isInTheBox(new Thing("Kopi Luwak")));
        System.out.println();
        
        // Exercise 32.3: One-Thing Box and Black-Hole Box
        OneThingBox box = new OneThingBox();
        box.add(new Thing("Saludo", 5));
        box.add(new Thing("Pirkka", 5));

        System.out.println(box.isInTheBox(new Thing("Saludo")));
        System.out.println(box.isInTheBox(new Thing("Pirkka")));
        System.out.println();
        
        BlackHoleBox boxs = new BlackHoleBox();
        boxs.add(new Thing("Saludo", 5));
        boxs.add(new Thing("Pirkka", 5));

        System.out.println(boxs.isInTheBox(new Thing("Saludo")));
        System.out.println(boxs.isInTheBox(new Thing("Pirkka")));
	}
}
