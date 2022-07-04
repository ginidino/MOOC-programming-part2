package farmsimulator;

import java.util.ArrayList;
import java.util.List;

public class Farm implements Alive {
	private String owner;
	private Barn barn;
	private List<Cow> animals;

	public Farm(String owner, Barn ownerBarn) {
		this.owner = owner;
		this.barn = ownerBarn;
		this.animals = new ArrayList<Cow>();
	}
	
	public String getName() {
		return this.owner;
	}

	public void installMilkingRobot(MilkingRobot robot) {
		this.barn.installMilkingRobot(robot);
		
	}

	public void addCow(Cow cow) {
		this.animals.add(cow);
	}

	public void manageCows() throws Exception {
		this.barn.takeCareOf(animals);
		
	}
	
	@Override
	public void liveHour() {
		for (Cow cow : this.animals) {
			cow.liveHour();
		}
	}
	
	@Override
	public String toString() {
		String title = "Farm owner: " + this.owner + "\n"
                + "Barn bulk tank: " + this.barn.toString() + "\n"
                + "Animals:" + "\n";
		for (Cow cow : this.animals) {
			title += "        " + cow.toString() + "\n";
		}
		return title;
	}
}
