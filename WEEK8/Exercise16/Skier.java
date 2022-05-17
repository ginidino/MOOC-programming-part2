package Week08;

import java.util.ArrayList;

// Exercise 16: Ski Jumping
public class Skier implements Comparable <Skier>{
	private ArrayList<Integer> jumps;
	private String name;
	private int point;
	
	public Skier(String name) {
		this.jumps = new ArrayList<Integer>();
		this.name = name;
		this.point = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPoint() {
		return this.point;
	}
	
	public void addPoint(int newPoint) {
		this.point += newPoint;
	}
	
	public void addJump(int jump) {
		this.jumps.add(jump);
	}
	
	public ArrayList<Integer> getJumps() {
		return this.jumps;
	}
	
	public String toString() {
		return this.name + " (" + this.point + " points)";
	}
	
	@Override
	public int compareTo(Skier skier) {
		return this.point - skier.getPoint();
	}
}
