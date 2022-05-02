package TEST;

import java.util.ArrayList;
import java.util.HashMap;

public class bookTest {
	public static void main(String[] args) {
		Book book = new Book("Apple", 2008, "Romance");
		
		book.getName();
		book.publishingYear();
		book.genre();
		System.out.println(book);
		
		book.setName("Banana");
		book.setPublishingYear(2010);
		book.setGenre("thriller");
		System.out.println(book);
		System.out.println();
		
		Book objectBook = new Book("Object book", 2000);
		System.out.println(objectBook);
		System.out.println();
		
		Book anotherObjectBook = objectBook;
		
		if (objectBook.equals(objectBook)) {
		    System.out.println("The books were the same");
		} else {
		    System.out.println("The books were not the same");
		}

		// Now we create an object with the same contents, which is however a different, independent object
		anotherObjectBook = new Book("Objectbook", 2000);

		if (objectBook.equals(anotherObjectBook)) {
		    System.out.println("The books were the same");
		} else {
		    System.out.println("The books were not the same");
		}
		System.out.println();
		
		Book objectBooks = new Book("Objectbook", 2000);
		Book anotherObjectBooks = new Book("Objectbook", 2000);

		if (objectBooks.equals(anotherObjectBooks)) {
		    System.out.println("The books are the same");
		} else {
		    System.out.println("The books are not the same");
		}
		System.out.println();
		
		// Equals and ArrayList
		ArrayList<Book> books = new ArrayList<Book>();
		Book ObjectBook = new Book("Objectbook", 2000);
		books.add(ObjectBook);
		
		if (books.contains(ObjectBook)) {
			System.out.println("The object book was found.");
		}
		
		ObjectBook = new Book("Objectbook", 2000);
		
		if (!books.contains(ObjectBook)) {
		    System.out.println("The object book was not found.");
		}
		System.out.println();
		
		// HashCode Method
		HashMap<Book, String> loaners = new HashMap<Book, String>();

        Book objectbook = new Book("Objectbook", 2000);
        loaners.put(objectbook, "Pekka");
        loaners.put(new Book("Test Driven Development",1999), "Arto");

        System.out.println(loaners.get(objectbook));
        System.out.println(loaners.get(new Book("Objectbook", 2000)));
        System.out.println(loaners.get(new Book("Test Driven Development", 1999)));
	}
}
