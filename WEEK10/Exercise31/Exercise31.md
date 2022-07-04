# Exercise 31: Farm Simulator
> create a farm simulator, where we simulate the life in a farm. Note that the program does not make us of inheritance, and the interface use is scarce. With programs, we often create a first version which we improve later on. Typically, we don't already understand the scope of the problem when we implement the first version; planning interfaces and inheritance hierarchy may be difficult and it may slow down the work.

Dairy farms have got milking animals; they do not handle milk themselves, but milk trucks transport it to dairy factories which process it into a variety of milk products. Each dairy factory is specialised in one product type; for instance, a cheese factory produces cheese, a butter factory produces butter, and a milk factory produces milk.

Let's create a simulator which represents the milk course of life. Implement all the classes in the package `farmsimulator`.

## Exercise 31.1: Bulk Tank
Milk has to be stored in bulk tanks in good conditions. Bulk tanks are produced both with a standard capacity of 2000 litres, and with customer specific capacity. 

Create the class `BulkTank`, with the following constructors and methods.
- public BulkTank()
- public BulkTank(double capacity)
- public double getCapacity()
- public double getVolume()
- public double howMuchFreeSpace()
- public void addToTank(double amount)
  - adds to the tank only as much milk as it fits; the additional milk will not be added, and you don't have to worry about a situation where the milk spills over
- public double getFromTank(double amount) 
  - takes the required amount from the tank, or as much as there is left

Also, implement the toString method for your `BulkTank`. The `toString` method describes the tank situation by rounding down the litres using the `ceil()` method of class `Math`.

Test your bulk tank with the following program chunk:
```java
BulkTank tank = new BulkTank();
tank.getFromTank(100);
tank.addToTank(25);
tank.getFromTank(5);
System.out.println(tank);

tank = new BulkTank(50);
tank.addToTank(100);
System.out.println(tank);
The program print output should look like the following:
```
```
20.0/2000.0
50.0/50.0
```
Note that when you call the `println()` method of the `out` object of class `System`, the method receives as paramater an `Object` variable; in such case, the print output is determined by the overwritten `toString()` method in `BulkTank`! We are in front of a case of polymorphism, because the method can work with different types.

## Exercise 31.2: Cow
If we want to produce milk, we also need `cows`. Cows have got names and udders. Udder capacity is a random value between 15 and 40; the class Random can be used to raffle off the numers, for instance, `int num = 15 + new Random().nextInt(26)`;. 

The class Cow has the following functionality:
- public Cow() 
  - creates a new cow with a random name
- public Cow(String name) 
  - creates a new cow with its given name
- String getName() 
  - returns the cow's name
- double getCapacity() 
  - returns the udder capacity
- double getAmount() 
  - returns the amount on milk available in the cow's udders
- String toString() 
  - returns a String which describes the cow (see the example below)

Cow also implement the following interfaces:    
`Milkable`, which describes the cow's faculty for being milked
```java
public interface Milkable {
    public double milk();
}
```
`Alive`, which represents their faculty for being alive
```java
public interface Alive {
    public void liveHour();
}
```
When a cow is milked, all their milk provision is taken to be processed. As long as a cow lives, their milk provision increases slowly. In Finland, milking cows produce 25-30 litres of milk every day, on the average. We simulate this by producing 0.7-2 litres every hour.

If a cow is not given a name, they are assigned a random one from the list below.
```java
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
```
Implement the class Cow, and test whether it works with the following program body.
```java
Cow cow = new Cow();
System.out.println(cow);


Alive livingCow = cow;
livingCow.liveHour();
livingCow.liveHour();
livingCow.liveHour();
livingCow.liveHour();

System.out.println(cow);

Milkable milkingCow = cow;
milkingCow.milk();

System.out.println(cow);
System.out.println("");

cow = new Cow("Ammu");
System.out.println(cow);
cow.liveHour();
cow.liveHour();
System.out.println(cow);
cow.milk();
System.out.println(cow);
```
The program print output can be like the following.
```
Liekki 0.0/23.0
Liekki 7.0/23.0
Liekki 0.0/23.0
Ammu 0.0/35.0
Ammu 9.0/35.0
Ammu 0.0/35.0
```

## Exercise 31.3: MilkingRobot
In modern dairy farms, milking robots handle the milking. The milking robot has to be connected to the bulk tank in order to milk an udder:

- public MilkingRobot() 
  - creates a new milking robot
- BulkTank getBulkTank() 
  - returns the connected bulk tank, or a null reference, if the tank hasn't been installed
- void setBulkTank(BulkTank tank) 
  - installs the parameter bulk tank to the milking robot
- void milk(Milkable milkable) 
  - milks the cow and fills the connected bulk tank; the method returns an IllegalStateException is no tank has been fixed

