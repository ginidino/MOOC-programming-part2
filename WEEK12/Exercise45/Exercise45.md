# Exercise 45: Enum and Iterator

## Exercise 45.1: Education
Create the enumerated type, or enum, `Education` in the package `personnel`. The enum has the titles `D` (doctor), `M` (master), `B` (bachelor), `GRAD` (graduate).

## Exercise 45.2: Person
Create the class `Person` in `personnel`. Person is assigned a name and an education title as constructor parameters. Person has also a method to communicate their education, `public Education getEducation()`, as well as a `toString` method which returns the person information following the example below.
```java
Person arto = new Person("Arto", Education.D);
System.out.println(arto);
```
```
Arto, D
```
## Exercise 45.3: Employees
Create the class `Employees` in `personnel`. An Employees object contains a list of Person objects. The class has a parameterless constructor plus the following methods:

- `public void add(Person person)` adds the parameter person to the employees
- `public void add(List<Person> persons)` adds the parameter list of people to the employees
- `public void print()` prints all the employees
- `public void print(Education education)` prints all the employees, who have the same education as the one specified as parameter

> ATTENTION: The `Print` method of the class `Employees` have to be implemented using an iterator!

## Exercise 45.4: Firing
Create the method `public void fire(Education education)` in the class `Employees`. The method deletes all the employees whose education is the same as the method argument.

> ATTENTION: implement the method using an iterator!

Below, you find an example of the class usage:
```java
public class Main {

    public static void main(String[] args) {
        Employees university = new Employees();
        university.add(new Person("Matti", Education.D));
        university.add(new Person("Pekka", Education.GRAD));
        university.add(new Person("Arto", Education.D));

        university.print();

        university.fire(Education.GRAD);

        System.out.println("==");

        university.print();
}
```
Prints:
```
Matti, D
Pekka, GRAD
Arto, D
==
Matti, D
Arto, D
```
