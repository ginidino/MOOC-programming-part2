# Exercise 22: File Analysis

In this exercise, create an application to calculate the number of lines and characters.

## Exercise 22.1: Number of Lines
Create the class Analysis in the package file; the class has the constructor public Analysis(File file). Create the method public int lines(), which returns the number of lines of the file the constructor received as parameter.

The method cannot be "disposable", that is to say it has to return the right value even though it is called different times in a raw. Note that after you create a Scanner object for a file and read its whole contents using nextLine method calls, you can't use the same scanner to read the file again!

- Attention: if the tests report a timeout, it probably means that you haven't been reading the file at all, meaning that the nextLine method calls miss!

## Exercise 22.2: Number of Characters
Create the method public int characters() in the class Analysis; the method returns the number of characters of the file the constructor received as parameter.

The method cannot be "disposable", that is to say it has to return the right value even though it is called different times in a raw.

You can decide yourself what to do if the constructor parameter file does not exist.

The file contains the following text:
```
there are 3 lines, and characters
because line breaks are also
characters
```

The following example shows what the program should do:

```java
File file = new File("test/testfile.txt");
Analysis analysis = new Analysis(file);
System.out.println("Lines: " + analysis.lines());
System.out.println("Characters: " + analysis.characters());
```

```
Lines: 3
Characters: 74
```
