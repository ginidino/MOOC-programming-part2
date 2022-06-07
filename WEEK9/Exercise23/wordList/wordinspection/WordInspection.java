package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Exercise 23: Word Inspection
public class WordInspection {
	private File file;
	private Scanner reader;
	private List<String> wordsContaining;

	public WordInspection(File file) {
		this.file = file;
	}
	// Exercise 23.1: Word Count
	public int wordCount() throws Exception {
		// counts the file words and prints their number
		this.reader = new Scanner(this.file, "UTF-8");
		int words = 0;
		
		while (this.reader.hasNextLine()) {
			words++;
			this.reader.nextLine();
		}
		this.reader.close();
		
		return words;
	}
	// Exercise 23.2: z
	public List<String> wordsContainingZ() throws Exception {
		// returns all the file words which contain a z
		this.reader = new Scanner(this.file, "UTF-8");
		this.wordsContaining = new ArrayList<String>();
		
		while(this.reader.hasNextLine()) {
			String wordOfZ = this.reader.nextLine();
			if (wordOfZ.contains("z")) {
				this.wordsContaining.add(wordOfZ);
			}
		}
		this.reader.close();
		
		return this.wordsContaining;
	}
	// Exercise 23.3: Ending l
	public List<String> wordsEndingInL() throws Exception {
		// returns all the Finnish words of the file which end in l
		this.reader = new Scanner(this.file, "UTF-8");
		this.wordsContaining = new ArrayList<String>();
		
		while(this.reader.hasNextLine()) {
			String endingOfL = this.reader.nextLine();
			if (endingOfL.endsWith("l")) {
				this.wordsContaining.add(endingOfL);
			}
		}
		this.reader.close();
		
		return this.wordsContaining;
	}
	// Exercise 23.4: Palindromes
	public List<String> palindromes() throws Exception {
		this.reader = new Scanner(this.file, "UTF-8");
		this.wordsContaining = new ArrayList<String>();
		
		while(this.reader.hasNextLine()) {
			String word = this.reader.nextLine();
			boolean boo = true;
			
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
					boo = false;
				}
			}
			
			if (boo == true) {
				this.wordsContaining.add(word);
			}
			/*String palindrome = this.reader.nextLine();
			String reversedWord = "";
			
			for (int i = palindrome.length() - 1; i >= 0; i--) {
				reversedWord += palindrome.charAt(i);
				
			}
			
			if (palindrome.equals(reversedWord)) {
				this.wordsContaining.add(palindrome);
			}*/
		}
		this.reader.close();
		
		return this.wordsContaining;
	}
	// Exercise 23.5: All Vowels
	public List<String> wordsWhichContainAllVowels() throws Exception {
		// returns all the words of the file which contain all Finnish vowels (aeiouyäö).
		this.reader = new Scanner(this.file, "UTF-8");
		this.wordsContaining = new ArrayList<String>();
		
		while (this.reader.hasNextLine()) {
			String vowelCheck = this.reader.nextLine();
			if (vowelCheck.contains("a") && vowelCheck.contains("e")
					&& vowelCheck.contains("i") && vowelCheck.contains("o")
					&& vowelCheck.contains("u") && vowelCheck.contains("y")
					&& vowelCheck.contains("ä") && vowelCheck.contains("ö")) {
				this.wordsContaining.add(vowelCheck);
			}
		}
		this.reader.close();
		
		return this.wordsContaining;
	}
}
