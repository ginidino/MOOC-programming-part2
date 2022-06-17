package dictionary;

// Exercise 24: Multiple Entry Dictionary
public class Exercise24 {
	public static void main(String[] args) {
		MultipleEntryDictionary dict = new PersonalMultipleEntryDictionary();
	    dict.add("여섯", "six");
	    dict.add("여섯", "spruce");

	    dict.add("pii", "silicon");
	    dict.add("pii", "pi");

	    System.out.println(dict.translate("여섯"));
	    dict.remove("pii");
	    System.out.println(dict.translate("pii"));
	}
}
