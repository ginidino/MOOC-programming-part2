package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		File file = new File("src/file/test.txt");
		//Scanner reader = new Scanner(file);
		try {
			Scanner reader = new Scanner(file);
			
			while(reader.hasNextLine()) {
				String line = reader.nextLine();
	            System.out.println(line);
			}
			
			reader.close();
		} catch (FileNotFoundException e){
			System.out.println("We couldn't read the file. Error: " + e.getMessage());
		}
	}
}
