# Writing to a File
The class `FileWriter` provides the functionality to write to a file. The `FileWriter` constructor is given as parameter a String illustrating the file location.
```java
FileWriter writer = new FileWriter("file.txt");
writer.write("Hi file!\n"); // the line break has to be written, too!
writer.write("Adding text\n");
writer.write("And more");
writer.close(); // the call closes the file and makes sure the written text goes to the file
```

In the example we write the string "Hi file!" to the file "file.txt"; that is followed by a line break, and by more text. Note that when you use the `write` method, it does not produce line breaks, but they have to be added later manually.

Both the FileWriter constructor and the write method may throw an exception, which has to be either handled or the responsibility has to be delegated to the calling method.    
The method which is given as parameter the file name and the text to write into it can look like the following.
```java
public class FileHandler {

    public void writeToFile(String fileName, String text) throws Exception {
        FileWriter writer = new FileWriter(fileName);
        writer.write(text);
        writer.close();
    }
}
```

In the above `writeToFile` method, we first create a `FileWriter` object, which writes into the `fileName` file stored at the location specified as parameter. After this, we write into the file using the `write` method. The exception the constructor and `write` method can possibly throw has to be handled either with the help of a `try-catch` block or delegating the responsibility. In the method `writeToFile` the responsibility was delegated.

Let's create a main method where we call the `writeToFile` method of a `FileHandler` object. The exception does not have to be handled in the `main` method either, but the method can declare to throw possibly an exception throw the definition `throws Exception`.
```java
public static void main(String[] args) throws Exception {
    FileHandler handler = new FileHandler();
    handler.writeToFile("diary.txt", "Dear Diary, today was a nice day.");
}
```
When we call the method above, we create the file "diary.txt", where we write the text "Dear Diary, today was a nice day.". If the file exists already, the old content is erased and the new one is written. FileWriter allows us to add text at the end of the already existing file by providing additional parameter `boolean append`, without erasing the existing text.    
Let's add the method `appendToFile()` to the class `FileHandler`; the method appends the text received as parameter to the end of the file.
```java
public class FileHandler {
    public void writeToFile(String fileName, String text) throws Exception {
        FileWriter writer = new FileWriter(fileName);
        writer.write(text);
        writer.close();
    }

    public void appendToFile(String fileName, String text) throws Exception {
        FileWriter writer = new FileWriter(fileName, true);
        writer.write(text);
        writer.close();
    }
}
```
In most of the cases, instead of writing text at the end of a file with the method append, it is easier to write all the file again.
