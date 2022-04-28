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
	
	public Book(String name, int publishingYear) {
		this.name = name;
		this.publishingYear = publishingYear;
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
	
	/*public String toString() {
        return "Name: " + this.name + " (" + this.publishingYear + ")\n" + "Genre: " + this.genre;
    }*/
	
	public String toString() {
        return this.name + " (" + this.publishingYear + ")";
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
	
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		if (this.getClass() != object.getClass()) {
			return false;
		}
		
		Book compared = (Book) object;
		
		if (this.publishingYear != compared.publishingYear) {
			return false;
		}
		if (this.name == null || !this.name.equals(compared.getName())) {
            return false;
        }
		return true;
	}
	
	public int hashCode() {
		if (this.name == null) {
			return 7;
		}
		return this.publishingYear + this.name.hashCode();
	}
}
