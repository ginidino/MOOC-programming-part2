package Week08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Exercise 13: Rich First, Poor Last
// You find the pre-made class Person. People have got name and salary information. 
// Make Person implement the Comparable interface, 
// so that the compareTo method would sort the people according to their salary -- rich first, poor last.
public class Exercise13 {
	public static void main(String[] args) {
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Paul", 150000));
        people.add(new Person("David", 3000));
        people.add(new Person("Anthony", 300));
        people.add(new Person("Erik", 10));
        people.add(new Person("Tom", 500));
        people.add(new Person("Harry", 80));
        
        System.out.println(people);
        
        Collections.sort(people);
        System.out.println(people);
	}
}
