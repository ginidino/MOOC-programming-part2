package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Exercise 22: File Analysis
public class Analysis {
	private File file;
	private Scanner reader;
	
	// Exercise 22.1: Number of Lines
	public Analysis(File file) {		
		this.file = file;
	}
	// Exercise 22.1: Number of Lines
	public int lines() throws Exception {
		// returns the number of lines of the file the constructor received as parameter
		this.reader = new Scanner(this.file);
		int count = 0;
		while (this.reader.hasNextLine()) {
			count++;
			this.reader.nextLine();
		}
		this.reader.close();
		
		return count;
	}
	public int characters() throws Exception {
		// returns the number of characters of the file the constructor received as parameter
		this.reader = new Scanner(this.file);
		int count = 0;
		while (this.reader.hasNextLine()) {
			String line = this.reader.nextLine();
			count += line.length();
		}
		this.reader.close();
		
		return count + this.lines();
	}
}
