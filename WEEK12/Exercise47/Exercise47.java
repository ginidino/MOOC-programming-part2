package Week12;

import reader.Criterion;
import reader.GutenbergReader;
import reader.criteria.AllLines;
import reader.criteria.AtLeastOne;
import reader.criteria.Both;
import reader.criteria.ContainsWord;
import reader.criteria.EndsWithQuestionOrExclamationMark;
import reader.criteria.LengthAtLeast;
import reader.criteria.Not;

// Exercise 47: Flexible Filtering Criteria
public class Exercise47 {
	public static void main(String[] args) {
		// Exercise 47.1: All Lines
		String address = "http://www.gutenberg.myebook.bg/2/5/5/2554/2554-8.txt";
	    GutenbergReader book = new GutenbergReader(address);

	    Criterion criterion = new AllLines();

	    for (String line : book.linesWhichComplyWith(criterion)) {
	        System.out.println(line);
	    }
	    System.out.println();
	    
	    // Exercise 47.2: Ends with Question or Exclamation Mark
	    //String address = "http://www.gutenberg.myebook.bg/2/5/5/2554/2554-8.txt";
	    //GutenbergReader book = new GutenbergReader(address);

	     Criterion cri = new EndsWithQuestionOrExclamationMark();

	    for (String line : book.linesWhichComplyWith(cri)) {
	        System.out.println(line);
	    }
	    System.out.println();
	    
	    // Exercise 47.3: Length At Least
	    //String address = "http://www.gutenberg.myebook.bg/2/5/5/2554/2554-8.txt";
	    //GutenbergReader book = new GutenbergReader(address);
	    
	    Criterion criterions = new LengthAtLeast(40);

	    for (String line : book.linesWhichComplyWith(criterions)) {
	        System.out.println(line);
	    }
	    System.out.println();
	    
	    // Exercise 47.4: Both
	    //String address = "http://www.gutenberg.myebook.bg/2/5/5/2554/2554-8.txt";
	    //GutenbergReader book = new GutenbergReader(address);

	    Criterion crit = new Both(
	                    new EndsWithQuestionOrExclamationMark(),
	                    new ContainsWord("beer")
	                );

	    for (String line : book.linesWhichComplyWith(crit)) {
	        System.out.println(line);
	    }
	    System.out.println();
	    
	    // Exercise 47.5: Negation
	    //String address = "http://www.gutenberg.myebook.bg/2/5/5/2554/2554-8.txt";
	    //GutenbergReader book = new GutenbergReader(address);

	    Criterion crite = new Not(new LengthAtLeast(10));

	    for (String line : book.linesWhichComplyWith(crite)) {
	        System.out.println(line);
	    }
	    System.out.println();
	    
	    // Exercise 47.6: At Least One
	    //String address = "http://www.gutenberg.myebook.bg/2/5/5/2554/2554-8.txt";
	    //GutenbergReader book = new GutenbergReader(address);

	    Criterion criteri =new AtLeastOne(
	                    new ContainsWord("beer"),
	                    new ContainsWord("milk"),
	                    new ContainsWord("oil")
	                );
	    
	    Criterion words = new AtLeastOne(
                new ContainsWord("beer"),
                new ContainsWord("milk"),
                new ContainsWord("oil")
            );

	    Criterion rightLength = new Both(
                     new LengthAtLeast(20),
                     new Not( new LengthAtLeast(31))
                   );

	    Criterion wanted = new Both(words, rightLength);

	    for (String line : book.linesWhichComplyWith(criteri)) {
	        System.out.println(line);
	    }
	}
}