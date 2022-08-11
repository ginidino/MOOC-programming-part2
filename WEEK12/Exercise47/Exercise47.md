# Exercise 47: Flexible Filtering Criteria
In some exercises (see Library in Introduction to Programming, and Word Inspection in Advanced Programming), we have run into such situations where we had to filter out list objects according to particular criteria; for instance, in Word Inspection the methods `wordsContainingZ`, `wordsEndingInL`, `palindromes`, `wordsWhichContainAllVowels` all to the same same thing: they go through the file content one word after the other, and they make sure that the specific filtering criteria are satisfied, in which case they store the word. Because the method criteria are different, we haven't been able to get rid of this repetition, and the code of all those methods made wide use of copypaste.

With this exercise, we create a program to filter the lines of the books found on the [Project Gutenberg](https://www.gutenberg.org/files/2554/2554-0.txt) pages. In the following example we analyze Dostojevski's Crime and Punishment. We want to have various different filtering criteria, and that it would be possible to filter according to different criteria combinations. The program structure should also allow for adding new criteria later on.

A suitable solution to the problem, is defining the filtering criteria as objects of their own which implement the interface `Criterion`. The interface definition is below:
```java
public interface Criterion {
    boolean complies(String line);
}
```
A filtering class which implements the interface:
```java
public class ContainsWord implements Criterion {

    String word;

    public ContainsWord(String word) {
        this.word = word;
    }

    @Override
    public boolean complies(String line) {
        return line.contains(word);
    }
}
```
The class objects are quite simple, in fact, and they only remember the word given as constructor parameter. The only method of the object can be asked whether the criterion complies to the parameter String; if so, this means that the object contains the word stored into the String object.

Together with the excercise body, you find the pre-made class `GutenbergReader`, which helps you to analyze book lines according to the filtering criteria given as parameter:
```java
public class GutenbergReader {

    private List<String> lines;

    public GutenbergReader(String address) throws IllegalArgumentException {
        // the code which retrieves the book from the Internet
    }

    public List<String> linesWhichComplyWith(Criterion c){
        List<String> complyingLines = new ArrayList<String>();

        for (String line : lines) {
            if (c.complies(line)) {
                complyingLines.add(line);
            }
        }

        return complyingLines;
    }
}
```
With the following code, we print all the lines in Crime and Punishment which contain the word "beer":
```java
public static void main(String[] args) {
    String address = "http://www.gutenberg.myebook.bg/2/5/5/2554/2554-8.txt";
    GutenbergReader book = new GutenbergReader(address);

    Criterion criterion = new ContainsWord("beer");

    for (String line : book.linesWhichComplyWith(criterion)) {
        System.out.println(line);
    }
}
```

## Exercise 47.1: All Lines
Create the class `AllLines` which implements `Criterion`, which accepts all the lines. This and the other classes of the exercise have to be implemented in the package `reader.criteria`.
```java
public static void main(String[] args) {
    String address = "http://www.gutenberg.myebook.bg/2/5/5/2554/2554-8.txt";
    GutenbergReader book = new GutenbergReader(address);

    Criterion criterion = new AllLines();

    for (String line : book.linesWhichComplyWith(criterion)) {
        System.out.println(line);
    }
}
```

## Exercise 47.2: Ends with Question or Exclamation Mark
Implement class `EndsWithQuestionOrExclamationMark`, which implements the interface `Criterion` and accepts the lines whose last character is a question or an exclamation mark.
```java
public static void main(String[] args) {
    String address = "http://www.gutenberg.myebook.bg/2/5/5/2554/2554-8.txt";
    GutenbergReader book = new GutenbergReader(address);

     Criterion criterion = new EndsWithQuestionOrExclamationMark();

    for (String line : book.linesWhichComplyWith(criterion)) {
        System.out.println(line);
    }
}
```
> * Reminder: you compare character in Java with the == operator:
```java
String name = "pekka";

// ATTENTION: 'p' is a character, that is to say char p; differently, "p" is a String, whose only character is p
if ( name.charAt(0) == 'p' ) {
    System.out.println("beginning with p");
} else {
    System.out.println("beginning with something else than p");
}
```

## Exercise 47.3: Length At Least
Implement the class `LengthAtLeast`, which implements the interface `Criterion` and accepts the lines whose length is equal or greater than the number received as constructor parameter.
```java
public static void main(String[] args) {
    String address = "http://www.gutenberg.myebook.bg/2/5/5/2554/2554-8.txt";
    GutenbergReader book = new GutenbergReader(address);

     Criterion criterion = new LengthAtLeast(40);

    for (String line : book.linesWhichComplyWith(criterion)) {
        System.out.println(line);
    }
}
```

## Exercise 47.4: Both
Create the class `Both` which implements the interface `Criterion`. The objects of this class receive two objects as constructor parameter, both implementing the interface `Criterion`. `Both` objects accept the lines which comply with both the criteria received as constructor parameters. We print below all the lines which end with a question or an exclamation mark and that contain the word "beer".
```java
public static void main(String[] args) {
    String address = "http://www.gutenberg.myebook.bg/2/5/5/2554/2554-8.txt";
    GutenbergReader book = new GutenbergReader(address);

    Criterion criterion = new Both(
                    new EndsWithQuestionOrExclamationMark(),
                    new ContainsWord("beer")
                );

    for (String line : book.linesWhichComplyWith(criterion)) {
        System.out.println(line);
    }
}
```

## Exercise 47.5: Negation
Create the class `Not` which implement the interface `Criterion` and accepts the lines, which don't comply with the criterion received as parameter. We print below the lines whose length is less than 10.
```java
public static void main(String[] args) {
    String address = "http://www.gutenberg.myebook.bg/2/5/5/2554/2554-8.txt";
    GutenbergReader book = new GutenbergReader(address);

    Criterion criterion = new Not( new LengthAtLeast(10) );

    for (String line : book.linesWhichComplyWith(criterion)) {
        System.out.println(line);
    }
}
```

## Exercise 47.6: At Least One
Create the class `AtLeastOne` which implements the interface `Criterion`. The objects of this class receive as parameter an optional amount of objects which implement the interface `Criterion`; this means that the constructor receives a list of variable length as parameter. `AtLeastOne` objects accept the lines which comply with at least one of the criteria received as constructor parameter. We print below the lines which contain one ot the words "beer", "milk" or "oil".
```java
public static void main(String[] args) {
    String address = "http://www.gutenberg.myebook.bg/2/5/5/2554/2554-8.txt";
    GutenbergReader book = new GutenbergReader(address);

    Criterion criterion =new AtLeastOne(
                    new ContainsWord("beer"),
                    new ContainsWord("milk"),
                    new ContainsWord("oil")
                );

    for (String line : book.linesWhichComplyWith(criterion)) {
        System.out.println(line);
    }
}
```
Note that the criteria can be combined as preferred. You find below a criterion which accepts the lines which have at least one of the words "beer", "milk" and "oil" and whose length is between 20-30 characters.
```java
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
```
