package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Exercise 45: Enum and Iterator
// Exercise 45.3: Employees
public class Employees {
	private List<Person> list;
	private Iterator<Person> iterator;
	
	public Employees() {
		this.list = new ArrayList<Person>();
	}

	public void add(Person person) {
		this.list.add(person);
	}
	
	public void add(List<Person> persons) {
		for (Person person : persons) {
			this.list.add(person);
		}
	}
	
	public void print() {
		this.iterator = this.list.iterator();
		
		while(this.iterator.hasNext()){
            		Person nextPerson = this.iterator.next();
            		System.out.println(nextPerson);
        	}
	}
	
	public void print(Education education) {
		this.iterator = this.list.iterator();
		
		while (this.iterator.hasNext()) {
			Person nextPerson = this.iterator.next();
			
			if (nextPerson.getEducation() == education) {
				System.out.println(nextPerson);
			}
		}
	}
	// Exercise 45.4: Firing
	public void fire(Education education) {
		this.iterator = this.list.iterator();
		
		while (this.iterator.hasNext()) {
			if (this.iterator.next().getEducation() == education) {
				this.iterator.remove();
			}
		}
	}
}
