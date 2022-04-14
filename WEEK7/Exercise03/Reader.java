package Week7;

import java.util.Scanner;

// Exercise 3.1: Reader
public class Reader {
	private Scanner reader;
	
	public Reader() {
		this.reader = new Scanner(System.in);
	}
	// Exercise 3.1: Reader
	public String readString() {
		return this.reader.nextLine();	
	}
	// Exercise 3.1: Reader
	public int readInteger() {
		return Integer.parseInt(reader.nextLine());	
	}
}
