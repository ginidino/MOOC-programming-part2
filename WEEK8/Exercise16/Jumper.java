package Week08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// Exercise 16: Ski Jumping
public class Jumper {
	private ArrayList<Skier> skiers;
	private Random random;
	
	public Jumper() {
		this.skiers = new ArrayList<Skier>();
		this.random = new Random();
	}
	
	public boolean emptyString(String empty) {
		if (empty.equals("")) {
			return false;
		}
		return true;
	}
	
	public boolean toJump(String jump) {
		if (jump.equals("jump")) {
			return true;
		}
		return false;
	}
	
	public void addName(String name) {
		Skier newSkier = new Skier(name);
		this.skiers.add(newSkier);
	}
	
	public ArrayList<Skier> getSkier() {
		return this.skiers;
	}
	
	public void sortSkiers() {
		Collections.sort(this.skiers);
	}
	
	public void sortSkiersDown() {
		Collections.reverse(this.skiers);
	}
	
	public int getNewJump() {
		int newJump = this.random.nextInt(60) + 61; // random number between 60 and 120
		return newJump;
	}
	
	public int getNewJudge() {
		int newJudge = this.random.nextInt(10) + 11;  // random number between 10 and 20
		return newJudge;
	}
	
	public ArrayList<Integer> getFiveJudge() {
		ArrayList<Integer> fiveJudge = new ArrayList<Integer>();
		
		for (int i = 0; i < 5; i++) {
			int newJudge = this.getNewJudge();
			fiveJudge.add(newJudge);
		}
		return fiveJudge;
	}
	
	public ArrayList<Integer> removeLargestAndSmallest(ArrayList<Integer> fiveJudge) {
		Collections.sort(fiveJudge);
		
		fiveJudge.remove(0);
		fiveJudge.remove(fiveJudge.size() - 1);
		
		return fiveJudge;
	}
}
