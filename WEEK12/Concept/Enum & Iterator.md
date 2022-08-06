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
