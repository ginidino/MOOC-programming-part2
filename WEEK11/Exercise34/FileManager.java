package Week11;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

// Exercise 34: File Manager

public class FileManager {
	private ArrayList<String> files = new ArrayList<String>();
	private Scanner reader;
	
	// Exercise 34.1: File Reading
	public ArrayList<String> read(String file) throws FileNotFoundException {
		this.reader = new Scanner(new File(file));
		
		while (this.reader.hasNextLine()) {
			String line = this.reader.nextLine();
			this.files.add(line);
		}
		return this.files;
	}
	// Exercise 34.2: Writing a Line
	public void save(String file, String text) throws IOException {
		FileWriter writer = new FileWriter(file);
		writer.write(text);
		writer.close();
	}
	// Exercise 34.3: Writing a List
	public void save(String file, ArrayList<String> texts) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (String line : texts) {
			writer.write(line);	
			writer.write("\n");
		}
		writer.close();
	}
}
