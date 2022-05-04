package TEST;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// List, Map, Set and Collection
public class InterfacesTest {
	public static void main(String[] args) {
		// List
		List<String> strings = new ArrayList<String>();
		strings.add("A String object within an ArrayList object!");
		System.out.println(strings);
		System.out.println();
		List<String> string = new LinkedList<String>();
		string.add("A string object within a LinkedList object!");
		System.out.println(string);
		System.out.println();
		
		// Map
		Map<String, String> translations = new HashMap<String, String>();
		translations.put("gambatte", "tsemppiä");
		translations.put("hai", "kyllä");
		
		for(String key: translations.keySet()) {
		    System.out.println(key + ": " + translations.get(key));
		}
		System.out.println();
		
		// Set
		Set<String> set = new HashSet<String>();
		set.add("one");
		set.add("one");
		set.add("two");

		for (String key: set) {
		    System.out.println(key);
		}
		System.out.println();
		
		// Collection
		Map<String, String> translation = new HashMap<String, String>();
		translation.put("gambatte", "good luck");
		translation.put("hai", "yes");

		Set<String> keys = translation.keySet();
		Collection<String> keySet = keys;

		System.out.println("Keys:");
		for(String key: keySet) {
		    System.out.println(key);
		}
		System.out.println();
		
		System.out.println("Values:");
		Collection<String> values = translation.values();
		for(String value: values) {
		    System.out.println(value);
		}
	}
}
