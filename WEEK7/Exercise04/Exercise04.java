package Week7;

// Exercise 4: Thing, Suitcase, and Container
public class Exercise04 {
	public static void main(String[] args) {
		// Exercise 4.1: Class Thing
		Thing book = new Thing("Happiness in Three Steps", 2);
        Thing mobile = new Thing("Nokia 3210", 1);
        // Exercise 4.2: Class Suitcase
        Thing brick = new Thing("Brick", 4);
        
        // Exercise 4.1: Class Thing
        System.out.println("Book name: " + book.getName());
        System.out.println("Book weight: " + book.getWeight());

        System.out.println("Book: " + book);
        System.out.println("Mobile: " + mobile);
        System.out.println();
        
        // Exercise 4.2: Class Suitcase
        Suitcase suitcase = new Suitcase(5);
        System.out.println(suitcase);

        suitcase.addThing(book);
        System.out.println(suitcase);

        suitcase.addThing(mobile);
        System.out.println(suitcase);

        suitcase.addThing(brick);
        System.out.println(suitcase);
        System.out.println();
        
        // Exercise 4.4: Every Thing
        Suitcase suitcases = new Suitcase(10);
        suitcases.addThing(book);
        suitcases.addThing(mobile);
        suitcases.addThing(brick);

        System.out.println("Your suitcase contains the following things:");
        suitcases.printThings();
        System.out.println("Total weight: " + suitcases.totalWeight() + " kg");
        System.out.println();
        
        // Exercise 4.5: The heaviest Thing
        Thing heaviest = suitcases.heaviestThing();
        System.out.println("The heaviest thing: " + heaviest);
        System.out.println();
        
        // Exercise 4.6: Container
        Suitcase tomsCase = new Suitcase(10);
        tomsCase.addThing(book);
        tomsCase.addThing(mobile);

        Suitcase georgesCase = new Suitcase(10);
        georgesCase.addThing(brick);

        Container container = new Container(1000);
        container.addSuitcase(tomsCase);
        container.addSuitcase(georgesCase);

        System.out.println(container);
        System.out.println();
        
        // Exercise 4.7: The Container Contents
        System.out.println("There are the following things in the container suitcases:");
        container.printThings();
        System.out.println();
        
        //Exercise 4.8: A Lot of Bricks
        Container containers = new Container(1000);
        addSuitcasesFullOfBricks(containers);
        System.out.println(containers);
	}
	//Exercise 4.8: A Lot of Bricks
	public static void addSuitcasesFullOfBricks(Container containers) {
        // adding 100 suitcases with one brick in each
		for (int i = 1; i <= 100; i++) {
			Thing brick = new Thing("Brick", i);
			Suitcase brickCase = new Suitcase(i + 1);
			
			brickCase.addThing(brick);
			containers.addSuitcase(brickCase);
		}
	}
}
