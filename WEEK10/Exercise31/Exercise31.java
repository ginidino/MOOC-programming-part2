package Week10;

import java.util.LinkedList;

import farmsimulator.Alive;
import farmsimulator.Barn;
import farmsimulator.BulkTank;
import farmsimulator.Cow;
import farmsimulator.Farm;
import farmsimulator.Milkable;
import farmsimulator.MilkingRobot;

// Exercise 31: Farm Simulator
public class Exercise31 {
	public static void main(String[] args) throws Exception {
		// Exercise 31.1: Bulk Tank
		BulkTank tank = new BulkTank();
		tank.getFromTank(100);
		tank.addToTank(25);
		tank.getFromTank(5);
		System.out.println(tank);

		tank = new BulkTank(50);
		tank.addToTank(100);
		System.out.println(tank);
		System.out.println();
		
		// Exercise 31.2: Cow
		Cow cow = new Cow();
		System.out.println(cow);

		Alive livingCow = cow;
		livingCow.liveHour();
		livingCow.liveHour();
		livingCow.liveHour();
		livingCow.liveHour();

		System.out.println(cow);

		Milkable milkingCow = cow;
		milkingCow.milk();

		System.out.println(cow);
		System.out.println("");

		cow = new Cow("Ammu");
		System.out.println(cow);
		cow.liveHour();
		cow.liveHour();
		System.out.println(cow);
		cow.milk();
		System.out.println(cow);
		System.out.println();
		
		// Exercise 31.3: MilkingRobot
		MilkingRobot milkingRobot = new MilkingRobot();
        Cow cows = new Cow();
		System.out.println("");

		BulkTank tanks = new BulkTank();
		milkingRobot.setBulkTank(tanks);
		System.out.println("Bulk tank: " + tanks);

		for(int i = 0; i < 2; i++) {
		    System.out.println(cows);
		    System.out.println("Living..");
		    for(int j = 0; j < 5; j++) {
		        cows.liveHour();
		    }
		    System.out.println(cows);

		    System.out.println("Milking...");
		    milkingRobot.milk(cows);
		    System.out.println("Bulk tank: " + tanks);
		    System.out.println("");
		}
		
		// Exercise 31.4: Barn
		Barn barn = new Barn(new BulkTank());
		System.out.println("Barn: " + barn);

		MilkingRobot robot = new MilkingRobot();
		barn.installMilkingRobot(robot);

		Cow ammu = new Cow();
		ammu.liveHour();
		ammu.liveHour();

		barn.takeCareOf(ammu);
		System.out.println("Barn: " + barn);

		LinkedList<Cow> cowList = new LinkedList<Cow>();
		cowList.add(ammu);
		cowList.add(new Cow());

		for(Cow c: cowList) {
		    c.liveHour();
		    c.liveHour();
		}

		barn.takeCareOf(cowList);
		System.out.println("Barn: " + barn);
		System.out.println();
		
		// Exercise 31.5: Farm
		Farm farm = new Farm("Esko", new Barn(new BulkTank()));
		MilkingRobot robots = new MilkingRobot();
		farm.installMilkingRobot(robots);

		farm.addCow(new Cow());
		farm.addCow(new Cow());
		farm.addCow(new Cow());


		farm.liveHour();
		farm.liveHour();

		farm.manageCows();

		System.out.println(farm);
	}
}
