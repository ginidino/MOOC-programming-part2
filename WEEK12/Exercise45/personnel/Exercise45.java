package personnel;

// Exercise 45: Enum and Iterator
public class Exercise45 {
	public static void main(String[] args) {
		// Exercise 45.2: Person
		Person arto = new Person("Arto", Education.D);
	    System.out.println(arto);
	    System.out.println();
	    
	    // Exercise 45.3: Employees & Exercise 45.4: Firing
	    Employees university = new Employees();
        university.add(new Person("Matti", Education.D));
        university.add(new Person("Pekka", Education.GRAD));
        university.add(new Person("Arto", Education.D));

        university.print();

        university.fire(Education.GRAD);

        System.out.println("==");

        university.print();
	}
}