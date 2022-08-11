package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

public class Reference {
	private RatingRegister register;
	
	public Reference(RatingRegister register) {
		this.register = register;
	}
	// Exercise 46.7: Reference, Part 1
	public Film recommendFilm(Person person) {
        if (this.register.getPersonalRatings(person).isEmpty()) {
            List<Film> films = new ArrayList<Film>(this.register.filmRatings().keySet());
            Collections.sort(films, new FilmComparator(this.register.filmRatings()));
            return films.get(0);
        }
        
        List<Person> reviewersSortedBySimilarity = reviewersSortBySimilarity(person);

        return getRecommendedFilm(person, reviewersSortedBySimilarity);
    }
    
    private List<Person> reviewersSortBySimilarity(Person person) {
        Map<Person, Integer> reviewerSimilarity = reviewerSimilarity(this.register.getPersonalRatings(person));
        List<Person> similarReviewers = new ArrayList<Person>(reviewerSimilarity.keySet());
        Collections.sort(similarReviewers, new PersonComparator(reviewerSimilarity));
        return similarReviewers;
    }
    
    private Map<Person, Integer> reviewerSimilarity(Map<Film, Rating> filmRatings) {
        Map<Person, Integer> reviewerSimilarity = new HashMap<Person, Integer>();

        for (Person person : register.reviewers()) {
            int similarity = 0;
            
            for (Film film : filmRatings.keySet()) {               
                similarity += filmRatings.get(film).getValue() * register.getRating(person, film).getValue();
            }

            if (similarity > 0) {
                reviewerSimilarity.put(person, similarity);
            }
        }
        
        return reviewerSimilarity;
    }
    
    private Film getRecommendedFilm(Person person, List<Person> reviewersSortedBySimilarity) {
        Map<Film, Rating> viewersSeenFilms = register.getPersonalRatings(person);
        
        for (Person persons : reviewersSortedBySimilarity) {
            if (persons == person) {
                continue;
            }
            
            for (Film film : register.getPersonalRatings(persons).keySet()) {
                //  do not recommend films already seen by the viewer
                if (viewersSeenFilms.containsKey(film)) { 
                    continue;
                }

                if (this.register.getPersonalRatings(persons).get(film).getValue() > 1) {
                    return film;
                }
            }
        }
        return null;
    }     
}