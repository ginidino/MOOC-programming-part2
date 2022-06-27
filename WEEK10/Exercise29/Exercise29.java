package Week10;

import java.util.ArrayList;
import java.util.List;
import people.Person;
import people.Student;
import people.Teacher;

// Exercise 29: Person and their Heirs
public class Exercise29 {
	public static void main(String[] args) {
		// Exercise 29.1: Person
        Person pekka = new Person("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa");
        Person esko = new Person("Esko Ukkonen", "Mannerheimintie Street 15 00100 Helsinki");
        System.out.println(pekka);
        System.out.println(esko);
        System.out.println();
        
        // Exercise 29.2: Student
        Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
        System.out.println(olli);
        System.out.println("credits " + olli.credits());
        olli.study();
        System.out.println("credits "+ olli.credits());
        System.out.println();
        
        // Exercise 29.3: toString for Studets
        Student ollis = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
        System.out.println(ollis);
        ollis.study();
        System.out.println(ollis);
        System.out.println();
        
        // Exercise 29.4: Teacher
        Teacher paul = new Teacher("Paul Mikkola", "Korsontie Street 1 03100 Vantaa", 1200);
        Teacher james = new Teacher("James Ukkonen", "Mannerheimintie 15 Street 00100 Helsinki", 5400);
        System.out.println(paul);
        System.out.println(james);

        Student david = new Student("David", "Ida Albergintie 1 Street 00400 Helsinki");
        for (int i = 0; i < 25; i++) {
            david.study();
        }
        System.out.println(david);
        System.out.println();
        
        // Exercise 29.5: Everyone in a List
        List<Person> people = new ArrayList<Person>();
        people.add( new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200) );
        people.add( new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki") );

        printDepartment(people);
    }
	// Exercise 29.5: Everyone in a List
	public static void printDepartment(List<Person> people) {
		for (Person person : people) {
			System.out.println(person);
		}
	}
}