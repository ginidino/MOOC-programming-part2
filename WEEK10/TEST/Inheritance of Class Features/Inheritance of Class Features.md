# Inheritance of Class Features
Classes are a way for programmers to clarify problematic concepts. With each class we create, we add new functionality to our programming language. Functionality is needed to solve the problems we encounter, and solutions are born from the interactions between the objects we create. In object programming, an object is an independent entity that can be changed through methods. Objects are used together. Each object has its own area of responsibility. For example, our user interface class so far uses the `Scanner` object.

Each class in Java descends from the `Object` class, which means that each class we create will have all methods defined in `Object`. If you want to change the functionality of a method defined in `Object`, you must `Override` that method and define the new functionality in the generated class.

In addition to extending the `Object` class, it is also possible to extend other classes. If you check Java's ArrayList class API, you will see that `ArrayList` inherits class `AbstractList`. The `AbstractList` class inherits the `AbstractCollection` class, which is derived from the `Object` class.
```java
java.lang.Object
  java.util.AbstractCollection<E>
      java.util.AbstractList<E>
          java.util.ArrayList<E>
```

Each class can directly inherit one class. Indirectly, a class can still inherit all the functionality of its parent class. The `ArrayList` class directly inherits from the `AbstractList` class and indirectly from the AbstractCollection and Object classes. In fact, the `ArrayList` class has methods and interfaces for `AbstractList`, `AbstractCollection`, and `Object`.

Class functionality is inherited using the `extends` keyword. A class that inherits is called a subclass. The inherited class is called a superclass. Let's learn about the car maker system that handles auto parts. The basic component of component handling is the `Component` class, which defines an identification number, producer, and description.

```java
public class Component {

    private String id;
    private String producer;
    private String description;

    public Component(String id, String producer, String description) {
        this.id = id;
        this.producer = producer;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getProducer() {
        return producer;
    }
}
```
One of the automotive components is a motor. As with all other components, a motor also has a producer, identification number and description. There are also types of motors such as combustion engines, electric motors, or hybrids. Let's create a Motor class that extends Component. A `Motor` is a specific case of a `component`.

```java
public class Motor extends Component {

    private String motorType;

    public Motor(String motorType, String id, String producer, String description) {
        super(id, producer, description);
        this.motorType = motorType;
    }

    public String getMotorType() {
        return motorType;
    }
}
```
The class definition `public class Motor extends Component` tells us that the `Motor` class inherits the functionality of the `Component`. Define an object variable `motorType` in the `Motor` class.

The `Motor` class constructor is interesting. In the first line of the constructor you can see the keyword `super` used to call the superclass constructor. calls `super(id,producer,description)` class constructor `public Component(String id, String producer, String description)` class `Component` defined in class; In this way, values are assigned to superclass object variables. After doing this we assign a value to the object variable `motorType`.

When the `Motor` class inherits from the `Component` class, in receives all methods provided by the `Component`. You can instantiate the `Motor` class just like any other class.

```java
Motor motor = new Motor("combustion engine", "hz", "volkswagen", "VW GOLF 1L 86-91");
System.out.println(motor.getMotorType());
System.out.println(motor.getProducer());
```
```
combustion engine
volkswagen
```
> As you can see, the Motor class can freely use the methods defined in the Component.