Implement the class `MilkingRobot`, and test it using the following program body. Make sure that the milking robot can milk all the objects which implement the interface `Milkable`!
```java
        MilkingRobot milkingRobot = new MilkingRobot();
        Cow cow = new Cow();
        milkingRobot.milk(cow);
```
```
Exception in thread "main" java.lang.IllegalStateException: The MilkingRobot hasn't been installed
        at farmsimulator.MilkingRobot.milk(MilkingRobot.java:17)
        at farmsimulator.Main.main(Main.java:9)
Java Result: 1
```
```java
MilkingRobot milkingRobot = new MilkingRobot();
Cow cow = new Cow();
System.out.println("");

BulkTank tank = new BulkTank();
milkingRobot.setBulkTank(tank);
System.out.println("Bulk tank: " + tank);

for(int i = 0; i < 2; i++) {
    System.out.println(cow);
    System.out.println("Living..");
    for(int j = 0; j < 5; j++) {
        cow.liveHour();
    }
    System.out.println(cow);

    System.out.println("Milking...");
    milkingRobot.milk(cow);
    System.out.println("Bulk tank: " + tank);
    System.out.println("");
}
```
The print output of the program can look like the following:
```
Bulk tank: 0.0/2000.0
Mella 0.0/23.0
Living..
Mella 6.2/23.0
Milking...
Bulk tank: 6.2/2000.0

Mella 0.0/23.0
Living..
Mella 7.8/23.0
Milking...
Bulk tank: 14.0/2000.0
```

## Exercise 31.4: Barn
`Cows` are kept (and in this case milked) in barns. The original barns have room for one milking robot. Note that when milking robots are installed, they are connected to a specific barn's bulk tank. If a barn does not have a milking robot, it can't be used to handle the cow, either. 

Implement the class Barn with the following constructor and methods:
- public Barn(BulkTank tank)
- public BulkTank getBulkTank() 
  - returns the barn's bulk tank
- public void installMilkingRobot(MilkingRobot milkingRobot) 
  - installs a milking robot and connects it to the barn bulk tank
- public void takeCareOf(Cow cow) 
  - milks the parameter cow with the help of the milking robot, the method throws an IllegalStateException if the milking robot hasn't been installed
- public void takeCareOf(Collection<Cow> cows) 
  - milks the parameter cows with the help of the milking robot, the method throws an IllegalStateException if the milking robot hasn't been installed
- public String toString() 
  - returns the state of the bulk tank contained by the barn

`Collection` is Java's own interface, and it represents collections' behaviour. For instance, the classes `ArrayList` and `LinkedList` implement the interface `Collection`. All instances of classes which implement `Collection` can be iterated with a `for-each` construction.

Test your class `Barn` with the help of the following program body. Do not pay to much attention to the class `LinkedList`; apparently, it works as `ArrayList`, but the implemantation in encapsulates is slightly different.
```java
Barn barn = new Barn(new BulkTank());
System.out.println("Barn: " + barn);

MilkingRobot robot = new MilkingRobot();
barn.installMilkingRobot(robot);

Cow ammu = new Cow();
ammu.liveHour();
ammu.liveHour();

barn.takeCareOf(ammu);
System.out.println("Barn: " + barn);

LinkedList<Cow> cowList = new LinkedList<Cow>();
cowList.add(ammu);
cowList.add(new Cow());

for(Cow cow: cowList) {
    cow.liveHour();
    cow.liveHour();
}

barn.takeCareOf(cowList);
System.out.println("Barn: " + barn);
```

The print output should look like the following:
```
Barn: 0.0/2000.0
Barn: 2.8/2000.0
Barn: 9.6/2000.0
```
  
## Exercise 31.5: Farm
`Farms` have got an owner, a barn and a herd of cows. `Farm` also implements our old interface `Alive`: calling the method `liveHour` makes all the cows of the farm live for an hour. You also have to create method `manageCows` which calls Barn's method `takeCareOf` so that all cows are milked. 

Implement your class `Farm`, and make it work according to the following example.
```java
Farm farm = new Farm("Esko", new Barn(new BulkTank()));
System.out.println(farm);

System.out.println(farm.getOwner() + " is a tough guy!");
```
Expected print output:
```
Farm owner: Esko
Barn bulk tank: 0.0/2000.0
No cows.
Esko is a tough guy!
```
```java
Farm farm = new Farm("Esko", new Barn(new BulkTank()));
farm.addCow(new Cow());
farm.addCow(new Cow());
farm.addCow(new Cow());
System.out.println(farm);
```
Expected print output:
```
Farm owner: Esko
Barn bulk tank: 0.0/2000.0
Animals:
        Naatti 0.0/19.0
        Hilke 0.0/30.0
        Sylkki 0.0/29.0
```
```java
Farm farm = new Farm("Esko", new Barn(new BulkTank()));

farm.addCow(new Cow());
farm.addCow(new Cow());
farm.addCow(new Cow());

farm.liveHour();
farm.liveHour();
System.out.println(farm);
```
Expected print output:
```
Farm owner: Esko
Barn bulk tank: 0.0/2000.0
Animals:
        Heluna 2.0/17.0
        Rima 3.0/32.0
        Ilo 3.0/25.0
```
```java
Farm farm = new Farm("Esko", new Barn(new BulkTank()));
MilkingRobot robot = new MilkingRobot();
farm.installMilkingRobot(robot);

farm.addCow(new Cow());
farm.addCow(new Cow());
farm.addCow(new Cow());


farm.liveHour();
farm.liveHour();

farm.manageCows();

System.out.println(farm);
```
Expected print output:
```
Farm owner: Esko
Barn bulk tank: 18.0/2000.0
Animals:
        Hilke 0.0/30.0
        Sylkki 0.0/35.0
        Hento 0.0/34.0
```
