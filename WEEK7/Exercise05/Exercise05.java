package Week7;

import java.util.HashMap;

// Exercise 5: Nicknames
// Create a HashMap<String,String> object in the main method
// Store the following people's names and nicknames into the HashMap, the name being the key and the nickname its value
// Use only lower case letters
public class Exercise05 {
	public static void main(String[] args) {
		HashMap<String, String> nickname = new HashMap<String, String>();
		nickname.put("matti", "mage");
		nickname.put("mikael", "mixu");
		nickname.put("arto", "arppa");
		
		String mikealNickName = nickname.get("mikael");
		System.out.println(mikealNickName);
		
		System.out.println(nickname.get("mikael"));
	}
}
