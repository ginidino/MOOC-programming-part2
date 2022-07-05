# Exercise 32: Different Boxes
Together with the exercise body - find the classes `Thing` and `Box`.   
The class `Box` is abstract, and it is programmed so that adding things always implies calling the method `add`. The `add` method, resposible of adding one thing, is abstract, and any box which inherits the class `Box` has to implement the method `add`. Your task is modifying the class `Thing` and implementing various different boxes based on `Box`.

Add all new classes to the package `boxes`.
```java
package boxes;

import java.util.Collection;

public abstract class Box {

    public abstract void add(Thing thing);

    public void add(Collection<Thing> things) {
        for (Thing thing : things) {
            add(thing);
        }
    }

    public abstract boolean isInTheBox(Thing thing);
}
```
## Exercise 32.1: Modifications to Thing
Add an inspection to the constructor of `Thing`, to make sure that the thing's weight is never negative (weight 0 is accepted). If the weight is negative, the constructor has to throw an `IllegalArgumentException`. Also implement the methods `equals` and `hashCode` in the class `Thing`, allowing you to use the `contains` method of different lists and collections. Implement the methods without taking into consideration the value of the object variable `weight`. 

## Exercise 32.2: Maximum Weight Box
Implement the class `MaxWeightBox` in the package `boxes`; the class inherits `Box`.    
`MaxWeightBox` has the constructor `public MaxWeightBox(int maxWeight)`, which determines the box maximum weight.   
`Things` can be added to `MaxWeightBox` if and only if the thing weight does not exceed the box weight.
```java
MaxWeightBox coffeeBox = new MaxWeightBox(10);
coffeeBox.add(new Thing("Saludo", 5));
coffeeBox.add(new Thing("Pirkka", 5));
coffeeBox.add(new Thing("Kopi Luwak", 5));

System.out.println(coffeeBox.isInTheBox(new Thing("Saludo")));
System.out.println(coffeeBox.isInTheBox(new Thing("Pirkka")));
System.out.println(coffeeBox.isInTheBox(new Thing("Kopi Luwak")));
```
```
true
true
false
```
## Exercise 32.3: One-Thing Box and Black-Hole Box
Next, implement the class `OneThingBox` in the package `boxes`; the class inherits `Box`.    
`OneThingBox` has the constructor `public OneThingBox()`, and only one thing can fit there. If the box already contains one thing, this should not be changed. The `weight` of the added thing is not important.
```java
OneThingBox box = new OneThingBox();
box.add(new Thing("Saludo", 5));
box.add(new Thing("Pirkka", 5));

System.out.println(box.isInTheBox(new Thing("Saludo")));
System.out.println(box.isInTheBox(new Thing("Pirkka")));
```
```
true
false
```
Next, implement the class `BlackHoleBox` in the package `boxe`s; the class inherits `Box`.    
`BlackHoleBox` has the constructor `public BlackHoleBox()`; any thing can be added to a black-hole box, but none will be found when you'll look for them. In other words, adding things must always work, but the method `isInTheBox` has to return always false.
```java
BlackHoleBox box = new BlackHoleBox();
box.add(new Thing("Saludo", 5));
box.add(new Thing("Pirkka", 5));

System.out.println(box.isInTheBox(new Thing("Saludo")));
System.out.println(box.isInTheBox(new Thing("Pirkka")));
```
```
false
false
```
