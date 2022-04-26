package TEST;

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
	}
}
