# Exercise 30: Container

class `Container`, with the following constructor and methods:

- public Container(double capacity)
  - It creates an empty container, whose capacity is given as argument; an improper capacity (<=0) creates a useless container, whose capacity is 0.
- public double getVolume()
  - It returns the volume of product in the container.
- public double getOriginalCapacity()
  - It returns the original capacity of the container, that is to say what the constructor was originally given.
- public double getCurrentCapacity()
  - It returns the actual capacity of the container.
- public void addToTheContainer(double amount)
  - It adds the specified amount of things to the container. If the amount is negative, nothing changes; if a part of that amount fits but not the whole of it, the container is filled up and the left over is thrown away.
- public double takeFromTheContainer(double amount)
  - We take the specified amount form the container, the method returns what we receive. If the specified amount is negative, nothing happens and zero is returned. If we ask for more than what there is in the container, the method returns all the contents.
- public String toString()
  - It returns the state of an object in String form like `volume = 64.5, free space 123.5`

In this exercise, create various different containers out of our `Container` class. Attention! Create all the classes in the package `containers`.

## Exercise 30.1: Product Container, Phase 1
The class `Container` has control on the operations regarding the amount of a product. Now, we also want that products have their name and handling equipment. Program `ProductContainer`, a subclass of `Container`! 
first implement a single object variable for the name of the contained product, a constructor and a getter for the name:

- public ProductContainer(String productName, double capacity)
  - It creates an empty product container. The product name and the container capacity are given as parameters.
- public String getName()
  - It returns the product name.

Remember in what way the constructor can make use of its upper class constructor in its first line!

Example:
```java
ProductContainer juice = new ProductContainer("Juice", 1000.0);
juice.addToTheContainer(1000.0);
juice.takeFromTheContainer(11.3);
System.out.println(juice.getName()); // Juice
System.out.println(juice);           // volume = 988.7, free space 11.3
```
```
Juice
volume = 988.7, free space 11.3
```

## Exercise 30.2: Product Container, Phase 2
As you see from the example above, the toString() method inherited by `ProductContainer` does not know anything about the product name (of course!). Something must be done for it! Let's also add a setter for the product name, at the same time:

- public void setName(String newName) sets a new name to the product.
- public String toString() returns the object state in String form, like Juice: volume = 64.5, free space 123.5

The new `toString()` method could be programmed using the getter inherited from the superclass, retrieving the values of inherited but hidden values field values. However, we have programmed the superclass in a way that it is already able to produce the container situation in String form: why should we bother to program this again? Make use of the inherited `toString`.

Remember that an overwritten method can still be called in its subclass, where we overwrite it!

Use demonstration:
```java
        ProductContainer juice = new ProductContainer("Juice", 1000.0);
        juice.addToTheContainer(1000.0);
        juice.takeFromTheContainer(11.3);
        System.out.println(juice.getName()); // Juice
        juice.addToTheContainer(1.0);
        System.out.println(juice);           // Juice: volume = 989.7, space 10.299999999999955
```
```
Juice
Juice: volume = 989.7, free space 10.299999999999955
```
## Exercise 30.3: Container History
Sometimes, it can be interesting to know in what way the container situation has changed: is the container often rather empty or full, is the fluctuation considerable or not, and so on. Let's provide our `ProductContainer` class with the ability to record the container history.

Let's start by designing a useful tool.

We could directly implement an ArrayList<Double> object to track our container history in the class ProductConteiner; however, now we create a specific tool for this purpose. The tool has to encapsulate an ArrayList<Double> object.

ContainerHistory public constructor and methods:
```java
public ContainerHistory() creates an empty ContainerHistory object.
public void add(double situation) adds the parameter situation to the end of the container history.
public void reset() it deletes the container history records.
public String toString() returns the container history in the form of a String. The String form given by the ArrayList class is fine and doesn't have to be modified.
```
## Exercise 30.4: ContainerHistory.java, Phase 2
Implement analysis methods for your ContainerHistory class:

