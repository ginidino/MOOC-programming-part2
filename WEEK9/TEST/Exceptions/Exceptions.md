# Exceptions

> Exceptions are such situations where the program executions is different from our expectations. For instance, the program may have called a method of a null reference, in which case the user is thrown a NullPointerException. If we try to retrieve a index outside a table, the user is thrown a IndexOutOfBoundsException. All of them are a type of Exception.
> 
> We deal with exception using the block try { } catch (Exception e) { }. The code contained within the brackets which follows the keyword try can possibly go through an exception. The keyword the code within the brackets which follow the keyword catch defines what should happen when the try-code throws an exception. We also define the type of the exception we want to catch (catch (Exception e)).

```java
try {
  // code which can throw an exception
} catch (Exception e) {
  // code which is executed in case of exception
}
```
