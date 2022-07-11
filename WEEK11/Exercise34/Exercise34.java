package Week11;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

// Exercise 34: File Manager
public class Exercise34 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
        FileManager f = new FileManager();
        
        // Exercise 34.1: File Reading
        for (String line : f.read("src/Week11/Ex34testinput1.txt")) {
            System.out.println(line);
        }
        System.out.println();
        
        // Exercise 34.2: Writing a Line
        f.save("src/Week11/Ex34testinput2.txt", "second");
        for (String line : f.read("src/Week11/Ex34testinput2.txt")) {
            System.out.println(line);
        }
        System.out.println();
        
        // Exercise 34.3: Writing a List
        ArrayList<String> fruits = new ArrayList<String>();
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("watermelon");

        f.save("src/Week11/Ex34TestFruits.txt", fruits);
        for (String lines : f.read("src/Week11/Ex34TestFruits.txt")) {
            System.out.println(lines);
        }
    }
}
