package Week10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Exercise 27: The Finnish Ringing Centre
//Exercise 27.2: Ringing Centre
public class RingingCentre {
	private Map<Bird, List<String>> birds;
	
	public RingingCentre() {
		this.birds = new HashMap<Bird, List<String>>();
	}

	public void observe(Bird bird, String place) {
		List<String> places = new ArrayList<String>();
		if (!birds.keySet().contains(bird)) {
			places.add(place);
			this.birds.put(bird, places);
		} else {
			places = birds.get(bird);
			places.add(place);
			this.birds.put(bird, places);
		}
	}

	public void observations(Bird bird) {
		if (this.birds.get(bird) == null) {
			System.out.println(bird.toString() + " observations: " + 0);
		} else {
			System.out.println(bird.toString() + " observations: " + birds.get(bird).size());
            System.out.println(birds.get(bird));
		}
	}
}
