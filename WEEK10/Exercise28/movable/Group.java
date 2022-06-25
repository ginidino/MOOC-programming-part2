package movable;

import java.util.ArrayList;
import java.util.List;

// Exercise 28: Groups
// Exercise 28.2: Implementing Group
public class Group implements Movable {
	private List<Movable> groups;
	
	public Group() {
		this.groups = new ArrayList<Movable>();
	}

	public void addToGroup(Movable movable) {
		// it adds a new objects which implements the interface Movable to the group
		this.groups.add(movable);
	}
	
	@Override
	public String toString() {
		// returns a string which describes the position of the group organisms, each organism is printed in its own line
		String list = "";
		for (Movable move : this.groups) {
			list += move.toString() + "\n";
		}
		return list;
	}
	
	@Override
	public void move(int dx, int dy) {
		// it moves a group as much as it is defined by the arguments. Note that you will have to move each group organism
		for (Movable move : this.groups) {
			move.move(dx, dy);
		}
	}
}
