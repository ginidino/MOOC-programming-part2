# Exercise 35: Two-Direction Dictionary
## Exercise 35.1: Forgetful Basic Functionality
Create a parameterless constructor, as well as the methods:

- `public void add(String word, String translation)`
  * adds a word to the dictionary. Each word has only one translation; if the same word is added twice, nothing happens.
- `public String translate(String word)`
  * returns the word translation; if the word isn't recognised, it returns null

At this point, the dictionary has to work in the following way:
```java
MindfulDictionary dict = new MindfulDictionary();
dict.add("apina", "monkey");
dict.add("banaani", "banana");
dict.add("apina", "apfe");

System.out.println( dict.translate("apina") );
System.out.println( dict.translate("monkey") );
System.out.println( dict.translate("programming") );
System.out.println( dict.translate("banana") );
```
Prints:
```
monkey
apina
null
banaani
```
As you notice from the example, after adding a pair the dictionary can translate in both directions.

## Exercise 35.2: Removing Words
Add the method `public void remove(String word)`, which removes the given word and its translation from your dictionary.

At this point, the dictionary has to work in the following way:
```java
MindfulDictionary dict = new MindfulDictionary();
dict.add("apina", "monkey");
dict.add("banaani", "banana");
dict.add("ohjelmointi", "programming");
dict.remove("apina");
dict.remove("banana");

System.out.println( dict.translate("apina") );
System.out.println( dict.translate("monkey") );
System.out.println( dict.translate("banana") );
System.out.println( dict.translate("banaani") );
System.out.println( dict.translate("ohjelmointi") );
```
Prints
```
null
null
null
null
programming
```
As you see, the delection happens in both ways: whether you remove a word or its translation, the dictionary loses the both the pieces of information.

## Exercise 35.3: Loading a File
Create the constructor `public MindfulDictionary(String file)` and the method `public boolean load()`, which loads a file whose name is given as parameter in the dictionary constructor. If opening or reading the file does not work, the method returns false and otherwise true.

Each line of the dictionary file contains a word and its translation, divided by the character ":". Together with the exercise body, you find a dictionary file meant to help the tests. It looks like the following:
```
apina:monkey
alla oleva:below
olut:beer
```
Read the dictionary file line by line with the reader method nextLine. You can split the lines with the String method split, in the following way:
```java
Scanner fileReader = new ...
while ( fileReader.hasNextLine() ){
    String line = fileReader.nextLine();
    String[] parts = line.split(":");   // the line is split at :

    System.out.println( parts[0] );     // the part of the line before :
    System.out.println( parts[1] );     // the part of the line after :
}
```
The dictionary is used in the following way:
```java
MindfulDictionary dict = new MindfulDictionary("src/words.txt");
dict.load();

System.out.println( dict.translate("apina") );
System.out.println( dict.translate("ohjelmointi") );
System.out.println( dict.translate("alla oleva") );
```
Printing
```
monkey
null
below
```
## Exercise 35.4: Saving Data
Create the method `public boolean save()`; when the method is called, the dictionary contents are written into the file whose name was given as parameter to the constructor. The method returns false if the file can't be saved; otherwise it returns true. Dictionary files have to be saved in the form described above, meaning that the program has to be able to read its own files.

Attention: even though the dictionary can translate in both directions, only one direction has to be stored into the dictionary file. For instance, if the dictionary knows that tietokone = computer, you have to write either the line:
```
tietokone:computer
```
or the line
```
computer:tietokone
```
but not both!

It may be useful to write the new translation list over the old file; in fact, the append command which came out in the material should not be used.

The final version of your dictionary should be used in the following way:
```java
MindfulDictionary dict = new MindfulDictionary("src/words.txt");
dict.load();

// using the dictionary

dict.save();
```
At the beginning we load the dictionary from our file, and we save it back in the end, so that the changes made to the dictionary will be available next time, too.
