# Exercise 25: Duplicate Remover
task is to implement inside the package tools a class PersonalDuplicateRemover, which stores the given characterStrings so that equal characterStrings are removed (a.k.a duplicates). Class also holds a record of the amount of duplicates. Class should implement the given interface DuplicateRemover, which has the following methods:

public void add(String characterString)   
  - stores a characterString if it's not a duplicate. 
  
public int getNumberOfDetectedDuplicates()
  - returns the number of detected duplicates. 
  
public Set<String> getUniqueCharacterStrings()
  - returns an object which implements the interface Set<String>. Object should have all unique characterStrings (no duplicates!). If there are no unique characterStrings, method returns an empty set.   

public void empty()
  - removes stored characterStrings and resets the amount of detected duplicates.   

Code of the interface:
```java
package tools;

import java.util.Set;

public interface DuplicateRemover {
    void add(String characterString);
    int getNumberOfDetectedDuplicates();
    Set<String> getUniqueCharacterStrings();
    void empty();
}
```
Interface can be used like this for example:

```java
    public static void main(String[] args) {
        DuplicateRemover remover = new PersonalDuplicateRemover();
        remover.add("first");
        remover.add("second");
        remover.add("first");

        System.out.println("Current number of duplicates: " +
            remover.getNumberOfDetectedDuplicates());

        remover.add("last");
        remover.add("last");
        remover.add("new");

        System.out.println("Current number of duplicates: " +
            remover.getNumberOfDetectedDuplicates());

        System.out.println("Unique characterStrings: " +
            remover.getUniqueCharacterStrings());

        remover.empty();

        System.out.println("Current number of duplicates: " +
            remover.getNumberOfDetectedDuplicates());

        System.out.println("Unique characterStrings: " +
            remover.getUniqueCharacterStrings());
    }
```
Code above would print: (order of characterStrings can change, it doesn't matter)
```
Current number of duplicates: 1
Current number of duplicates: 2
Unique characterStrings: [first, second, last, new]
Current number of duplicates: 0
Unique characterStrings: []
```
