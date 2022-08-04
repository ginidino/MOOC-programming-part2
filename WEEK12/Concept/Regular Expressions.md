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
