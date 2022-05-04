package Week08;

// Exercise 11.1: ToBeStored
public class CD implements ToBeStored {
	private String artist;
	private String title;
	private int publishingYesr;
	private double weight;

	public CD(String artist, String title, int publishingYear) {
		this.artist = artist;
		this.title = title;
		this.publishingYesr = publishingYear;
		this.weight = 0.1;
	}
	
	public double weight() {
		return this.weight;
	}
	
	public String toString() {
		return this.artist + " : " + this.title + " (" + this.publishingYesr + ")";
	}
}
