# Object Polymorphism

If an object is a particular type, we can also represent it as Object-type. For instance, String is also Object-type, and all String variables can be defined using Object.
```java
String string = "string";
Object string = "another string";
```
It is possible to assign a String to an Object-type reference.
```java
String string = "characterString";
Object string = string;
```
The opposite way does not work. Because Object-type variables are not Strings, an Object variable cannot be assigned to a String variable.
```java
Object string = "another string";
String string = string; // DOESN'T WORK!
```
What is the real problem?

Variables have got their own type, and in addition to it they also have got the type of their parent classes and interfaces. The class String derives from the Object class, and therefore String objects are also Object-type. The class Object does not derive from the class String, and therefore Object variables are not automatically String-type.

The inheritance hierarchy lists the classes from which a class derives. The inherited classes are listed in hierarchical order, where the class we are analizing is the last one. As far as our String class inheritance hierarchy is concerned, we notice that the String class derives from the class Object. In Java, each class can derive from one class, tops; however, they can inherit features of more than one, undirectly.

You can think inheritance hierarchy as if it was a list of types, which the object has to implement.

The fact that all objects are Object-type helps programming. If we only need the features defined in the Object class in our method, we can use Object as method parameter. Because all objects are also Object-type, a method can be given whatever object as parameter. Let's create the method printManyTimes, which receives an Object variable as parameter, and the number of times this must be printed.
```java
public class Printer {
    ...
    public void printManyTimes(Object object, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(object.toString());
        }
    }
    ...
}
```
You can give whaterver object parameter to the method printManyTimes. Within the method printManyTimes, the object has only the method which are defined in the Object class at its disposal, because the method is presented as Object-type inside the mehod.
```java
Printer printer = new Printer();

String string = " o ";
List<String> words = new ArrayList<String>();
words.add("polymorphism");
words.add("inheritance");
words.add("encapsulation");
words.add("abstraction");

printer.printManyTimes(string, 2);
printer.printManyTimes(words, 3);
```
```
o
o
[polymorphism, inheritance, encapsulation, abstraction]
[polymorphism, inheritance, encapsulation, abstraction]
[polymorphism, inheritance, encapsulation, abstraction]
```

The String class implements the interfaces Serializable, CharSequence, and Comparable<String>. An interface is a type, too. According to the description of the String API, we should be able to set the following interfaces as the type of a String object.
```java
Serializable serializableString = "string";
CharSequence charSequenceString = "string";
Comparable<String> comparableString = "string";
```
Because we can define the parameter type of a method, we can define methods which would accept an object which implements a specific interface. When we define an interface as method parameter, the parameter can be whatever object which implements such interface, the method does not care about the object actual type.

Let's implement our Printer class, and create a method to print the characters of the objects which implement the interface CharSequence. The CharSequence interface also provides methods such as int length(), which returns the String's length, and char charAt(int index), which returns the character at a specific index.
```java
public class Printer {
    ...
    public void printManyTimes(Object object, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(object.toString());
        }
    }

    public void printCharacters(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            System.out.println(charSequence.charAt(i);
        }
    }
    ...
}
```
Whatever object which implements the CharSequence interface can be assigned to the method printCharacters. For instance, you can give a String or a StringBuilder which is usually more efficient when it comes to string building. The method printCharacters prints each character of the object in its own line.
```java
Printer printer = new Printer();

String string = "works";

printer.printCharacters(string);
```
```
w
o
r
k
s
```
