package Week7;

import java.util.Scanner;

// Exercise 8: Airport
public class AirportUI {
	private Scanner reader;
	private Airplane plane;
	private Flight flight;
	
	public AirportUI(Scanner reader, Airplane plane, Flight flight) {
		this.reader = new Scanner(System.in);
		this.plane = plane;
		this.flight = flight;
	}

	public void start() {
		System.out.println("Airport panel\n-------------------\n");
		
		while (true) {
			System.out.println("Choose operation: \n[1] Add airplane\n[2] Add flight\n[x] Exit");
            System.out.print("> ");
            
            String command = this.reader.nextLine();
            
            if (command.equals("1")) {
            	System.out.print("Give plane ID: ");
            	String planeID = this.reader.nextLine();
            	System.out.print("Give plane capacity: ");
            	int capacity = Integer.parseInt(this.reader.nextLine());
            	this.plane.add(planeID, capacity);
            } else if (command.equals("2")) {
            	System.out.print("Give plane ID: ");
            	String planeID = this.reader.nextLine();
            	System.out.print("Give departure airport code: ");
            	String departure = this.reader.nextLine();
            	System.out.print("Give destination airport code: ");
            	String destination = this.reader.nextLine();
            	flight.addFlight(departure, destination, planeID);
            } else if (command.equals("x")) {
            	System.out.println();
            	flightService();
            	break;
            }
		}
	}

	public void flightService() {
		System.out.println("Flight service\n------------\n");
		
		while (true) {
			System.out.println("Choose operation: \n[1] Print planes\n[2] Print flights\n[3] Print plane info\n[x] Quit");
            System.out.print("> ");
            
            String command = this.reader.nextLine();
            
            if(command.equals("1")) {
            	plane.printPlane();
            } else if (command.equals("2")) {
            	flight.printFlights(plane);
            	System.out.println();
            } else if (command.equals("3")) {
            	System.out.print("Give plane ID: ");
            	String planeID = this.reader.nextLine();
            	System.out.println(plane.get(planeID));
            	System.out.println();
            } else if (command.equals("x")) {
            	System.out.println();
                break;
            }
		}
	}
}
