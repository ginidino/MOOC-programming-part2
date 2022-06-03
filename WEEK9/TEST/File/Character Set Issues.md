# Character Set Issues

When we read a text file (or when we save something into a file), Java has to find out the character set used by the operating system. Knowledge of the character set is required both to save text on the computer harddisk in binary format, and to translate binary data into text.

There have been developed standard character sets, and "UTF-8" is the most common nowadays. UTF-8 character set contains both the alphabet letters of everyday use and more particular characters such as the Japanese kanji characters or the information need to read and save the chess pawns. From a simplified programming angle, we could think a character set both as a character-number hashmap and a number-character hashmap. The character-number hashmap shows what binary number is used to save each character into a file. The number-character hashmap shows how we can translate into characters the values we obtain reading a file.

Almost each operating system producer has also got their own standards. Some support and want to contribute to the use of open source standards, some do not. If you have got problems with the use of Scandinavian characters such as ä and ö (expecially Mac and Windows users), you can tell which character set you want to use when you create a Scanner object. In this course, we always use the the "UTF-8" character set.

You can create a Scanner object which to read a file which uses the UTF-8 character set in the following way:

```java
File f = new File("examplefile.txt");
Scanner reader = new Scanner(f, "UTF-8");
```

Anther thing you can do to set up a character set is using an environment variable. Macintosh and Windows users can set up an the value of the environment variable JAVA_TOOL_OPTIONS to the string -Dfile.encoding=UTF8. In such case, Java always uses UTF-8 characters as a default.
