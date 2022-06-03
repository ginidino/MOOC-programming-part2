package Week09;

// Exercise 21: Printer
public class Exercise21 {
	public static void main(String[] args) throws Exception {
		Printer printer = new Printer("src/Week09/textfile.txt");
		
	    printer.printLinesWhichContain("Still Life(EN)");
	    System.out.println("-----");
	    printer.printLinesWhichContain("BIGBANG");
	    System.out.println("-----");
	    printer.printLinesWhichContain("");
	    System.out.println("-----");
	    System.out.println();
	    
	    Printer printer1 = new Printer("src/Week09/Still Life.txt");
	    
	    printer1.printLinesWhichContain("Still Life");
	    System.out.println("-----");
	    printer1.printLinesWhichContain("BIGBANG");
	    System.out.println("-----");
	    printer1.printLinesWhichContain("");
	    System.out.println("-----");
	}
}
