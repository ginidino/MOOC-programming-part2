package Week08;

import java.util.ArrayList;
import java.util.HashMap;

// Exercise 9: Car Registration Centre
public class Exercise09 {
	public static void main(String[] args) {
		// Exercise 9.1: Registration Plate Equals and HashCode
		RegistrationPlate reg1 = new RegistrationPlate("FI", "ABC-123");
        RegistrationPlate reg2 = new RegistrationPlate("FI", "UXE-465");
        RegistrationPlate reg3 = new RegistrationPlate("D", "B WQ-431");

        ArrayList<RegistrationPlate> finnish = new ArrayList<RegistrationPlate>();
        finnish.add(reg1);
        finnish.add(reg2);

        RegistrationPlate newPlate = new RegistrationPlate("FI", "ABC-123");
        if (!finnish.contains(newPlate)) {
            finnish.add(newPlate);
        }
        System.out.println("Finnish: " + finnish);
        // if the equals method hasn't been overwritten, the same registration plate is repeated in the list

        HashMap<RegistrationPlate, String> owners = new HashMap<RegistrationPlate, String>();
        owners.put(reg1, "Arto");
        owners.put(reg3, "Jürgen");

        System.out.println("owners:");
        System.out.println(owners.get(new RegistrationPlate("FI", "ABC-123")));
        System.out.println(owners.get(new RegistrationPlate("D", "B WQ-431")));
        // if the hashCode hasn't been overwritten, the owners are not found
	}
}
