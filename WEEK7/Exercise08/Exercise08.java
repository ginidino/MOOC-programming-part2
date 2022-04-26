package Week7;

import java.util.Scanner;

// Exercise 8: Airport
public class Exercise08 {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		Airplane plane = new Airplane();
		Flight flight = new Flight();
		
		AirportUI uiAirport = new AirportUI(reader, plane, flight);
		uiAirport.start();
	}
}
