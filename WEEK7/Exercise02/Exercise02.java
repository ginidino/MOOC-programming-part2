package Week7;

// Exercise 2: Character String Changer
public class Exercise02 {
	public static void main(String[] args) {
		// Exercise 2.1: Change-class
		String word = "carrot";
		Change change1 = new Change('a', 'b');
		word = change1.change(word);

		System.out.println(word);

		Change Change2 = new Change('r', 'x');
		word = Change2.change(word);

		System.out.println(word);
		System.out.println();
		
		// Exercise 2.2: Changer-class
		Changer scandiesAway = new Changer();
		scandiesAway.addChange(new Change('ä', 'a'));
		scandiesAway.addChange(new Change('ö', 'o'));
		System.out.println(scandiesAway.change("ääliö älä lyö, ööliä läikkyy"));
	}
}
