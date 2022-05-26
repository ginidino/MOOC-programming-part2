# Throwing Exceptions

> Methods and constructors can throw exceptions. So far, there are two kinds of exceptions which can be thrown. There are the ones which have to be handled, and the ones which don't have to be dealt with. When we have to handle the exceptions, we do it either in a try-catch chunk, or throwing them from a method.
> 
> In the clock exercise of Introduction to Programming, we explained that we can stop our program of one second, by calling the method Thread.sleep(1000). The method may throw an exception, which we must deal with. In fact, we handle the exception using the try-catch sentence; in the following example we skip the exception, and we leave empty the catch chunk.
```java
    try {
        // we sleep for 1000 milliseconds
        Thread.sleep(1000);
    } catch (Exception e) {
        // In case of exception, we do not do anything.
    }
```  
> It is also possible to avoid handling the exceptions in a method, and delegate the responsibility to the method caller. We delegate the responsibility of a method by using the statement throws Exception.
```java
    public void sleep(int sec) throws Exception {
        Thread.sleep(sec * 1000);   // now we don't need the try-catch block
    }
```  
> The sleep method is called in another method. Now, this other method can either handle the exception in a try-catch block or delegate the responsibility forward. Sometimes, we delegate the responsibility of handling an exception, till the very end, and even the main method delegates it:
```java
public class Main {
   public static void main(String[] args) throws Exception {
       // ...
   }
}
```  
> In such cases, the exception ends up in Java's virtual machine, which interrupts the program in case there is an error which causes the problem.
> 
> There are some exceptions which the programmer does not always have to address, such as the NumberFormatException which is thrown by Integer.parseInt. Also the RuntimeExceptions do not always require to be addressed; next week we will go back to why variables can have more than one type.
> 
> We can throw an exception ourself from the source code using the throw statement. For instance, if we want to throw an exception which was created in the class NumberFormatException, we could use the statement throw new NumberFormatException().
> 
> Another exception which hasn't got to be addressed is IllegalArgumentException. With IllegalArgumentException we know that a method or a constructor has received an illegal value as parameter. For instance, we use the IllegalArgumentException when we want to make sure that a parameter has received particular values. We create the class Grade whose constructor has a integer parameter: the grade.
```java
public class Grade {
    private int grade;

    public Grade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return this.grade;
    }
}
``` 
> Next, we want to validate the value of the constructor parameter of our Grade class. The grades in Finland are from 0 to 5. If the grade is something else, we want to throw an exception. We can add an if statement to our Grade class constructor, which checks whether the grade is outside range 0-5. If so, we throw an IllegalArgumentException telling throw new IllegalArgumentException("The grade has to be between 0-5");.
```java
public class Grade {
    private int grade;

    public Grade(int grade) {
        if (grade < 0 || grade > 5) {
            throw new IllegalArgumentException("The grade has to be between 0-5");
        }
        this.grade = grade;
    }

    public int getGrade() {
        return this.grade;
    }
}
```

```java  
    Grade grade = new Grade(3);
    System.out.println(grade.getGrade());

    Grade wrongGrade = new Grade(22);
    // it causes an exception, we don't continue
```

```
3
Exception in thread "..." java.lang.IllegalArgumentException: The grade has to be between 0-5
```
