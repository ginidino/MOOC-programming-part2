# Exercise 44: Regular Expressions

## Exercise 44.1: Week Days
Create the method `public static boolean isAWeekDay(String string)` in the class Main, using regular expressions. The method returns true if its parameter string is the abbreviation of a week day (mon, tue, wed, thu, fri, sat or sun).

The following is a sample print output of the method:
```
Give a string: tue
The form is fine.
```
```
Give a string: abc
The form is wrong.
```

## Exercise 44.2: Vowel Inspection
Create the method `public static boolean allVowels(String string)` in the class Main, which makes use of regular expressions and checks whether the String argument contains only vowel characters.

The following is a sample print output of the method:
```
Give a string: aie
The form is fine.
```
```
Give a string: ane
The form is wrong.
```

## Exercise 44.3: Clock Time
Regual expressions suit in particular situations. In some cases, the expressions become too complicate and it may be useful to check the "regularity" of a string in a different way, or it may be appropriate to use regular expressions to manage only a part of the inspection.

Create the method `public static boolean clockTime(String string)` in the class Main, which makes use of regular expressions and checks whether the String argument conforms with the clock time `hh:mm:ss` (two-digit hours, minutes, and seconds). In this exercise you can use whatever tecnique, in addition to regular expressions.

The following is a sample print output of the method:
```
Give a string: 17:23:05
The form is fine.
```
```
Give a string: abc
The form is wrong.
```
```
Give a string: 33:33:33
The form is wrong.
```
