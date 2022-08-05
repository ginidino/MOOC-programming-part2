# Regular Expressions
A regular expression is a compact form of defining a string. Regular expressions are often used to validate strings.   
ex) Check that the student number assigned by the user is written in the correct format.
- Student numbers start with the string "01" followed by 7 digits 0 through 9.
  * Able to use the `charAt` method to validate the student number parsing each character.
  * Another way would be to check if the first character is "0" and use the `Integer.parseInt` method to convert the string to a number. 
  * Then you can check if that number is less than 20000000.

To perform validation using a regular expression, you must define an appropriate regular expression. You can then use the `matches` method of the `String` class, which checks whether a string matches the regular expression in the parameter. For student number, the appropriate regular expression is `"01[0-9]{7}"`, and the validity of the user input can be checked as follows.
```java
System.out.print("Give student number: ");
String num = reader.nextLine();

if (num.matches("01[0-9]{7}")) {
    System.out.println("The form is valid.");
} else {
    System.out.println("The form is not valid.");
}
```

## Vertical Bar: Logical or
The vertical bar means that the parts of the regular expression are optional. For instance, the expression `00|111|0000` defines the strings `00`, `111` and `0000`. The method `matches` returns `true` if the string matches one of the alternatives defined.
```java
String string = "00";

if(string.matches("00|111|0000")) {
    System.out.println("The string was matched by some of the alternatives");
} else {
    System.out.println("The string not was matched by any of the alternatives");
}
```
```
The string was matched by some of the alternatives
```
The regex 00|111|0000 expects a string of exactly the same format. Its function is different from "*contains*".

```java
String string = "1111";

if(string.matches("00|111|0000")) {
    System.out.println("The string was matched by some of the alternatives");
} else {
    System.out.println("The string not was matched by any of the alternatives");
}
```
```
The string not was matched by any of the alternatives
```

## Round Brackets: a Delimited Part of the String
With the help of round brackets it is possible to define what part of the regular expression is affected by the symbols. If want to allow alternatives `00000` and `00001`, able to define it using a vertical bar: `00000|00001`. Thanks to the round breaker, the choice can only be separated as part of the string. The expression `0000(0|1)` defines the strings `00000` and `00001`.

Thus, the regular expression `look(|s|ed)` defines the base form of the verbs look (look), third person (looks), and past (looked).
```java
System.out.print("Write a form of the verb to look: ");
String word = reader.nextLine();

if (word.matches("look(|s|ed|ing|er)")) {
    System.out.println("Well done!");
} else {
    System.out.println("Check again the form.");
}
```

## Repetitions
Repetitions in regular expressions
- `*` stands for a repetition from 0 to n times
```java
String string = "trolololololo";

if(string.matches("trolo(lo)*")) {
    System.out.println("The form is right.");
} else {
    System.out.println("The form is wrong.");
}
```
```
The form is right.
```
- `+` stands for a repetition from 1 to n times
```java
String string = "trolololololo";

if(characterString.matches("tro(lo)+")) {
    System.out.println("The form is right.");
} else {
    System.out.println("The form is wrong.");
}
```
```
The form is right.
```
```java
String characterString = "nänänänänänänänä Bätmään!";

if(characterString.matches("(nä)+ Bätmään!")) {
    System.out.println("The form is right.");
} else {
    System.out.println("The form is wrong.");
}
```
```
The form is right.
```
- `?` stands for a repetition of 0 or 1 time
```java
String string = "You have accidentally the whole name";

if(characterString.matches("You have accidentally (deleted )?the whole name")) {
    System.out.println("The form is right.");
} else {
    System.out.println("The form is wrong.");
}
```
```
The form is right.
```
- **`{a}`** stands for a repetition of a times
```java
String string = "1010";

if(string.matches("(10){2}")) {
    System.out.println("The form is right.");
} else {
    System.out.println("The form is wrong.");
}
```
```
The form is right.
```
- **`{a,b}`** stands for a repetition from a to b times
```java
String string = "1";

if(string.matches("1{2,4}")) {
    System.out.println("The form is right.");
} else {
    System.out.println("The form is wrong.");
}
```
```
The form is wrong.
```
- **`{a,}`** stands for a repetition from a to n times
```java
String string = "11111";

if(string.matches("1{2,}")) {
    System.out.println("The form is right.");
} else {
    System.out.println("The form is wrong.");
}
```
```
The form is right.
```

Able to use multiple repeating symbols within a single regular expression. For example, the regular expression `5{3}(1|0)*5{3}` defines a string that starts and ends with 5. There can be an infinite number of 1s and 0s in between.

## Square Brackets: Character Groups
With the help of square brackets we can quickly define groups of characters. Characters are written in square brackets, and a hyphen (-) can be used to define the spacing.
- ex) `[145]` is equivalent to `(1|4|5)`, and `[2-36-9]` is equivalent to `(2|3|6|7|8|9)`.

Accordingly, `[a-c]*` defines a regular expression with a string made only of characters `a`, `b` and `c`.
