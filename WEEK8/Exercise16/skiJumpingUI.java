package Week08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Exercise 16: Ski Jumping
public class skiJumpingUI {
	private Jumper jumper;
	private Scanner reader;
	//private Skier skier;

	public skiJumpingUI(Jumper jumper, Scanner reader) {
		this.reader = new Scanner(System.in);
		this.jumper = jumper;
		//this.skier = skier;
	}

	public void start() {
		System.out.println("Pyeongchang ski jumping week \n");
		System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
		
		while (true) {
			System.out.print("  Participant name: ");
			String name = this.reader.nextLine();
			
			if (this.jumper.emptyString(name) == false) { // check if string is empty
				break;
			}
			this.jumper.addName(name);
		}
		System.out.println();
		System.out.println("The tournament begins!");
        System.out.println();
        
        rounds();
        
        printResults();
	}

	public void rounds() {
		int round = 1;
		
		while(true) {
			System.out.print("Write \"jump\" to jump; otherwise you quit: ");
			String jump = this.reader.nextLine();
			System.out.println();
			
			if (this.jumper.toJump(jump) == false) { // to jump or not to jump, that is the question
				break;
			}
			
			System.out.println("Round " + round); 	// what round are we on?
            System.out.println();
            
            jumpingOrder(); 						// determine jumping order
            System.out.println();
            
            roundResults(round);					// get round results printed and skier points added
            System.out.println();
            
            round++;
		}
	}
	
	public void jumpingOrder() {
		System.out.println("Jumping order:");
		
		this.jumper.sortSkiers();
		
		int counter = 1;
		for (Skier skier : this.jumper.getSkier()) {
			System.out.print("  " + counter + ". ");
			System.out.println(skier);
			counter++;
		}
	}

	public void roundResults(int round) {
		System.out.println("Results of round " + round);
		
		for (Skier skier : this.jumper.getSkier()) {
			System.out.println("  " + skier.getName());
			
			int newJump = this.jumper.getNewJump(); 	// get new jump length
			skier.addJump(newJump);						// add jump to list of jumps
			
			System.out.println("    length: " + newJump);
			int addPoints = printJudges(newJump);		// print judges and get points to add to skier total
			System.out.println();
			
			skier.addPoint(addPoints);					// add these points to skier's total
		}
	}

	public int printJudges(int jumpLength) {
		System.out.print("    judge votes: [");
		ArrayList<Integer> judgeVote = this.jumper.getFiveJudge();
		int count = 0;
		for (int judge : judgeVote) {
			System.out.print(judge);
			
			if (count < 4) {
				System.out.print(", ");
			} else {
				System.out.print("]");
			}
			count++;
		}
		
		int addPoints = addPoints(judgeVote, jumpLength);     // add these judge points and jump length to total points for this skier
		return addPoints;
	}

	public int addPoints(ArrayList<Integer> fiveJudge, int jumpLength) {
		ArrayList<Integer> threeJudge = this.jumper.removeLargestAndSmallest(fiveJudge);
		
		int addPoints = jumpLength;
		
		for (int judge : threeJudge) {
			addPoints += judge;
		}
		return addPoints;
	}

	public void printResults() {
		System.out.println("Thanks!");
		System.out.println();
		
		System.out.println("Tournament results:");
		System.out.println("Position    Name");
		
		int count = 1;		// count which skier we are on
		
		Collections.sort(this.jumper.getSkier());		// sort points lowest to highest
		Collections.reverse(this.jumper.getSkier());	// reverse order to from highest to lowest
		
		for (Skier skier : this.jumper.getSkier()) {
			System.out.println(count + "           " + skier);
            System.out.print("            jump lengths: ");
            
            int jumpCount = 0;
            
            for (int jump : skier.getJumps()) {
            	System.out.print(jump); 				// print each jump length
            	
            	if (jumpCount < skier.getJumps().size() - 1) {
            		System.out.print(" m, ");			// add "m" and comma if the line is not finished
            	} else {
            		System.out.println(" m");			// finish the line with an "m" but no comma, if this is the last jump
            	}
            	jumpCount++;
            }
            count++;
		}
	}
}
