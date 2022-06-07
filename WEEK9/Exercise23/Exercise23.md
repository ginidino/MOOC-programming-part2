# Exercise 23: Word Inspection

Create the class WordInspection, which allows for different kinds of analyses on words. Implement the class in the package wordinspection.

The Institute for the Languages of Finland (Kotimaisten kielten tutkimuskeskus, Kotus) has published online a list of Finnish words. In this exercise we use a modified version of that list, which can be found in the exercise source folder src with the name wordList.txt; the relative path is "src/wordList.txt". Because the word list if quite long, in fact, a shortList.txt was created in the project for the tests; the file can be found following the path "src/shortList.txt".

If you have problems with Scandinavian letters (Mac and Windows users) create your Scanner object assigning it the "UTF-8" character set, in the following way: Scanner reader = new Scanner(file, "UTF-8"); Problems come expecially when the tests are executed.

## Exercise 23.1: Word Count
Create the constructor public WordInspection(File file) to your WordInspection class. The constructor creates a new WordInspection object which inspects the given file.

Create the method public int wordCount(), which counts the file words and prints their number. In this part, you don't have to do anything with the words, you should only count how many there are. For this exercise, you can expect there is only one word in each row.

## Exercise 23.2: z
Create the method public List<String> wordsContainingZ(), which returns all the file words which contain a z; for instance, jazz and zombie.

## Exercise 23.3: Ending l
Create the method public List<String> wordsEndingInL(), which returns all the Finnish words of the file which end in l; such words are, for instance, kannel and sammal.

- Attention! If you read the file various different times in your program, you notice that your code contains a lot of copy-paste, so far. It would be useful to think whether it would be possible to read the file in an different place, maybe inside the constructor or as a method, which the constructor calls. In such case, the methods could use a list which was read before and then create a new list which suits their search criteria. In week 12, we will come back again with an ortodox way to eliminate copy-paste.

## Exercise 23.4: Palindromes
Create the method public List<String> palindromes(), which returns all the palindrome words of the file. Such words are, for instance, ala and enne.

## Exercise 23.5: All Vowels
Create the method public List<String> wordsWhichContainAllVowels(), which returns all the words of the file which contain all Finnish vowels (aeiouyäö). Such words are, for instance, myöhäiselokuva and ympäristönsuojelija.
