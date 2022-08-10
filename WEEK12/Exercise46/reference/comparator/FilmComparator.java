package reference.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

// Exercise 46.6: FilmComparator
public class FilmComparator implements Comparator<Film> {
	private Map<Film, List<Rating>> rating;
	
	public FilmComparator(Map<Film, List<Rating>> ratings) {
		this.rating = ratings;
	}

	@Override
	public int compare(Film o1, Film o2) {
		double o1Rating = 0;
		double o2Rating = 0;
		
		for (Rating rating : this.rating.get(o1)) {
			o1Rating += rating.getValue();
		}
		o1Rating /= this.rating.size();
		
		for (Rating rating : this.rating.get(o2)) {
			o2Rating += rating.getValue();
		}
		o2Rating /= this.rating.size();
		
		if (o1Rating == o2Rating) {
            return 0;
        } else if (o1Rating > o2Rating) {
            return -1; 
        } else {
            return 1;
        }
	}
}