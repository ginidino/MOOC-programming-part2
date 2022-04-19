package TEST;

import java.util.ArrayList;

public class Container {
	private ArrayList<Suitcase> suitcases;
	private int maxWeight;

	public Container(int maxWeight) {
		this.suitcases = new ArrayList<Suitcase>();
		this.maxWeight = maxWeight;
	}

	public void addSuitcase(Suitcase suitcase) {
        int weight = totalWeight();
        weight += suitcase.totalWeight();
        if (weight <= this.maxWeight) {
            this.suitcases.add(suitcase);
        }
    }

	public int totalWeight() {
		int weight = 0;
        for (Suitcase suitcase : suitcases) {
            weight += suitcase.totalWeight();
        }
		return weight;
	}

	public void printThings() {
		for (Suitcase suitcase : suitcases) {
			suitcase.printThings();
		}
		
	}

	public String toString() {
		int weight = totalWeight();
        return suitcases.size() + " suitcases " + "(" + weight + " kg)";

	}
}
