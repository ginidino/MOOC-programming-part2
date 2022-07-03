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

## Private, Protected and Public
If a method or variable has `private` field accessibility, it is not visible to its subclasses, and there is no direct way for subclasses to access them. In the previous example, the motor cannot directly access the properties defined in the superclass Component(id, producer, description). 

A subclass naturally sees everything defined as `public` in its parent class.  

You can use `protected` field accessibility when you want to define a superclass variable or method whose accessibility should be restricted to only subclasses.

## Superclass
Superclass constructors are defined with the `super` keyword. In fact, calling `super` is similar to calling `this` constructor. The call is supplied with the required type value for the superclass constructor parameter.

Calling the constructor initializes the variables defined in the parent class. In fact, using a constructor call the same thing happens as a regular constructor call. A subclass constructor call must always have a call to the superclass constructor, unless the superclass has a parameterless constructor.

> Attention! The `super` call must always be in the first line!

## Calling Superclass Methods
Methods defined in a superclass can always be called using the `super` prefix. This is the same way as calling a method defined in `this` class with this prefix. For example, you can use a method that overrides the superclass `toString` method in the following way:
```java
@Override
public String toString() {
    return super.toString() + "\n  And my personal message again!";
}
```

## The Object Type defines the Called Method: Polymorphism
Methods that can be called are defined through variable types. For example, if a `Student` object reference is stored in a `Person` variable, the object can only use methods defined in the `Person` class
```java
Person olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
olli.credits();        // NOT WORKING!
olli.study();              // NOT WORKING!
String.out.println( olli );   // olli.toString() IT WORKS!
```
If an object has multiple types, you can use the methods defined by any type. For example, a Student object can use methods defined in both the Person class and Object.

In the previous exercise, we were in a `Student` class and replaced the `toString` method inherited from `Person` with the new version. I'm assuming you're using an object that throws a non-real type. So which version of the object method are you calling? For example, below are two `Student` whose references are stored in the Person and Object variables. We call the `toString` method of both.
```java
Person olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
String.out.println( olli );

Object liisa = new Student("Liisa", "Väinö Auerin Street 20 00500 Helsinki");
String.out.println( liisa );
```
```
Olli
  Ida Albergintie Street 1 00400 Helsinki
  credits 0
Liisa
  Väinö Auerin Street 20 00500 Helsinki
  credits 0
```

* More generally: the execution method is always chosen based on the object actual type, regardless of the type of variable used. Because objects vary, they can be used through different variable types. The execution method always depends on the actual type of the object. This diversity is called polymorphism.

## Another Example: Points
A point in a two-dimensional coordinate system can be represented using the following classes:
```java
public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int manhattanDistanceFromOrigin(){
        return Math.abs(x) + Math.abs(y);
    }
	
	protected String location(){
        return x + ", " + y;
    }
	
	@Override
    public String toString() {
        return "("+this.location()+") distance "+this.manhattanDistanceFromOrigin();
    }
}
```
The `location` methods must not be used outside of a class, and the accessibility field is protected so that only subclasses can access it.

A color point is similar to a point except that it contains a string that tells the color. You can create a class by inheriting Point.
```
public class ColouredPoint extends Point {
	private String colour;

	public ColouredPoint(int x, int y, String colour) {
		super(x, y);
		this.colour = colour;
	}
	
	@Override
    public String toString() {
        return super.toString() + " colour: " + colour;
    }
}
```
The class defines an object variable to store the color. Coordinates are stored in the superclass. The string representation should look like one of the points, but it should also show a color. The overridden `toString` method calls the superclass toString method and adds the point color.

