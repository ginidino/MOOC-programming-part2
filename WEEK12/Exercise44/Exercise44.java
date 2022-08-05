package Week12;

import java.util.Scanner;

// Exercise 44: Regular Expressions
public class Exercise44 {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		// Exercise 44.1: Week Days
		System.out.print("Give a string: ");
		String word = reader.nextLine();
		
		if (isAWeekDay(word)) {
			System.out.println("The form is fine.");
		} else {
			System.out.println("The form is wrong.");
		}
		System.out.println();
		
		// Exercise 44.2: Vowel Inspection
		System.out.print("Give a string: ");
		String given = reader.nextLine();
		if (allVowels(given)) {
			System.out.println("The form is fine.");
		} else {
			System.out.println("The form is wrong.");
		}
		System.out.println();
		
		// Exercise 44.3: Clock Time
		System.out.print("Give a string: ");
		String time = reader.nextLine();
		if (clockTime(time)) {
			System.out.println("The form is fine.");
		} else {
			System.out.println("The form is wrong.");
		}
	}
	// Exercise 44.1: Week Days
	public static boolean isAWeekDay(String string) {
		return string.matches("mon|tue|wed|thu|fri|sat|sun");
	}
	// Exercise 44.2: Vowel Inspection
	public static boolean allVowels(String string) {
		return string.matches("[aeiou]*");
	}
	// Exercise 44.3: Clock Time
	public static boolean clockTime(String string) {
		try {
			String hours = string.substring(0, 2);
			int clock = Integer.parseInt(hours);
			if (clock < 24) {
				return string.matches("[0-2][0-9]:[0-5]{1}[0-9]{1}:[0-5]{1}[0-9]{1}");
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
