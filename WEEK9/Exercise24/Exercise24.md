# Exercise 24: Multiple Entry Dictionary

task is to implement the class `PersonalMultipleEntryDictionary`, which can save one or more entry for each word translated.   
The class has to implement the interface in the exercise source, `MultipleEntryDictionary`, with the following methods:

- public void add(String word, String entry)
  - which adds a new entry to a word, maintaining the old ones
- public Set<String> translate(String word)
  - which returns a Set object, with all the entries of the word, or a null reference, if the word is not in the dictionary
- public void remove(String word)
  - which removes a word and all its entries from the dictionary
  
As for the ExampleAccounting above, it's good to store the translations into a Map<String, Set<String>> object variable.

The interface code:
```java
package dictionary;

import java.util.Set;

public interface MultipleEntryDictionary {
    void add(String word, String translation);
    Set<String> translate(String word);
    void remove(String word);
}
An example program:

    MultipleEntryDictionary dict = new PersonalMultipleEntryDictionary();
    dict.add("kuusi", "six");
    dict.add("kuusi", "spruce");

    dict.add("pii", "silicon");
    dict.add("pii", "pi");

    System.out.println(dict.translate("kuusi"));
    dict.remove("pii");
    System.out.println(dict.translate("pii"));
```
Prints:
```
[six, spruce]
null
```
