# Exercise 46: Film Reference
With this exercise, create a program to recommend films. 

Below, you see how it should work:
```java
    EvaluationRegister ratings = new EvaluationRegister();

    Film goneWithTheWind = new Film("Gone with the Wind");
    Film theBridgesOfMadisonCounty = new Film("The Bridges of Madison County");
    Film eraserhead = new Film("Eraserhead");

    Person matti = new Person("Matti");
    Person pekka = new Person("Pekka");
    Person mikke = new Person("Mikke");
    Person thomas = new Person("Thomas");

    ratings.addRating(matti, goneWithTheWind, Rating.BAD);
    ratings.addRating(matti, theBridgesOfMadisonCounty, Rating.GOOD);
    ratings.addRating(matti, eraserhead, Rating.FINE);

    ratings.addRating(pekka, goneWithTheWind, Rating.FINE);
    ratings.addRating(pekka, theBridgesOfMadisonCounty, Rating.BAD);
    ratings.addRating(pekka, eraserhead, Rating.MEDIOCRE);

    ratings.addRating(mikke, eraserhead, Rating.GOOD);


    Reference reference = new Reference(votes);
    System.out.println(thomas + "'s recommendation: " +
            reference.recommendFilm(thomas));
    System.out.println(mikke + "'s recommendation: " +
            reference.recommendFilm(mikke));
```
```
Thomas's recommendation: The Bridges of Madison County
Mikke's recommendation: Gone with the Wind
```
The program is able to recommend films both according to their common appraisal and according to the ratings given by a specific person. Let's start to build our program.

## Exercise 46.1: Person and Film
Create the package `reference.domain`, and there you add the classes `Person` and `Film`. Both classes have a `public constructor public Class(String name)`, as well as the method `public String getName()`, which returns the name received with the argument.
```java
    Person p = new Person("Pekka");
    Film f = new Film("Eraserhead");

    System.out.println(p.getName() + " and " + f.getName());
```
```
Pekka and Eraserhead
```
Also add the method `public String toString()` which returns the name received with the argument, as well as the method `equals` and `hashCode`.

Override `equals` so that the equivalence is checked according to the object variable name.

> Attention: to help finding mistakes, you may want to implement toString methods to Person and Film, but the tests do not require them.

## Exercise 46.2: Rating
|Rating|Value|
|:---|---:|
|BAD|	-5|
|MEDIOCRE|	-3|
|NOT_WATCHED|	0|
|NEUTRAL|	1|
|FINE|	3|
|GOOD|	5|

The class could be used in the following way:
```java
    Rating given = Rating.GOOD;
    System.out.println("Rating " + given + ", value " + given.getValue());
    given = Rating.NEUTRAL;
    System.out.println("Rating " + given + ", value " + given.getValue());
```
```
Rating GOOD, value 5
Rating NEUTRAL, value 1
```

## Exercise 46.3: RatingRegister, Part 1
Let's get started with the implementation necessary to store the ratings.

Create the class `RatingRegister` in the package `reference`; the class has the constructor `public RatingRegister()`, as well as the following methods:
- `public void addRating(Film film, Rating rating)` adds a new rating to the parameter film. The same film can have various same ratings.
- `public List<Rating> getRatings(Film film)` returns a list of the ratings which were added in connection to a film.
- `public Map<Film, List<Rating>> filmRatings()` returns a map whose keys are the evaluated films. Each film is associated to a list containing the ratings for that film.

Test the methods with the following source code:
```java
    Film theBridgesOfMadisonCounty = new Film("The Bridges of Madison County");
    Film eraserhead = new Film("Eraserhead");

    RatingRegister reg = new RatingRegister();
    reg.addRating(eraserhead, Rating.BAD);
    reg.addRating(eraserhead, Rating.BAD);
    reg.addRating(eraserhead, Rating.GOOD);

    reg.addRating(theBridgesOfMadisonCounty, Rating.GOOD);
    reg.addRating(theBridgesOfMadisonCounty, Rating.FINE);

    System.out.println("All ratings: " + reg.filmRatings());
    System.out.println("Ratings for Eraserhead: " + reg.getRatings(eraserhead));
```
```
All ratings: {The Bridges of Madison County=[GOOD, FINE], Eraserhead=[BAD, BAD, GOOD]}
Ratings for Eraserhead: [BAD, BAD, GOOD]
```

## Exercise 46.4: RatingRegister, Part 2
Let's make possible to add personal ratings.

