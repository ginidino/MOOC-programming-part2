package Week10;

import movable.Group;
import movable.Organism;

// Exercise 28: Groups
public class Exercise28 {
	public static void main(String[] args) {
		// Exercise 28.1: Implementing Organism
		Organism organism = new Organism(20, 30);
	    System.out.println(organism);
	    organism.move(-10, 5);
	    System.out.println(organism);
	    organism.move(50, 20);
	    System.out.println(organism);
	    System.out.println();
	    
	    // Exercise 28.2: Implementing Group
	    Group group = new Group();
	    group.addToGroup(new Organism(73, 56));
	    group.addToGroup(new Organism(57, 66));
	    group.addToGroup(new Organism(46, 52));
	    group.addToGroup(new Organism(19, 107));
	    System.out.println(group);
	}
}
