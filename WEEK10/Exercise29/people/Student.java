package people;

// Exercise 29: Person and their Heirs
// Exercise 29.2: Student
public class Student extends Person {
	private int credits;

	public Student(String name, String address) {
		super(name, address);
		this.credits = 0;
	}

	public int credits() {
		return this.credits;
	}

	public void study() {
		this.credits++;
	}
	
	@Override
	public String toString() {	// Exercise 29.3: toString for Studets
		return super.toString() + "\n" + "  credits " + this.credits;
	}
}
