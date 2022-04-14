package TEST;

import java.util.Scanner;

public class Calculator {
	private Scanner reader;
	private int count;
	
	public Calculator() {
		this.reader = new Scanner(System.in);
	}
	// Exercise 3.2: Application body
	public void start() {
		while (true) {
            System.out.print("command: ");
            String command = reader.nextLine();
            
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
                System.out.println();
            } else if (command.equals("difference")) {
                difference();
                System.out.println();
            } else if (command.equals("product")) {
                product();
                System.out.println();
            }
        }
        statistics();
	}
	// Exercise 3.2: Application body
	private void sum() {
		// Exercise 3.3: Implementation of the application logic
		System.out.print("value1: ");
		int value1 = Integer.parseInt(this.reader.nextLine());
		System.out.print("value2: ");
		int value2 = Integer.parseInt(this.reader.nextLine());
		
		int sum = value1 + value2;
		
		System.out.println("sum of the values " + sum);
		
		this.count++;
	}
	// Exercise 3.2: Application body
	private void difference() {
		// Exercise 3.3: Implementation of the application logic
		System.out.print("value1: ");
		int value1 = Integer.parseInt(this.reader.nextLine());
		System.out.print("value2: ");
		int value2 = Integer.parseInt(this.reader.nextLine());
		
		int difference = value1 - value2;
		
		System.out.println("difference of the values " + difference);
		
		this.count++;
		
	}
	// Exercise 3.2: Application body
	private void product() {
		// Exercise 3.3: Implementation of the application logic
		System.out.print("value1: ");
		int value1 = Integer.parseInt(this.reader.nextLine());
		System.out.print("value2: ");
		int value2 = Integer.parseInt(this.reader.nextLine());
		
		int product = value1 * value2;
		
		System.out.println("difference of the values " + product);
		
		this.count++;
		
	}
	// Exercise 3.2: Application body
	private void statistics() {
		// Exercise 3.4: Statistics
		System.out.println("Calculations done " + this.count);
	}

}
