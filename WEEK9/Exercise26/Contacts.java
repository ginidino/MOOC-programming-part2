package Week09;

import java.util.HashSet;
import java.util.Set;

// Exercise 26: Phone Search
public class Contacts implements Comparable<Contacts> {
	private String name;
	private Set<String> numbers;
	private String address;
	
	public Contacts(String name) {
		this.name = name;
		this.numbers = new HashSet<String>();
		this.address = "";
	}

	public String getName() {
		return this.name;
	}

	public Set<String> getNumbers() {
		return this.numbers;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void addNumbers(String numbers) {
		this.numbers.add(numbers);
	}
	
	public void addAddress(String street, String city) {
		this.address = street + " " + city;
	}
	
	@Override
    public String toString() {
        if (!this.numbers.isEmpty() && !this.address.isEmpty()) {
            return "address: " + this.address + "\nphone numbers: " + this.numbers;
        } else if (!this.numbers.isEmpty() && this.address.isEmpty()) {
            return "address unknown" + "\nphone numbers: " + this.numbers;
        } else if (!this.address.isEmpty()) {
            return "address: " + this.address + "\nphone number not found";
        } else {
            return null;
        }
    }
	
	@Override
	public int compareTo(Contacts compared) {
		if (this.name != null && compared.name != null) {
            return this.name.compareToIgnoreCase(compared.name);
        } else {
            return 0;
        }
	}
}