The following example creates a list containing various points, either plain or colored. Calls the actual toString method of any object thanks to polymorphism. Even though the list knows that the objects are all as if they are of `Point`-type:
```java
public class Main {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(4, 8));
        points.add(new ColouredPoint(1, 1, "green"));
        points.add(new ColouredPoint(2, 5, "blue"));
        points.add(new Point(0, 0));

        for (Point point : points) {
            System.out.println(point);
        }
    }
}
```
```
(4, 8) distance 12
(1, 1) distance 2 colour: green
(2, 5) distance 7 colour: blue
(0, 0) distance 0
```
We also want 3D points in our program. Since it's not a color point, it inherits a point:
```java
public class threeDPoint extends Point {
	private int z;

	public threeDPoint(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	@Override
    protected String location() {
        return super.location() + ", " + z;    // printing as "x, y, z"
    }

    @Override
    public int manhattanDistanceFromOrigin() {
        // first, we ask the superclass for the distance of x+y
        // and then we add the value of z to it
        return super.manhattanDistanceFromOrigin() + Math.abs(z);
    }

    @Override
    public String toString() {
        return "(" + this.location() + ") distance " + this.manhattanDistanceFromOrigin();
    }
}
```
The 3D point defines an object variable corresponding to the third coordinate, and overrides the `location`, `manhattanDistanceFromOrigin`, and `toString` methods to account for three-dimensionality. You can now expand on the previous example and add 3D points to the list.
```java
public class Main {

    public static void main(String[] args) {
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(4, 8));
        points.add(new ColouredPoint(1, 1, "green"));
        points.add(new ColouredPoint(2, 5, "blue"));
        points.add(new threeDPoint(5, 2, 8));
        points.add(new Point(0, 0));

        for (Point point : points) {
            System.out.println(point);
        }
    }
}
```
```
(4, 8) distance 12
(1, 1) distance 2 colour: green
(2, 5) distance 7 colour: blue
(5, 2, 8) distance 15
(0, 0) distance 0
```
We notice that the tridimensional point `toString` method is exactly the same as the point's toString. A tridimensional point can be reduced to the following:
```java
public class 3DPoint extends Point {

    private int z;

    public 3DPoint(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    protected String distance() {
        return super.distance()+", "+z;
    }

    @Override
    public int manhattanDistanceFromOrigin() {
        return super.manhattanDistanceFromOrigin()+Math.abs(z);
    }
}
```
How it is executed when you call the toString method of a 3D point;
- Find the toString method in the 3DPoint class. This cannot be found and we go to the parent class.
- Find the toString method in the parent class Point. A method is found and its code is executed.
- the code to execute is `return "("+this.location()+") location "+this.manhattanDistanceFromOrigin();`
- First execute the method location.
- Looking for the location method in the 3DPoint class. A method is found and its code is executed.
- the location method calculates its result by calling the superclass method location
- Next, find the definition of the `manhattanDistanceFromOrigin` method in the Point3D class. A method is found and its code is executed.
- again, the method calculates its result by calling its homonym in the superclass

> A sequence of actions created by a method call has multiple steps. Anyway, the idea is clear. To execute a method, it first looks for a definition in the actual type of the object, and if it doesn't find it, it goes to its parent class. If the method is not found in the parent class either, it goes to the parent parent class, and so on.

## When Do We Have to Use Inheritance?
Inheritance is a tool for building and qualifying object hierarchies. A subclass is always a special instance of a superclass. If the class to be created is a special instance of an existing class, it can be created by inheriting the existing class.

Through inheritance, a subclass receives the features of its parent class. Inheritance is not motivated if a subclass does not require or use the inherited functionality. An inherited class inherits the methods and interfaces of its parent class, so a subclass can be used for whatever purpose the parent class is used for. It's better to stick to a lower inheritance hierarchy, because the more complex the inheritance hierarchy, the more complex it is to maintain and develop. In general, higher tiers than 2, 3 usually improve the program structure.

If you find that hierarchies increase class responsibilities, you should break those classes into different classes.

### An Example of Inheritance Misuse
Let's think about the `Customer` class in the context of post services. The class contains the customer personal information, and the `Order` contains the information of the object that inherits the customer personal information and will place the order. The `Order` class also has a `mailingAddress` method that tells you the mailing address of the order.
```java
public class Customer {

    private String name;
    private String address;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
```
```java
public class Order extends Customer {

    private String product;
    private String amount;

    public Order(String product, String amount, String name, String address) {
        super(name, address);
        this.product = product;
        this.amount = amount;
    }

    public String getProduct() {
        return product;
    }

    public String getAmount() {
        return amount;
    }

    public String mailingAddress() {
        return this.getName() + "\n" + this.getAddress();
    }
}
```
Inheritance above is used incorrectly. When a class inherits from another class, the subclass must be a special instance of the parent class. An order is not a special instance of a customer. Misuse becomes apparent when the single responsibility principle is violated. The `Order` class is responsible for maintaining both customer and order information.

The problem with the previous solution becomes clear when you think about what happens when a customer changes their address.

When the address changes, each Order object of the customer needs to be changed, which is a hint of a bad situation. A better solution would be to encapsulate `Customer` as an object variable of Order. This becomes clearer if we think more specifically about order semantics. You have a customer on your order. Let's change the Order class to contain a reference to `Customer`.
```java
public class Order {

    private Customer customer;
    private String product;
    private String amount;

    public Tilaus(Customer customer, String product, String amount) {
        this.customer = customer;
        this.product = product;
        this.amount = amount;
    }

    public String getProduct() {
        return product;
    }

    public String getAmount() {
        return amount;
    }

    public String mailingAddress() {
        return this.customer.getName() + "\n" + this.customer.getAddress();
    }
}
```

The Order class above is better. Instead of inheriting from the `Customer` class, the `mailingAddress` method uses a `Customer` reference to retrieve the mailing address. This makes the maintenance and specific functions of our programs easier.

Now, when editing a customer, you only need to change the customer information. We don't have to do anything about the command.

## Inheritance, Interfaces, Both, or None?
Inheritance does not exclude the use of interfaces and vice versa. Interfaces are like a consensus on the implementation of a class and allow abstraction of concrete implementations. It is very easy to change a class that implements an interface.

As with interfaces, when using inheritance, a subclass is committed to providing all of its superclass methods. Because of polymorphism, inheritance works like interfaces. You can assign a subclass instance to a method that takes a parent class as a parameter.
