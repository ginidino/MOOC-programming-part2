package TEST;

public class GenericsTest {
	public static void main(String[] args) {
		Slot<String> string = new Slot<String>();
	    string.setValue(":)");

	    System.out.println(string.getValue());
	    System.out.println();
	    
	    Slot<Integer> num = new Slot<Integer>();
	    num.setValue(5);

	    System.out.println(num.getValue());
	}
}
