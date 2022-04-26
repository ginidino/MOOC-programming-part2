package TEST;

public class Book {
	private String name;
	private int publishingYear;
	private String genre;

	public Book(String name, int publishingYear, String genre) {
		this.name = name;
		this.publishingYear = publishingYear;
		this.genre = genre;
	}

	public String getName() {
		return this.name;
	}

	public int publishingYear() {
		return this.publishingYear;
	}

	public String genre() {
		return this.genre;
	}
	
	public String toString() {
        return "Name: " + this.name + " (" + this.publishingYear + ")\n" + "Genre: " + this.genre;
    	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPublishingYear(int publishingYear) {
		this.publishingYear = publishingYear;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