Add the following methods to the class `RatingRegister`:
- `public void addRating(Person person, Film film, Rating rating)` adds the rating of a specific film to the parameter person. The same person can recommend a specific film only once. The person rating has also to be added to the ratings connected to all the films.
- `public Rating getRating(Person person, Film film)` returns the rating the paramater person has assigned to the parameter film. If the person hasn't evaluated such film, the method returns `Rating.NOT_WATCHED`.
- `public Map<Film, Rating> getPersonalRatings(Person person)` returns a HashMap which contains the person's ratings. The HashMap keys are the evaluated films, and their values are the ratings of these films.
- `public List<Person> reviewers()` returns a list of the people who have evaluate the films.

People's ratings should be stored into a HashMap, and the people should act as keys. The values of the HashMap is another HashMap, whose keys are films and whose values are ratings.

Test your improved `RatingRegister` with the following source code:
```java
    RatingRegister ratings = new RatingRegister();

    Film goneWithTheWind = new Film("Gone with the Wind");
    Film eraserhead = new Film("Eraserhead");

    Person matti = new Person("Matti");
    Person pekka = new Person("Pekka");

    ratings.addRating(matti, goneWithTheWind, Rating.BAD);
    ratings.addRating(matti, eraserhead, Rating.FINE);

    ratings.addRating(pekka, goneWithTheWind, Rating.GOOD);
    ratings.addRating(pekka, eraserhead, Rating.GOOD);

    System.out.println("Ratings for Eraserhead: " + ratings.getRatings(eraserhead));
    System.out.println("Matti's ratings: " + ratings.getPersonalRatings(matti));
    System.out.println("Reviewers: " + ratings.reviewers());
```
```
Ratings for Eraserhead: [FINE, GOOD]
Matti's ratings: {Gone with the Wind=BAD, Eraserhead=FINE}
Reviewers: [Pekka, Matti]
```

## Exercise 46.5: PersonComparator
Create the class `PersonComparator` in the package `reference.comparator`. The class `PersonComparator` has to implement the interface `Comparator<Person>`, and it has to have the constructor `public PersonComparator(Map<Person, Integer> peopleIdentities)`. The class `PersonComparator` is used later on to sort people according to their number.

Test the class with the following source code:
```java
    Person matti = new Person("Matti");
    Person pekka = new Person("Pekka");
    Person mikke = new Person("Mikke");
    Person thomas = new Person("Thomas");

    Map<Person, Integer> peopleIdentities = new HashMap<Person, Integer>();
    peopleIdentities.put(matti, 42);
    peopleIdentities.put(pekka, 134);
    peopleIdentities.put(mikke, 8);
    peopleIdentities.put(thomas, 82);

    List<Person> ppl = Arrays.asList(matti, pekka, mikke, thomas);
    System.out.println("People before sorting: " + ppl);

    Collections.sort(ppl, new PersonComparator(peopleIdentities));
    System.out.println("People after sorting: " + ppl);
```
```
People before sorting: [Matti, Pekka, Mikke, Thomas]
People after sorting: [Pekka, Thomas, Matti, Mikke]
```

## Exercise 46.6: FilmComparator
Create the class `FilmComparator` in the package `reference.comparator`. The class `FilmComparator` has to implement the interface `Comparator<Film>`, and it has to have the constructor `public FilmComparator(Map<Film, List<Rating>> ratings)`. The class `FilmComparator` will be used later on to sort films according to their ratings.

The class `FilmComparator` has to allow for film sorting according to the average of the rating values they have received. The films with the greatest average should be placed first, and the ones with the smallest average should be the last.

Test the class with the following source code:
```java
    RatingRegister ratings = new RatingRegister();

    Film goneWithTheWind = new Film("Gone with the Wind");
    Film theBridgesOfMadisonCounty = new Film("The Bridges of Madison County");
    Film eraserhead = new Film("Eraserhead");

    Person matti = new Person("Matti");
    Person pekka = new Person("Pekka");
    Person mikke = new Person("Mikke");

    ratings.addRating(matti, goneWithTheWind, Rating.BAD);
    ratings.addRating(matti, theBridgesOfMadisonCounty, Rating.GOOD);
    ratings.addRating(matti, eraserhead, Rating.FINE);

    ratings.addRating(pekka, goneWithTheWind, Rating.FINE);
    ratings.addRating(pekka, theBridgesOfMadisonCounty, Rating.BAD);
    ratings.addRating(pekka, eraserhead, Rating.MEDIOCRE);

    ratings.addRating(mikke, eraserhead, Rating.BAD);

    Map<Film, List<Rating>> filmRatings = ratings.filmRatings();

    List<Film> films = Arrays.asList(goneWithTheWind, theBridgesOfMadisonCounty, eraserhead);
    System.out.println("The films before sorting: " + films);

    Collections.sort(films, new FilmComparator(filmRatings));
    System.out.println("The films after sorting: " + films);
```
```
The films before sorting: [Gone with the Wind, The Bridges of Madison County, Eraserhead]
The films after sorting: [The Bridges of Madison County, Gone with the Wind, Eraserhead]
```

