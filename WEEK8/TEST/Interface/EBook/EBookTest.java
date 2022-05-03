package TEST;

import java.util.ArrayList;

// Interface
public class EBookTest {
	public static void main(String[] args) {
		SMS message = new SMS("ope", "Awesome stuff!");
		System.out.println(message.read());
		
	    ArrayList<SMS> messages = new ArrayList<SMS>();
	    messages.add(new SMS("unknown number", "I hid the body."));
	    
	    ArrayList<String> pages = new ArrayList<String>();
	    pages.add("Split your method into short clear chunks.");
	    pages.add("Devide the user interface logic from the application logic.");
	    pages.add("At first, always code only a small program which solves only a part of the problem.");
	    pages.add("Practice makes perfect. Make up your own fun project.");
	    System.out.println();
	    
	    EBook book = new EBook("Programming Hints.", pages);
	    for(int page = 0; page < book.howManyPages(); page++) {
	        System.out.println(book.read());
	    }
		System.out.println();
		
	    SMS messagess = new SMS("teacher", "Awesome stuff!");
	    Readable readable = new SMS("teacher", "The SMS is Readable!");
	    
	    ArrayList<String> paged = new ArrayList<String>();
	    paged.add("A method can call itself.");

	    Readable books = new EBook("Recursion Principles", paged);
	    for(int page = 0; page < ((EBook)book).howManyPages(); page++) {
	        System.out.println(book.read());
	    }
	    System.out.println();
	    
	    ArrayList<Readable> numberList = new ArrayList<Readable>();

	    numberList.add(new SMS("teacher", "never been programming before..."));
	    numberList.add(new SMS("teacher", "gonna love it i think!"));
	    numberList.add(new SMS("teacher", "give me something more challenging! :)"));
	    numberList.add(new SMS("teacher", "you think i can do it?"));
	    numberList.add(new SMS("teacher", "up here we send several messages each day"));

	    for (Readable readables: numberList) {
	        System.out.println(readables.read());
	    }
	    System.out.println();
	    
	    SMS messaged = new SMS("teacher", "Wow, this printer is able to print them, actually!");
	    ArrayList<String> Pages = new ArrayList<String>();
	    Pages.add("{3, 5} are the numbers in common between {1, 3, 5} and {2, 3, 4, 5}.");

	    EBook ebook = new EBook("Introduction to University Mathematics.", Pages);

	    Printer printer = new Printer();
	    printer.print(messaged);
	    printer.print(ebook);
	}
}
