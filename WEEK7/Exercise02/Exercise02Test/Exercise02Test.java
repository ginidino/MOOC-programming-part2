package TEST;

import java.util.*;

import Week7.Change;

public class Exercise02Test {
	public static void main(String[] args) {
		String word = "carrot";
		
		String replacedA = "";
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			
			if (character == 'a') {
				replacedA += "*";
			} else {
				replacedA += character; 
			}
		}
		System.out.println(replacedA);
		System.out.println();
		
		ArrayList<Change> changes = new ArrayList<Change>();
		
		String words = "carrot";
		
		changes.add(new Change('a', 'b'));
	    changes.add(new Change('k', 'x'));
	    changes.add(new Change('o', 'å'));
	    
	    for (Change Change : changes) {
	        words = Change.change(words);
	    }
	    System.out.println(words);  // print pårxxbnb
	}
}
