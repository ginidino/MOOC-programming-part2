package farmsimulator;

import java.util.Collection;

public class Barn {
	private BulkTank tank;
	private MilkingRobot robot;
	

	public Barn(BulkTank bulkTank) {
		this.tank = bulkTank;
		this.robot = null;
	}
	
	public BulkTank getBulkTank() {
		// returns the barn's bulk tank
		return this.tank;
	}

	public void installMilkingRobot(MilkingRobot milkingRobot) {
		// installs a milking robot and connects it to the barn bulk tank
		this.robot = milkingRobot;
		this.robot.setBulkTank(this.tank);
	}

	public void takeCareOf(Cow cow) throws Exception {
		// milks the parameter cow with the help of the milking robot, 
		// the method throws an IllegalStateException if the milking robot hasn't been installed
		try {
            this.robot.milk(cow);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
	}

	public void takeCareOf(Collection<Cow> cows) throws Exception {
		// milks the parameter cows with the help of the milking robot, 
		// the method throws an IllegalStateException if the milking robot hasn't been installed
		for (Cow cow : cows) {
			takeCareOf(cow);
		}
	}
	
	@Override
    public String toString() {
        return this.tank.toString();
    }
}
