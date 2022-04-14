package Week7;

//Exercise 3: Calculator
public class Calculator {
	private Reader reader;
	private int count;
	
	public Calculator() {
		this.reader = new Reader();
	}
	// Exercise 3.2: Application body
	public void start() {
		while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            
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
		int value1 = this.reader.readInteger();
		System.out.print("value2: ");
		int value2 = this.reader.readInteger();
		
		int sum = value1 + value2;
		
		System.out.println("sum of the values " + sum);
		
		this.count++;
	}
	// Exercise 3.2: Application body
	private void difference() {
		// Exercise 3.3: Implementation of the application logic
		System.out.print("value1: ");
		int value1 = this.reader.readInteger();
		System.out.print("value2: ");
		int value2 = this.reader.readInteger();
		
		int difference = value1 - value2;
		
		System.out.println("difference of the values " + difference);
		
		this.count++;
		
	}
	// Exercise 3.2: Application body
	private void product() {
		// Exercise 3.3: Implementation of the application logic
		System.out.print("value1: ");
		int value1 = this.reader.readInteger();
		System.out.print("value2: ");
		int value2 = this.reader.readInteger();
		
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
