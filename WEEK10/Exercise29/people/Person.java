package people;

// Exercise 29: Person and their Heirs
// Exercise 29.1: Person
public class Person {
	private String name;
	private String address;

	public Person(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public String toString() {
		return this.name + "\n" + " " + this.address;
	}
}
