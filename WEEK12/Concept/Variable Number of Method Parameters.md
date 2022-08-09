# Variable Number of Method Parameters
In Java, you can provide an infinite number of parameters of a particular type by placing an ellipsis after the parameter type.
- ex) `public int sum(int... values)` method can specify as many integers (`int`) as the user wants as a parameter. Parameter values can be treated as tables.
```java
public int sum(int... values) {
    int sum = 0;
    for (int i = 0; i < values.length; i++) {
        sum += values[i];
    }
    return sum;
}
```
```java
System.out.println(sum(3, 5, 7, 9));  // values = {3, 5, 7, 9}
System.out.println(sum(1, 2));        // values = {1, 2}
```
```
24
3
```
> Note: the parameter definition above `int... values` depends on the fact that the method has a table-like variable called `values`.

A method can only be assigned one parameter that receives an infinite number of values, and this must be the last parameter in the method definition. 

- ex:
```java
public void print(int times, String... strings) // right!
public void print(String... characterStrings, int times) // wrong!
```
An infinite number of parameter values ​​are used, for example, when you want to create an interface that does not force users to use an exact number of parameters. Another approach is to define a list of exact types as parameters. In this case, you can allocate an object to the list before calling the method, and give the list as a parameter by calling the method.
