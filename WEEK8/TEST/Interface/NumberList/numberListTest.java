package TEST;

public class numberListTest {
	public static void main(String[] args) {
		NumberList joelList = new NumberList();
	    /*joelList.add(new SMS("matti", "have you already written the tests?"));
	    joelList.add(new SMS("matti", "did you have a look at the submissions?"));

	    System.out.println("Joel has " + joelList.howManyReadables() + " messages to read");
	    System.out.println();*/
	    
	    for (int i = 0; i < 1000; i++) {
	        joelList.add(new SMS("matti", "have you already written the tests?"));
	    }

	    System.out.println("Joel has " + joelList.howManyReadables() + " messages to read");
	    System.out.println("Let's delegate some reading to Mikael");

	    NumberList mikaelList = new NumberList();
	    mikaelList.add(joelList);
	    mikaelList.read();

	    System.out.println();
	    System.out.println("Joel has " + joelList.howManyReadables() + " messages to read");
	}
}
