 # Exercise 2 is about Character String Changer and is divided into 2 part

> In this assignment we create a character string changer, which consists of two classes. The class Changer turns a single character to another one. The Changer holds a number of Changes and changes character strings with the help of Change objects it holds.

## Exercise 2.1 is about Change-class
* Create a class Change, that has the following functionalities:   
    - constructor public Change(char fromCharacter, char toCharacter)   
      - creates an object that makes changes from character fromCharacter to toCharacter   
    - method public String change(String characterString)    
      - returns the changed version of the given character string   

> The class is used in the following way:
```java
      String word = "carrot";
      Change change1 = new Change('a', 'b');
      word = change1.change(word);

      System.out.println(word);

      Change Change2 = new Change('r', 'x');
      word = Change2.change(word);

      System.out.println(word);
```  
* The example above would print:
```
      cbrrot
      cbxxot
```        
> Tip: you can handle replacing characters in two ways, either with the help of a method in the class String (look for it yourself!) or by going through the character string character by character while forming the changed character string.      
> If you don't use the ready-made method of String, it is good to remember that even though you compare character strings with the command equals you compare single characters with the == operator:

```java
      String word = "carrot";

      String replacedA = "";
      for ( int i=0; i < word.length(); i++) {
         char character = word.charAt(i);
         if ( character == 'a' ) {
            replacedA += '*'
         }  else {
            replacedA += character;
         }
      }

      System.out.println(replacedA);  // prints c*rrot
```

## Exercise 2.2 is about Changer-class
> Create the class Changer, with the following functions:

* constructor public Changer() creates a new changer   
    - method public void addChange(Change change)    
      - adds a new Change to the Changer   
    - method public String change(String characterString)    
      - executes all added Changes for the character string in the order of their adding and returns the changed character string   

> The class is used in the following way:
```java
      Changer scandiesAway = new Changer();
      scandiesAway.addChange(new Change('ä', 'a'));
      scandiesAway.addChange(new Change('ö', 'o'));
      System.out.println(scandiesAway.change("ääliö älä lyö, ööliä läikkyy"));
```        
* The above example would print:
```
      aalio ala lyo, oolia laikkyy
```   
> Tip: It's a good idea to store the Changes to a list object variable of Changer (in the same fashion as on the basics course we stored players to a team, phone numbers to a phone book or books to a library, for example) A Changer is executed so that the changes are done to the character string one at a time as in the following example:   
```java
        ArrayList<Change> changes = new ArrayList<Change>();

        changes.add( new Change('a', 'b') );
        changes.add( new Change('k', 'x') );
        changes.add( new Change('o', 'å') );

        String word = "carrot";

        for (Change Change : changes) {
            word = Change.change(word);
        }

        System.out.println(word);  // print pårxxbnb
 ```       
> REMINDER when you add an ArrayList, a Scanner or a Random, Java doesn't recognize the class unless you "import" it by adding the following lines to the beginning:
```java
    import java.util.ArrayList;    // imports ArrayList
    import java.util.*;            // imports all tools from java.util, including ArrayList, Scanner ja Random
```
