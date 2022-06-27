# Exercise 29: Person and their Heirs

## Exercise 29.1: Person
Create the package `people` and the class `Person` in it; Person works in relation to the following main program:
```java
    public static void main(String[] args) {
        Person pekka = new Person("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa");
        Person esko = new Person("Esko Ukkonen", "Mannerheimintie Street 15 00100 Helsinki");
        System.out.println(pekka);
        System.out.println(esko);
    }
```
Printing
```
Pekka Mikkola
  Korsontie Street 1 03100 Vantaa
Esko Ukkonen
  Mannerheimintie Street 15 00100 Helsinki
```
## Exercise 29.2: Student
Create the class `Student` which inherits the class `Person`.

Students have 0 credits, at the beginning. As long as a student studies, their credits grow. Create the class, in relation to the following main program:
```java
    public static void main(String[] args) {
        Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
        System.out.println(olli);
        System.out.println("credits " + olli.credits());
        olli.study();
        System.out.println("credits "+ olli.credits());
    }
```
Prints:
```
Olli
  Ida Albergintie Street 1 00400 Helsinki
credits 0
credits 1
```
## Exercise 29.3: toString for Studets
The `Student` in the previous exercise inherits their toString method from the class `Person`. Inherited methods can also be overwritten, that is to say replaced with another version. Create now an own version of the toString method for `Student`; the method has to work as shown below:
```java
    public static void main(String[] args) {
        Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
        System.out.println( olli );
        olli.study();
        System.out.println( olli );
    }
```
Prints:
```
Olli
  Ida Albergintie Street 1 00400 Helsinki
  credits 0
Olli
  Ida Albergintie Street 1 00400 Helsinki
  credits 1
```
## Exercise 29.4: Teacher
Create the class `Teacher` in the same package. Teacher inherits `Person`, but they also have a salary, which together with the teacher information in String form.

Check whether the following main program generates the prinout below
```java
    public static void main(String[] args) {
        Teacher pekka = new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200);
        Teacher esko = new Teacher("Esko Ukkonen", "Mannerheimintie 15 Street 00100 Helsinki", 5400);
        System.out.println( pekka );
        System.out.println( esko );

        Student olli = new Student("Olli", "Ida Albergintie 1 Street 00400 Helsinki");
        for ( int i=0; i < 25; i++ ) {
            olli.study();
        }
        System.out.println( olli );
    }
```
Printing
```
Pekka Mikkola
  Korsontie Street 1 03100 Vantaa
  salary 1200 euros/month
Esko Ukkonen
  Mannerheimintie Street 15 00100 Helsinki
  salary 5400 euros/month
Olli
  Ida Albergintie Street 1 00400 Helsinki
  credits 25
```
## Exercise 29.5: Everyone in a List
Implement the method `public static void printDepartment(List<Person> people)` in the Main class, default package. The method prints all the people in the parameter list. When the main method is called, printDepartment should work in the following way.
```java
    public static void printDepartment(List<Person> people) {
       // we print all the people in the department
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>();
        people.add( new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200) );
        people.add( new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki") );

        printDepartment(people);
    }
```
```
Pekka Mikkola
  Korsontie Street 1 03100 Vantaa
  salary 1200 euros/month
Olli
  Ida Albergintie Street 1 00400 Helsinki
  credits 0
```
