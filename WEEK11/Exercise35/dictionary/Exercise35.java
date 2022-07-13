package dictionary;

// Exercise 35: Two-Direction Dictionary
public class Exercise35 {
	public static void main(String[] args) {
		/*MindfulDictionary dicts = new MindfulDictionary();
	
		// Exercise 35.1: Forgetful Basic Functionality
		dicts.add("원숭이", "monkey");
		dicts.add("바나나", "banana");
		dicts.add("프로그래밍", "programming");
		// Exercise 35.2: Removing Words
		dicts.remove("원숭이");
		dicts.remove("banana");

		System.out.println(dicts.translate("원숭이"));
		System.out.println(dicts.translate("monkey"));
		System.out.println(dicts.translate("banana"));
		System.out.println(dicts.translate("banaani"));
		System.out.println(dicts.translate("프로그래밍"));
		System.out.println();*/
		
		// Exercise 35.3: Loading a File
		MindfulDictionary dict = new MindfulDictionary("src/Week11/Ex35word.txt");
        dict.load();

        System.out.println(dict.translate("apina"));
        System.out.println(dict.translate("ohjelmointi"));
        System.out.println(dict.translate("alla oleva"));
        
        dict.save();
	}
}
