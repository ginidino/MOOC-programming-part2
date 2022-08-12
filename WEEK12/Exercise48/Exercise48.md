# Exercise 48: String builder
In situations like the previous one, it is better to use `StringBuilder` objects when it comes to building strings. Differently from Strings, StringBuilders are not immutable, meaning StringBuilder-objects can be modified. Get acquainted with the description of the StringBuilder API (you'll find it by googling "stringbuilder java api 6") and modify the method in the exercise body, `public static String build(int[] t)`, so that it would use StringBuilder and work in the following way:
```
{
1, 2, 3, 4,
5, 6, 7, 8,
9, 10
}
```
The curly brackets are on their own lines. There are up to four values in each line of the table, and the first value requires an initial space. Before each number, and after the comma there must be exactly one space.
