# Exercise 27: The Finnish Ringing Centre

## Exercise 27.1: Bird equals and toString
The Finnish Ringing Centre stores the information about the birds who were watched in a specific year in Bird objects:
```java
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }

    @Override
    public String toString() {
        return this.latinName + "(" + this.ringingYear + ")";
    }
}
```
The idea is implementing the funcionality for the ringing centre to track of the places where rung birds were observed and how many times they were. However, observation places and times are not stored in Bird objects, but in a separate HashMap, whose keys are Bird objects. As we remember from Week 2, in such cases we have to implement the methods equals(Object other) and hashCode() in the class Bird.

Some birds have more than one English name (for instance, the Rose Starling is also known as Rose-Coloured Starling or Rose-Coloured Pastor); however, the Latin name is always unique. Create the methods equals and hashCode- in the class Bird; two Bird objects have to be understood as the same bird if their Latin name and observation year are the same.

Example:
```java
Bird bird1 = new Bird("Rose Starling", "Sturnus roseus", 2012);
Bird bird2 = new Bird("Rose-Coloured Starling", "Sturnus roseus", 2012);
Bird bird3 = new Bird("Hooded Crow", "Corvus corone cornix", 2012);
Bird bird4 = new Bird("Rose-Coloured Pastor", "Sturnus roseus", 2000);

System.out.println( bird1.equals(bird2));   // same Latin name and same observation year: they are the same bird
System.out.println( bird1.equals(bird3));   // different Latin name: they are not the same bird
System.out.println( bird1.equals(bird4));   // different observation year: not the same bird
System.out.println( bird1.hashCode()==bird2.hashCode() );
```
Prints:
```
true
false
false
true
```
## Exercise 27.2: Ringing Centre
The Ringing Centre has two methods: public void observe(Bird bird, String place), which records the observation and its place among the bird information; and public void observations(Bird bird), which prints all the observations of the parameter bird following the example below. The observation printing order is not important, as far as the tests are concerned.

The Ringing Centre stores the observation places in a Map<Bird, List<String>> object variable. If you need, you can use the exercise from Section 16 as example.

An example of how the Ringing Centre works:
```java
RingingCentre kumpulaCentre = new RingingCentre();

kumpulaCentre.observe( new Bird("Rose Starling", "Sturnus roseus", 2012), "Arabia" );
kumpulaCentre.observe( new Bird("Rose-Coloured Starling", "Sturnus roseus", 2012), "Vallila" );
kumpulaCentre.observe( new Bird("European Herring Gull", "Larus argentatus", 2008), "Kumpulanmäki" );
kumpulaCentre.observe( new Bird("Rose Starling", "Sturnus roseus", 2008), "Mannerheimintie" );

kumpulaCentre.observations( new Bird("Rose-Coloured Starling", "Sturnus roseus", 2012 ) );
System.out.println("--");
kumpulaCentre.observations( new Bird("European Herring Gull", "Larus argentatus", 2008 ) );
System.out.println("--");
kumpulaCentre.observations( new Bird("European Herring Gull", "Larus argentatus", 1980 ) );
```
Prints:
```
Sturnus roseus (2012) observations: 2
Arabia
Vallila
--
Larus argentatus (2008) observations: 1
Kumpulanmäki
--
Larus argentatus (1980) observations: 0
```
