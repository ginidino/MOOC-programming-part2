package Week08;

import java.util.ArrayList;
import java.util.HashMap;

// Exercise 9: Car Registration Centre
public class VehicleRegister {
	private HashMap<RegistrationPlate, String> owners;
	
	public VehicleRegister() {
		this.owners = new HashMap<RegistrationPlate, String>();
	}
	// Exercise 9.2: The Owner, Based of the Registration Plate
	public boolean add(RegistrationPlate plate, String owner) {
		// adds the parameter owner of the car which corresponds to the parameter registration plate
		// The method returns true if the car had no owner; 
		// if the car had an owner already, the method returns false and it doesn't do anything
		if (!(this.owners.containsKey(plate))) {
			this.owners.put(plate, owner);
			return true;
		} else {
			return false;
		}
	}
	// Exercise 9.2: The Owner, Based of the Registration Plate
	public String get(RegistrationPlate plate) {
		// returns the car owner which corresponds to the parameter register number. 
		// If the car was not registered, it returns null
		return this.owners.get(plate);
	}
	// Exercise 9.2: The Owner, Based of the Registration Plate
	public boolean delete(RegistrationPlate plate) {
		// delete the information connected to the parameter registration plate. 
		// The method returns true if the information was deleted, 
		// and false if there was no information connetted to the parameter in the register.
		if (this.owners.containsKey(plate)) {
			this.owners.remove(plate);
			return true;
		} else {
			return false;
		}
	}
	// Exercise 9.3: More for the Vehicle Register
	public void printRegistrationPlates() {
		// prints out all the registration plates stored
		for (RegistrationPlate key : this.owners.keySet()) {
			System.out.println(key);
		}
	}
	// Exercise 9.3: More for the Vehicle Register
	public void printOwners() {
		// prints all the car owners stored. 
		// Each owner's name has to be printed only once, even though they had more than one car
		ArrayList<String> owner = new ArrayList<String>();
		
		for (RegistrationPlate key : this.owners.keySet()) {
			String ownerName = this.owners.get(key);
			if (!owner.contains(ownerName)) {
				owner.add(ownerName);
			}
		}
		for (String name : owner) {
			System.out.println(name);
		}
	}
}
