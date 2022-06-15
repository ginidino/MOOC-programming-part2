# Hashmaps and Sets

## Many Values and One Key
Able to use a HashMap to store only one value per key. 
- Example: storing people's mobile phone numbers in a HashMap
```java
import java.util.HashMap;
import java.util.Map;

public class phoneNum {
	public static void main(String[] args) {
		Map<String, String> phoneNum = new HashMap<String, String>();
		phoneNum.put("Paul", "010-1234-1234");
		System.out.println("Paul's number: " + phoneNum.get("Paul"));
		
		phoneNum.put("Paul", "010-1234-5678");
		System.out.println("Paul's new number: " + phoneNum.get("Paul"));
	}
}
```
output
```
Paul's number: 010-1234-1234
Paul's new number: 010-1234-5678
```

As in the example above, if a person has multiple phone numbers, various different values can be stored in one key through HashMap.    
For example, instead of storing a String as a HashMap value, you can store an ArrayList to map one or more objects to one key. 
- Change to an example of storing various different values in one key
```java
Map<String, ArrayList<String>> phoneNumbers = new HashMap<String, ArrayList<String>>();
```
The list is now mapped to each HashMap key. Even if a new command creates a HashMap, the list to be stored inside must be created separately. The following example adds two numbers to a HashMap for James and prints them.
```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class phoneNum {
	public static void main(String[] args) {
		Map<String, ArrayList<String>> phoneNumbers = new HashMap<String, ArrayList<String>>();
		
		// map an empty ArrayList to James
		phoneNumbers.put("James", new ArrayList<String>());
		
		// add James's number to the list
		phoneNumbers.get("James").add("010-2345-2345");
		
		// add a second phone number
		phoneNumbers.get("James").add("010-2345-6789");
		
		System.out.println("James's number: " + phoneNumbers.get("James"));
	}
}
```
output
```
James's number: [010-2345-2345, 010-2345-6789]
```
Define the phone number type as Map<String, ArrayList<String>>, that is a Map whose key is a String and whose value is a list containing strings. The concrete implementation, i.e. the object created, was a HashMap. You can also define variables in the following ways:
```java
Map<String, List<String>> phoneNumbers = new HashMap<String, List<String>>();
```
The variable type is now a map where the key is a string and the value is a list containing strings. In fact, List is an interface that defines List functionality, for example ArrayList implements this interface. The concrete object is a HashMap.
   
The values ​​you store in a HashMap are, for example, List<String>, a concrete object that implements the ArrayLists interface. Again you can add values to the HashMap like this:
```java
// first, we map an empty ArrayList to Pekka
phoneNumbers.put( "Pekka", new  ArrayList<String>() );

// ...
```
   

## Set
Unlike a list, a Set can have up to one identical entry, that is to say the same object can not be contained twice in a Set. Similarity between two objects is checked using the 'equals' and 'hashCode' methods.
   
One class that implements the Set interface is HashSet. 
- Let's use it to implement the ExerciseAccounting class, which allows us to keep an account of the exercise we do and print them out.
- Let's suppose the the exercises are always integers.
```java
public class ExerciseAccounting {
    private Set<Integer> doneExercises;

    public ExerciseAccounting() {
        this.doneExercises = new HashSet<Integer>();
    }

    public void add(int exercise) {
        this.doneExercises.add(exercise);
    }

    public void print() {
        for (int exercise: this.doneExercises) {
            System.out.println(exercise);
        }
    }
}
```
```java
ExerciseAccounting account = new ExerciseAccounting();
account.add(1);
account.add(1);
account.add(2);
account.add(3);

account.print();
```
output
```
1
2
3
```

The solution above is useful if we don't need information about the exercises done by each different user. We can change the saving logic of the exercises in a way to have them save in relation to each user, using a HashMap. The users are recognized through a unique string (for instance, their student number), and each user has their own set of finished exercises.
```java
public class ExerciseAccounting {
    private Map<String, Set<Integer>> doneExercises;

    public ExerciseAccounting() {
        this.doneExercises = new HashMap<String, Set<Integer>>();
    }

    public void add(String user, int exercise) {
        // note that when we create a new user we have first to map an empty exercise set to it
        if (!this.doneExercises.containsKey(user)) {
            this.doneExercises.put(user, new HashSet<Integer>());
        }

        // first, we retrieve the set containing the user's exercises and then we add an exercise to it
        Set<Integer> finished = this.doneExercises.get(user);
        finished.add(exercise);

        // the previous would have worked out without helping variable in the following way:
        //  this.doneExercises.get(user).add(exercise);
    }

    public void print() {
        for (String user: this.doneExercises.keySet()) {
            System.out.println(user + ": " + this.doneExercises.get(user));
        }
    }
}
```
```java
ExerciseAccounting accounting = new ExerciseAccounting();
accounting.add("Mikael", 3);
accounting.add("Mikael", 4);
accounting.add("Mikael", 3);
accounting.add("Mikael", 3);

accounting.add("Pekka", 4);
accounting.add("Pekka", 4);

accounting.add("Matti", 1);
accounting.add("Matti", 2);

accounting.print();
```
output
```
Mikael : [3, 4]
Pekka : [4]
Matti : [1, 2]
```
