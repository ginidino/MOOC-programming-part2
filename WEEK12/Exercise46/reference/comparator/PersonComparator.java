package reference.comparator;

import java.util.Comparator;
import java.util.Map;
import reference.domain.Person;

// Exercise 46.5: PersonComparator
public class PersonComparator implements Comparator<Person> {
	private Map<Person, Integer> people;
	
	public PersonComparator(Map<Person, Integer> peopleIdentities) {
		this.people = peopleIdentities;
	}

	@Override
	public int compare(Person o1, Person o2) {
		if (this.people.get(o1) == this.people.get(o2)) {
			return 0;
		} else if (this.people.get(o1) > this.people.get(o2)) {
			return -1;
		} else {
			return 1;
		}
	}
}