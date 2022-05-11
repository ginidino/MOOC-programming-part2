package Week08;

// Exercise 14: Students Sorted by Name
// You find the pre-made class Student. Students have got a name. 
// Make Student implement the COmparable interface, so that the compareTo method would sort the students in alphabetic order.
public class Exercise14 {
	public static void main(String[] args) {
		Student student1 = new Student("Anthoy");
		Student student2 = new Student("Paul");
		System.out.println(student1.compareTo(student2));
	}
}
