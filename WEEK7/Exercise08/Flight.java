package Week7;

import java.util.HashMap;
import java.util.ArrayList;

// Exercise 8: Airport
public class Flight {
	private HashMap <String, String> flight;
	
	public Flight() {
		this.flight = new HashMap<String, String>();
	}
	
	public void addFlight(String departure, String destination, String flightID) {
		String route = "";
		
		while (flight.containsKey(flightID)) {
			route += " ";
		}
		this.flight.put(flightID, route);
	}
	
	public void printFlights(Airplane plane) {
		for (String fID : flight.keySet()) {
			System.out.println(plane.get(fID) + flight.get(fID));
		}
	}
}
