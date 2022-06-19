package Week09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Exercise 26: Phone Search
public class ContactBook {
	private List<Contacts> contacts;
	private Map<String, Contacts> nameContacts;
	private Map<Set<String>, Contacts> phoneContacts;
    private Map<String, Contacts> addressContacts;
    
    public ContactBook() {
    	this.contacts = new ArrayList<Contacts>();
    	this.nameContacts = new HashMap<String, Contacts>();
    	this.phoneContacts = new HashMap<Set<String>, Contacts>();
    	this.addressContacts = new HashMap<String, Contacts>();
    }
    
    public void addContact(Contacts person) {
    	this.contacts.add(person);
    	this.nameContacts.put(person.getName(), person);
    	this.phoneContacts.put(person.getNumbers(), person);
    	this.addressContacts.put(person.getAddress(), person);
    }
    
    public boolean containsPersonByName(String name) {
    	for (Contacts person : this.contacts) {
    		if (person.getName().equals(name)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public void addNumber(String name, String number) {
    	for (Contacts person : this.contacts) {
    		if (person.getName().equals(name)) {
    			person.addNumbers(number);
    			this.phoneContacts.put(person.getNumbers(), person);
    		}
    	}
    }
    
    public void addAddress(String name, String street, String city) {
    	for (Contacts person : this.contacts) {
    		if (person.getName().equals(name)) {
    			person.addAddress(street, city);
    			this.addressContacts.put(person.getAddress(), person);
    		}
    	}
    }
    
    public String getNameBasedOnNumber(String number) {
    	for (Contacts person : this.contacts) {
    		Set<String> numbersOfContact = person.getNumbers();
    		for (String s : numbersOfContact) {
    			if (s.equals(number)) {
    				return " " + person.getName();
    			}
    		}
    	}
		return " not found";
	}

	public String getNumberBasedOnName(String name) {
		return this.nameContacts.get(name).getNumbers().toString().replace("[", "").replace(", ", "\n").replace("]", "");
	}

	public Contacts getPersonalInformation(String name) {
		return this.nameContacts.get(name);
	}

	public void deletePerson(String name) {
		Contacts delete = new Contacts("");
		for (Contacts person : this.contacts) {
			if (person.getName().equals(name)) {
				delete = person;
			}
		}
		this.nameContacts.remove(name);
		this.phoneContacts.remove(delete.getNumbers());
		this.addressContacts.remove(name);
		this.contacts.remove(delete);
	}

	public void filteredList(String keyword) {
		Collection<Contacts> newList = new ArrayList<Contacts>();
		Collections.sort(this.contacts);
		for (Contacts person : this.contacts) {
			if (keyword.isEmpty() || person.getAddress().contains(keyword) || person.getName().contains(keyword)) {
				newList.add(person);
			}
		}
		
		if (newList.isEmpty()) {
			System.out.println("not found");
		} else {
			for (Contacts person : newList) {
				System.out.println(person.getName());
				System.out.println(person);
			}
		}
	} 
}
