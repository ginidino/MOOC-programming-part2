package Week08;

import java.util.Scanner;

// Exercise 16: Ski Jumping
public class Exercise16 {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		//String name = reader.nextLine();
		
		Jumper jumper = new Jumper();
		//Skier skier = new Skier();
		
		skiJumpingUI uiSkiJumping = new skiJumpingUI(jumper, reader);
		uiSkiJumping.start();
	}
}
