package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

public class RatingRegister {
	private Map<Film, List<Rating>> frating;
	private Map<Person, Map<Film, Rating>> prating;
	
	// Exercise 46.3: RatingRegister, Part 1
	public RatingRegister() {
		this.frating = new HashMap<Film, List<Rating>>();
		this.prating = new HashMap<Person, Map<Film, Rating>>();
	}
	// Exercise 46.3: RatingRegister, Part 1
	public void addRating(Film film, Rating rating) {
		if (!this.frating.containsKey(film)) {
			this.frating.put(film, new ArrayList<Rating>());
		}
		
		this.frating.get(film).add(rating);
	}
	// Exercise 46.3: RatingRegister, Part 1
	public List<Rating> getRatings(Film film) {
		return this.frating.get(film);	
	}
	// Exercise 46.3: RatingRegister, Part 1
	public Map<Film, List<Rating>> filmRatings() {
		return this.frating;
	}
	// Exercise 46.4: RatingRegister, Part 2
	public void addRating(Person person, Film film, Rating rating) {
		if (!this.prating.containsKey(person)) {
			this.prating.put(person, new HashMap<Film, Rating>());
			this.prating.get(person).put(film, rating);
			addRating(film, rating);
		} else if (!this.prating.get(person).containsKey(film)) {
			this.prating.get(person).put(film, rating);
			addRating(film, rating);
		}
	}
	// Exercise 46.4: RatingRegister, Part 2
	public Rating getRating(Person person, Film film) {
		if (!this.prating.containsKey(person)) {
			return Rating.NOT_WATCHED;
		} else if (!this.prating.get(person).containsKey(film)) {
			return Rating.NOT_WATCHED;
		}
		return this.prating.get(person).get(film);
	}
	// Exercise 46.4: RatingRegister, Part 2
	public Map<Film, Rating> getPersonalRatings(Person person) {
		if (!this.prating.containsKey(person)) {
			return new HashMap<Film, Rating>();
		}
		return this.prating.get(person);
	}
	// Exercise 46.4: RatingRegister, Part 2
	public List<Person> reviewers() {
		return new ArrayList<Person>(this.prating.keySet());
	}
}