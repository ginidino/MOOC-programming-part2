package Week7;

import java.util.HashMap;

// Exercise 8: Airport
public class Airplane {
	private HashMap<String, Integer> plane;
	private String planeID;
	//private int capacity;

	public Airplane() {
		this.plane = new HashMap<String, Integer>();
	}
	
	public void add(String planeID, int capacity) {
		this.planeID = planeID;
		this.plane.put(planeID, capacity);
	}
	
	public String get(String planeID) {
		return planeID + "(" + plane.get(planeID) + " ppl)";
	}
	
	public void printPlane() {
		for (String pID : plane.keySet()) {
			System.out.println(pID + " (" + plane.get(pID) + " ppl)");
		}
	}
}
