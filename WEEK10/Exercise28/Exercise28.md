# Exercise 28: Groups
In this exercise, we make organisms and groups of organisms which move around each other. The position of the organisms is reported by using a bidimensional coordinate system. Each position is defined by two numbers, the x and y coordinates. The x coordinate tells us how far from the "point zero" the position is horizontally, whereas the y coordinate tells u how far the position is vertically

Together with the exercise, you find the interface `Movable`, which represents things that can be moved from one place to another. The interface contains the method `void move(int dx, int dy)`. The parameter dx tells us how much the object moves on the x axis and dy tells us about the movement on the y axis.

Implement the classes `Organism` and `Group`, which are both movable. Implement all the functionality inside the package `movable`.

## Exercise 28.1: Implementing Organism
Create the class Organism in the package `movable`; let Organism implement the interface `Movable`. Organisms have to know their own position (x and y coordinates). 

The API of `Organism` has to be the following:
- public Organism(int x, int y)
  - it receives the x and y initial coordinates of the object
- public String toString()
  - it creates and returns a string which represents the object. The form should be the following "x: 3; y: 6". Note that the coordinates are separated by a semicolon (;)
- public void move(int dx, int dy)
  - it moves the object as much as it is specified by the arguments. The variable dx contains the x coordinate of the movement, whereas dy contains the y coordinate of the movement. For instance, if the value of the variable dx is 5, the object variable x has to be increased by five

Try our the functionality of Organism using the following code.
```java
Organism organism = new Organism(20, 30);
System.out.println(organism);
organism.move(-10, 5);
System.out.println(organism);
organism.move(50, 20);
System.out.println(organism);
```
```
x: 20; y: 30
x: 10; y: 35
x: 60; y: 55
```
## Exercise 28.2: Implementing Group
Create the class `Group` in the package `movable`; Group implements the interface `Movable`. The Group is made of various different objects which implement the interface `Movable`, and they have to be stored into a list construction, for instance.

The class `Group` should have the following API.

- public String toString()
  - it returns a string which describes the position of the group organisms, each organism is printed in its own line.
- public void addToGroup(Movable movable)
  - it adds a new objects which implements the interface Movable to the group.
- public void move(int dx, int dy)
  - it moves a group as much as it is defined by the arguments. Note that you will have to move each group organism.

Try out your program functionality with the following code.
```java
Group group = new Group();
group.addToGroup(new Organism(73, 56));
group.addToGroup(new Organism(57, 66));
group.addToGroup(new Organism(46, 52));
group.addToGroup(new Organism(19, 107));
System.out.println(group);
```
```
x: 73; y: 56
x: 57; y: 66
x: 46; y: 52
x: 19; y: 107
```
