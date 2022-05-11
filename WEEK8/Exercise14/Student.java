package Week08;

// Exercise 14: Students Sorted by Name
public class Student implements Comparable<Student> {
	private String name;
	
	public Student(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return this.name;
	}
	
    public int compareTo(Student other){
        return this.getName().compareToIgnoreCase(other.getName());

    }
}
