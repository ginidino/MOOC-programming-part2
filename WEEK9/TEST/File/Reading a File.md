# Reading a File
A relevant part of programming is related to stored files, in one way or in another.
Java's API provides the class File, whose contents can be read using the already known Scanner class.

the File class has the constructor File(String pathname), which creates a new File instance by converting the given pathname string into an abstract pathname. This means the File class constructor can be given the pathname of the file we want to open.

In the NetBeans programming environment, files have got their own tab called Files, which contains all our project files. If we add a file to a project root -- that is to say outside all folders -- we can refer to it by writing only the its name. We create a file object by fiving the file pathname to it as parameter:

```java
File file = new File("file-name.txt");
```

System.in input stream is not the only reading source we can give to the constructor of a Scanner class. For instance, the reading source can be a file, in addition to the user keyboard. Scanner provides the same methods to read a keyboard input and a file. In the following example, we open a file and we print all the text contained in the file using the System.out.println statement. At the end, we close the file using the statement close.

```java
 // The file we read
 File file = new File("filename.txt");

 Scanner reader = new Scanner(file);
 while (reader.hasNextLine()) {
     String line = reader.nextLine();
            System.out.println(line);
 }

 reader.close();
```

The Scanner class constructor throws a FileNotFoundException when the specified file is not found. The FileNotFoundException is different than RuntimeException, and we have either to handle it or throw it forward. At this point, you only have to know that the programming environment tells you whether you have to handle the exception or not. Let's first create a try-catch block where we handle our file as soon as we open it.

```java
public void readFile(File f) {
    // the file we read
    Scanner reader = null;

    try {
        reader = new Scanner(f);
    } catch (Exception e) {
            System.out.println("We couldn't read the file. Error: " + e.getMessage());
            return; // we exit the method
    }

    while (reader.hasNextLine()) {
        String line = reader.nextLine();
        System.out.println(line);
    }

    reader.close();
}
```
Another option is to delegate the exception handling responsibility to the method caller. We delegate the exception handling responsibility by adding the definition throws ExceptionType to the method. For instance, we can add throws Exception because the type of all exceptions is Exception. When a method has the attribute throws Exception, whatever chunk of code which calls that method knows that it may throw an exception, and it should be prepared for it.

```java
public void readFile(File f) throws Exception {
    // the file we read
    Scanner reader = new Scanner(f);

    while (reader.hasNextLine()) {
        String line = reader.nextLine();
        System.out.println(line);
    }

    reader.close();
}
```

In the example, the method readFile receives a file as parameter, and prints all the file lines. At the end, the reader is closed, and the file is closed with it, too. The attribute throws Exception tells us that the method may throw an exception. Same kind of attributes can be added to all the methods that handle files.

Note that the Scanner object's method nextLine returns a string, but it does not return a new line at the end of it. If you want to read a file and still maintain the new lines, you can add a new line at the end of each line:
```java
public String readFileString(File f) throws Exception {
    // the file we read
    Scanner reader = new Scanner(f);

    String string = "";

    while (reader.hasNextLine()) {
        String line = reader.nextLine();
        string += line;
        string += "\n";
    }

    reader.close();
    return string;
}
```
Because we use the Scanner class to read files, we have all Scanner methods available for use. For instance the method hasNext() returns the boolean value true if the file contains something more to read, and the method next() reads the following word and returns a String object.

The following program creates a Scanner object which opens the file file.txt. Then, it prints every fifth word of the file.
```java
File f = new File("file.txt");
Scanner reader = new Scanner(f);

int whichNumber = 0;
while (reader.hasNext()) {
    whichNumber++;
    String word = reader.next();

    if (whichNumber % 5 == 0) {
        System.out.println(word);
    }
}
```
Below, you find the text contained in the file, followed by the program output.
```
Exception handling is the process of responding to the occurrence, during computation, of exceptions – anomalous or exceptional events 
 requiring special processing – often changing the normal flow of program execution. ...
```
```
process
occurrence,
–
requiring
changing
program
```
