package Week08;

// Exercise 13: Rich First, Poor Last
public class Person implements Comparable<Person> {
	private String name;
	private int salary;

	public Person(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return this.name;
	}

	public int getSalary() {
		return this.salary;
	}
	
	public String toString() {
        return name + " " + salary;
    }
	
	public int compareTo(Person person) {
		//return person.getSalary() - this.salary;
		
		if (this.salary == person.getSalary()) {
			return 0;
		} else if (this.salary > person.getSalary()) {
			return -1;
		} else {
			return 1;
		}
	}
}
