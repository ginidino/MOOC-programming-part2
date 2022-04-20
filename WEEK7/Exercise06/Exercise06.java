package Week7;

// Exercise 6: Promissory Note
public class Exercise06 {
	public static void main(String[] args) {
		PromissoryNote mattisNote = new PromissoryNote();
		mattisNote.setLoan("Arto", 51.5);
		mattisNote.setLoan("Mikael", 30);

		System.out.println(mattisNote.howMuchIsTheDebt("Arto"));
		System.out.println(mattisNote.howMuchIsTheDebt("Joel"));
		System.out.println();
		
		mattisNote.setLoan("Arto", 51.5);
		mattisNote.setLoan("Arto", 10.5);
		System.out.println(mattisNote.howMuchIsTheDebt("Arto"));
	}
}
