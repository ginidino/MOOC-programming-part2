# Enum & Iterator
## Enum: Enumerated Type
```java
public class Card {

    public static final int DIAMONDS = 0;
    public static final int SPADES = 1;
    public static final int CLUBS = 2;
    public static final int HEARTS = 3;

    private int value;
    private int suit;

    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return suitName() + " "+value;
    }

    private String suitName() {
        if (suit == 0) {
            return "DIAMONDS";
        } else if (suit == 1) {
            return  "SPADES";
        } else if (suit == 2) {
            return "CLUBS";
        }
        return "HEARTS";
    }

    public int getSuit() {
        return suit;
    }
}
```
Card suits are stored as object variable integers. You can use constants to help with readability to make it easier to mark your case. Constants representing cards and suits are used in the following ways:
```java
public static void main(String[] args) {
        Card card = new Card(10, Card.HEARTS);

        System.out.println(card);

        if (card.getSuit() == Card.CLUBS) {
            System.out.println("It's clubs");
        } else {
            System.out.println("It's not clubs");
        }

}
```
Representing the suit as a number is a bad solution, because the following absurd ways to use cards are possible:
```java
Card absurdCard = new Card(10, 55);

System.out.println(absurdCard);

if (absurdCard.getSuit() == 34) {
    System.out.println("The card's suit is 34");
} else {
    System.out.println("The card's suit is not 34");
}

int suitPower2 = absurdCard.getSuit() * absurdCard.getSuit();

System.out.println("The card's suit raised to the power of two is " + suitPower2);
```
If already know the possible values of a variable, able to use an `enum` class to represent the variable. In addition to being classes and interfaces, enumerated types are also a class type of their own. Enums are defined with the `enum` keyword. For example, the following `Suit` enum class defines four values: `DIAMONDS`, `SPADES`, `CLUBS`, and `HEARTS`.
```java
public enum Suit {
    DIAMONDS, SPADES, CLUBS, HEARTS
}
```
In its most basic from, `enum` lists its constant values divided by a comma. Enum constants are usually written in capital letters. Enums are usually created in their own files in the same way as classes and interfaces. In Netbeans, you can create an enum by clicking on the *new/other/java/java enum* in the project name.

The following `Card` class is represented with the help of enum:
```java
public class Card {

    private int value;
    private Suit suit;

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return suit + " "+value;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
}
```
The new version of the card is used in the following way:
```java
public class Main {

    public static void main(String[] args) {
        Card first = new Card(10, Suit.HEARTS);

        System.out.println(first);

        if (first.getSuit() == Suit.CLUBS) {
            System.out.println("It's clubs");
        } else {
            System.out.println("It's not clubs");
        }

    }
}
```
```
HEARTS 10
It's not clubs
```
## More about Enums
Create an enum containing the object variables and implement the interface.

### Enumerated Type Constructor Parameters
Enum-type can contain object variables. Object variable values must be set in the constructor of a class defined as an enum. Enum-type classes cannot have `public` constructors.
```java
public enum Colour {
    RED("red"), // the constructor parameters are defined as constant values when they are read
    GREEN("green"),
    BLUE("blue");

    private String name; // object variable

    private Colour(String name) { // constructor
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
```
The enumerated value `Color` can be used in the following ways:
```java
System.out.println(Colour.GREEN.getName());
```
```
green
```

## Iterator
The `Hand` class that represents the card the player is holding in their hand in a card game
```java
public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<Hand>();
    }

    public void add(Card card){
        cards.add(card);
    }

    public void print(){
        for (Card card : cards) {
            System.out.println( card );
        }
    }
}
```
The `print` method prints each card in the hand using the "for each" statement. ArrayList and other "object containers" that implement the *Collection* interface indirectly implement the Iterable interface. Objects that implement Iterable can be parsed or better `"iterate"` using statements like *for each*.

Object containers can also iterate over a specific collection of objects, using so-called *iterators*, objects that are thought to parse. 

version of the iterator used to print the card.
```java
public void print() {
    Iterator<Card> iterator = cards.iterator();

    while ( iterator.hasNext() ){
        System.out.println( iterator.next() );
    }
}
```
Iterators are taken from the ArrayList `cards`. An iterator is like a finger that always points to a specific object in the list, first, second, third, and so on, until the finger passes through each object.

Iterators provide several methods. The `hasNext()` method asks if there are still objects to iterate over. If there is, you can use the `next()` method to retrieve the next object. The method returns the following object in the collection, and makes the iterator -- the "finger" -- point out the following object.

The object reference returned from the Iterator's `next()` method can of course be stored in a variable. In fact, we can modify the print method in the following way:
```java
public void print(){
    Iterator<Card> iterator = cards.iterator();

    while ( iterator.hasNext() ){
        Card nextCard = iterator.next();
        System.out.println( nextCard );
    }
}
```
Able to create a way to delete cards that are less than a certain value.
```java
public class Hand {
    // ...

    public void deleteWorst(int value) {
        for (Card card : cards) {
            if ( card.getValue() < value ) {
                cards.remove(card);
            }
        }
    }
}
```
Notice that running the method causes a strange error:
```
Exception in thread "main" java.util.ConcurrentModificationException
        at java.util.AbstractList$Itr.checkForComodification(AbstractList.java:372)
        at java.util.AbstractList$Itr.next(AbstractList.java:343)
        at Hand.deleteWorst(Hand.java:26)
        at Main.main(Main.java:20)
Java Result: 1
```
- The reason : cannot delete objects from a list while you are parsing it: the for each statement "gets all worked up".

If want to delete part of an object while parsing the list, you need to use an iterator. By calling the `remove` method of an iterator object, you can cleanly delete the value returned by the iterator with a previous next method call. The following method works fine.
```java
public class Hand {
    // ...

    public void deleteWorst(int value) {
        Iterator<Card> iterator = cards.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getValue() < value) {
                // delete the object returned by the iterator with its previous method call
                iterator.remove();
            }
        }
    }
}
```
