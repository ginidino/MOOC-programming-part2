package Week12;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.RatingRegister;
import reference.Reference;
import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

// Exercise 46: Film Reference
public class Exercise46 {
	public static void main(String[] args) {
		// Exercise 46.1: Person and Film
		Person p = new Person("Pekka");
	    Film f = new Film("Eraserhead");

	    System.out.println(p.getName() + " and " + f.getName());
	    System.out.println();
	    
	    // Exercise 46.2: Rating
	    Rating given = Rating.GOOD;
	    System.out.println("Rating " + given + ", value " + given.getValue());
	    given = Rating.NEUTRAL;
	    System.out.println("Rating " + given + ", value " + given.getValue());
	    System.out.println();
	    
	    // Exercise 46.3: RatingRegister, Part 1
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
	    System.out.println();
	    
	    // Exercise 46.4: RatingRegister, Part 2
	    RatingRegister ratings = new RatingRegister();

	    Film goneWithTheWind = new Film("Gone with the Wind");
	    Film eraserheads = new Film("Eraserhead");

	    Person matti = new Person("Matti");
	    Person pekka = new Person("Pekka");

	    ratings.addRating(matti, goneWithTheWind, Rating.BAD);
	    ratings.addRating(matti, eraserheads, Rating.FINE);

	    ratings.addRating(pekka, goneWithTheWind, Rating.GOOD);
	    ratings.addRating(pekka, eraserheads, Rating.GOOD);

	    System.out.println("Ratings for Eraserhead: " + ratings.getRatings(eraserheads));
	    System.out.println("Matti's ratings: " + ratings.getPersonalRatings(matti));
	    System.out.println("Reviewers: " + ratings.reviewers());
	    System.out.println();
	    
	    // Exercise 46.5: PersonComparator
	    // Person david = new Person("David");
	    // Person paul = new Person("Paul");
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
	    System.out.println();
	    
	    // Exercise 46.6: FilmComparator
	    RatingRegister rating = new RatingRegister();

	    Film goneWithTheWinds = new Film("Gone with the Wind");
	    Film theBridgesOfMadisonCountys = new Film("The Bridges of Madison County");
	    Film eraserheadss = new Film("Eraserhead");

	    Person david = new Person("David");
	    Person paul = new Person("Paul");
	    Person james = new Person("James");

	    rating.addRating(david, goneWithTheWinds, Rating.BAD);
	    rating.addRating(david, theBridgesOfMadisonCountys, Rating.GOOD);
	    rating.addRating(david, eraserheadss, Rating.FINE);

	    rating.addRating(paul, goneWithTheWinds, Rating.FINE);
	    rating.addRating(paul, theBridgesOfMadisonCountys, Rating.BAD);
	    rating.addRating(paul, eraserheadss, Rating.MEDIOCRE);

	    rating.addRating(james, eraserheadss, Rating.BAD);

	    Map<Film, List<Rating>> filmRatings = rating.filmRatings();

	    List<Film> films = Arrays.asList(goneWithTheWinds, theBridgesOfMadisonCountys, eraserheadss);
	    System.out.println("The films before sorting: " + films);

	    Collections.sort(films, new FilmComparator(filmRatings));
	    System.out.println("The films after sorting: " + films);
	    System.out.println();
	    
	    // Exercise 46.7: Reference, Part 1
	    RatingRegister regi = new RatingRegister();

	    /*Film goneWithTheWind = new Film("Gone with the Wind");
	    Film theBridgesOfMadisonCounty = new Film("The Bridges of Madison County");
	    Film eraserhead = new Film("Eraserhead");

	    Person matti = new Person("Matti");
	    Person pekka = new Person("Pekka");
	    Person mikke = new Person("Mikke");*/

	    regi.addRating(matti, goneWithTheWind, Rating.BAD);
	    regi.addRating(matti, theBridgesOfMadisonCounty, Rating.GOOD);
	    regi.addRating(matti, eraserhead, Rating.FINE);

	    regi.addRating(pekka, goneWithTheWind, Rating.FINE);
	    regi.addRating(pekka, theBridgesOfMadisonCounty, Rating.BAD);
	    regi.addRating(pekka, eraserhead, Rating.MEDIOCRE);

	    Reference ref = new Reference(regi);
	    Film recommended = ref.recommendFilm(mikke);
	    System.out.println("The film recommended to Michael is: " + recommended);
		System.out.println();
		
		// Exercise 46.8: Reference, Part 2
		RatingRegister register = new RatingRegister();

	    /*Film goneWithTheWind = new Film("Gone with the Wind");
	    Film theBridgesOfMadisonCounty = new Film("The Bridges of Madison County");
	    Film eraserhead = new Film("Eraserhead");*/
	    Film bluesBrothers = new Film("Blues Brothers");

	    /*Person matti = new Person("Matti");
	    Person pekka = new Person("Pekka");
	    Person mikke = new Person("Mikael");
	    Person thomas = new Person("Thomas");*/
	    Person arto = new Person("Arto");

	    register.addRating(matti, goneWithTheWind, Rating.BAD);
	    register.addRating(matti, theBridgesOfMadisonCounty, Rating.GOOD);
	    register.addRating(matti, eraserhead, Rating.FINE);

	    register.addRating(pekka, goneWithTheWind, Rating.FINE);
	    register.addRating(pekka, eraserhead, Rating.BAD);
	    register.addRating(pekka, bluesBrothers, Rating.MEDIOCRE);

	    register.addRating(mikke, eraserhead, Rating.BAD);

	    register.addRating(thomas, bluesBrothers, Rating.GOOD);
	    register.addRating(thomas, theBridgesOfMadisonCounty, Rating.GOOD);

	    Reference refe = new Reference(register);
	    System.out.println(thomas + " recommendation: " + refe.recommendFilm(thomas));
	    System.out.println(mikke + " recommendation: " + refe.recommendFilm(mikke));
	    System.out.println(matti + " recommendation: " + refe.recommendFilm(matti));
	    System.out.println(arto + " recommendation: " + refe.recommendFilm(arto));
	}
}