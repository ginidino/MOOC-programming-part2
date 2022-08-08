# Loops and continue
In addition to the `break` statement, loops also have a `continue` statement that allows you to skip to the next loop step.

```java
List<String> names = Arrays.asList("Matti", "Pekka", "Arto");

for(String name: names) {
    if (name.equals("Arto")) {
        continue;
    }

    System.out.println(name);
}
```
```
Matti
Pekka
```

The `continue` statement is especially used when you know that an iterable variable has a value which don't want to handle. The classic approach is to use an `if` statement, but another approach that avoids indentation and increases readability using a `continue` statement can handle the values.

Below you will find two examples of looking at the numbers in the list.
- If the number is smaller than 5 and contains 100, or if it contains 40, it is not printed; otherwise it is.
```java
List<Integer> values = Arrays.asList(1, 3, 11, 6, 120);

for(int num: values) {
    if (num > 4 && num % 100 != 0 && num % 40 != 0) {
        System.out.println(num);
    }
}

for(int num: values) {
    if (num < 5) {
        continue;
    }

    if (num % 100 == 0) {
        continue;
    }

    if (num % 40 == 0) {
        continue;
    }

    System.out.println(num);
}
```
```
11
6
11
6
```
