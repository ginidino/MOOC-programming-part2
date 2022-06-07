package wordinspection;

import java.io.File;
import java.util.ArrayList;

// text file is Ex23wordList.txt
public class Exercise23wordList {
	public static void main(String[] args) throws Exception {
		File file = new File ("src/Week09/Ex23wordList.txt");
		WordInspection inspector = new WordInspection(file);
		
		// Exercise 23.1: Word Count
		int wordCount = inspector.wordCount();
		System.out.println("Number of words: " + wordCount);
        System.out.println();
        
        // Exercise 23.2: z
        ArrayList<String> wordsOfZ = new ArrayList<String>(inspector.wordsContainingZ());
        System.out.println("Words with Z: ");
        for (String string : wordsOfZ) {
            System.out.println(string);
        }
        System.out.println();
        
        // Exercise 23.3: Ending l
        ArrayList<String> wordOfL = new ArrayList<String>(inspector.wordsEndingInL());
        System.out.println("Words ending with L: ");
        for (String string : wordOfL) {
            System.out.println(string);
        }
        System.out.println();
        
        // Exercise 23.4: Palindromes
        ArrayList<String> palindromes = new ArrayList<String>(inspector.palindromes());
        System.out.println("Words that are palindromes: ");
        for (String string : palindromes) {
            System.out.println(string);
        }
        System.out.println();
        
        // Exercise 23.5: All Vowels
        ArrayList<String> allVowels = new ArrayList<String>(inspector.wordsWhichContainAllVowels());
        System.out.println("Words which contain every vowel: ");
        for (String string : allVowels) {
            System.out.println(string);
        }
	}
}
