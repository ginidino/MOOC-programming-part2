package library;

import library.domain.Book;

public class Implementation {
	public static void main(String[] args) {
		Book book = new Book("The ABC of Packages!");
		System.out.println("Hello packageworld: " + book.getName());
	}
}
