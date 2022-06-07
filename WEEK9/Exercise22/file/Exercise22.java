package file;

import java.io.File;

public class Exercise22 {
	public static void main(String[] args) throws Exception {
		File file = new File("src/Week09/Exercise22textfile.txt");
	    Analysis analysis = new Analysis(file);
	    System.out.println("Lines: " + analysis.lines());
	    System.out.println("Characters: " + analysis.characters());
	}
}
