# StringBuilder
We have got accustomed to building strings in the following way:
```java
public static void main(String[] args) {
    int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(build(t));
}

public static String build(int[] t) {
    String str = "{";

    for (int i = 0; i < t.length; i++) {
        str += t[i];
        if (i != t.length - 1) {
            str += ", ";

        }
    }

    return str + "}";
}
```
Output:
```
{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
```
This works, but may be more effective. Strings are *immutable* objects. The result of a String operation is always a new String object. This means that 10 String objects were created in the intermediate step of the previous example. If the input has a larger dimension, creating new objects on various interfaces will start to have an unpleasant effect on program execution time.
