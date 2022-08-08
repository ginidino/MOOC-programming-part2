package personnel;

// Exercise 45: Enum and Iterator
// Exercise 45.2: Person
public class Person {
	private String name;
	private Education edu;

	public Person(String name, Education edu) {
		this.name = name;
		this.edu = edu;
	}
	
	public Education getEducation() {
		return this.edu;
	}
	
	public String toString() {
		return this.name + ", " + this.edu;
	}
}