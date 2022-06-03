package Week09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Exercise 21: Printer
public class Printer {
	private Scanner reader;
	private File file;
	
	public Printer(String fileName) throws Exception {
		// receives a String standing for the file name
		this.file = new File(fileName);
		
	}

	public void printLinesWhichContain(String word) throws Exception {
		/* prints the file lines which contain the parameter word (lower and upper case make difference in this excercise; 
		   for instance, "test" and "Test" are not the considered the same); 
		   the lines are printed in the same order as they are inside the file 
		*/
		this.reader = new Scanner(this.file);
		while(this.reader.hasNextLine()) {
			String line = this.reader.nextLine();
			if (line.contains(word)) {
				System.out.println(line);
			}
		}
		this.reader.close();
	}
}