- public double maxValue() reutrns the greatest value in the container history. If the history is empty, the method returns 0.
- public double minValue() reutrns the smallest value in the container history. If the history is empty, the method returns 0.
- public double average() reutrns the average of the values in the container history. If the history is empty, the method returns 0.

## Exercise 30.5: ContainerHistory.java, Phase 3
Implement analysis methods for your ContainerHistory class:

- public double greatestFluctuation() returns the absolute value of the single greatest fluctuation in the container history (attention: a fluctuation of -5 is greater than 4). If the history is empty or it contains one value, the method returns zero. Absolute value is the distance of a number from zero. For instance the absolute value of -5.5 is 5.5, and the absolute value of 3.2 is 3.2.
- public double variance() returns the sample variance of the container history values. If the history is empty or it contains only one value, the method returns zero.

## Exercise 30.6: Product Container Recorder, Phase 1
Implement the class ProductContainerRecorder which inherits ProductContainer. In addition to the old methods, the new version provides services for the container history. The hisotry is handled with a ContainerHistory object.

The public constructor and methods:

- public ProductContainerRecorder(String productName, double capacity, double initialVolume) creates a product container. The product name, capacity, and original volume are given as parameter. Record the original volume both as the stored product original volume and as the first value of the container history.
- public String history() returns the container history in the following form: [0.0, 119.2, 21.2]. Use the String printout form as it is.
Attention: now we remember only the original volume.

Example:
```java
// the well known way:
ProductContainerRecorder juice = new ProductContainerRecorder("Juice", 1000.0, 1000.0);
juice.takeFromTheContainer(11.3);
System.out.println(juice.getName()); // Juice
juice.addToTheContainer(1.0);
System.out.println(juice);           // Juice: volume = 989.7, free space 10.3
...
// history() does not work properly, yet:
System.out.println(juice.history()); // [1000.0]
   // in fact, we only retrieve the original value which was given to the constructor...
...
```
Printing:
```
Juice
Juice: volume = 989.7, free space 10.299999999999955
[1000.0]
```
## Exercise 30.7: Product Container Recorder, Phase 2
It's time to pick up history! The first version of our history knew only the original value. Implement the following methods:

- public void addToTheContainer(double amount); this works like the method in Container, but the new situation is recorded in the history. 
> Attention: you have to record the product volume in the container after the addition, not the amount which was added!
- public double takeFromTheContainer(double amount); it works like the method in Container, but the new situation is recorded in the history.
> Attention: you have to record the product volume in the container after the operation, not the amount which was removed!
Use example:
```java
// the well known way:
ProductContainerRecorder juice = new ProductContainerRecorder("Juice", 1000.0, 1000.0);
juice.takeFromTheContainer(11.3);
System.out.println(juice.getName()); // Juice
juice.addToTheContainer(1.0);
System.out.println(juice);           // Juice: volume = 989.7, free space 10.3
...
// but now we have our history record
System.out.println(juice.history()); // [1000.0, 988.7, 989.7]
...
```
Printing:
```
Juice
Juice: volume = 989.7, free space 10.299999999999955
[1000.0, 988.7, 989.7]
```
Remember how an overwritten method can be used inside the method that overwrites it!

## Exercise 30.8: Product Container Recorder, Phase 3
Implement the following method:

- public void printAnalysis(), which prints the history information regarding the product, following the exercise below:

Use example:
```java
ProductContainerRecorder juice = new ProductContainerRecorder("Juice", 1000.0, 1000.0);
juice.takeFromTheContainer(11.3);
juice.addToTheContainer(1.0);
//System.out.println(juice.history()); // [1000.0, 988.7, 989.7]

juice.printAnalysis();
```
The method printAnalysis prints:
```
Product: Juice
History: [1000.0, 988.7, 989.7]
Greatest product amount: 1000.0
Smallest product amount: 988.7
Average: 992.8
Greatest change: 11.299999999999955
Variance: 39.129999999999676
```
## Exercise 30.9: Product Container Recorder, Phase 4
Fill the analysis so that it prints the greatest fluctuation and the history variance.
