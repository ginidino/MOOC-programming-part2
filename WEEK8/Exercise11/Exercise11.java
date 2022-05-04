package Week08;

// Exercise 11: Boxes and Things
public class Exercise11 {
	public static void main(String[] args) {
		// Exercise 11.1: ToBeStored
		Book book1 = new Book("Fedor Dostojevski", "Crime and Punishment", 2);
        Book book2 = new Book("Robert Martin", "Clean Code", 1);
        Book book3 = new Book("Kent Beck", "Test Driven Development", 0.5);

        CD cd1 = new CD("Pink Floyd", "Dark Side of the Moon", 1973);
        CD cd2 = new CD("Wigwam", "Nuclear Nightclub", 1975);
        CD cd3 = new CD("Rendezvous Park", "Closer to Being Here", 2012);

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(cd1);
        System.out.println(cd2);
        System.out.println(cd3);
        System.out.println();
        
        // Exercise 11.2: Box
        Box box = new Box(10);

        box.add(new Book("Fedor Dostojevski", "Crime and Punishment", 2)) ;
        box.add(new Book("Robert Martin", "Clean Code", 1));
        box.add(new Book("Kent Beck", "Test Driven Development", 0.7));

        box.add(new CD("Pink Floyd", "Dark Side of the Moon", 1973));
        box.add(new CD("Wigwam", "Nuclear Nightclub", 1975));
        box.add(new CD("Rendezvous Park", "Closer to Being Here", 2012));

        System.out.println(box);
        System.out.println();
        
        // Exercise 11.4: Boxes are Stored too!
        Box smallBox = new Box(10);
        Box bigBox = new Box(20);
        
        smallBox.add(box);
        smallBox.add(new Book("My New Book", "Book about new things", 4));
        bigBox.add(smallBox);
        System.out.println(bigBox);
	}
}
