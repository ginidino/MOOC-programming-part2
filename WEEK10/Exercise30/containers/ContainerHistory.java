package containers;

import java.util.ArrayList;
import java.util.List;

// Exercise 30: Container
public class ContainerHistory {
	private List<Double> history;
	
	// Exercise 30.3: Container History
	public ContainerHistory() {
		this.history = new ArrayList<Double>();
	}
	// Exercise 30.3: Container History
	public void add(double situation) {
		// adds the parameter situation to the end of the container history
		this.history.add(situation);
	}
	// Exercise 30.3: Container History
	public void reset() {
		// deletes the container history records
		this.history.clear();
	}
	// Exercise 30.3: Container History
	@Override
	public String toString() {		
		return this.history.toString();
	}
	// Exercise 30.4: ContainerHistory.java, Phase 2
	public double maxValue() {
		// reutrns the greatest value in the container history. If the history is empty, the method returns 0
		double maxValue = 0;
		if (this.history.isEmpty()) {
			return 0;
		} else {
			for (double value : this.history) {
				if (value >= maxValue) {
					maxValue = value;
				}
			}
		}
		return maxValue;
	}
	// Exercise 30.4: ContainerHistory.java, Phase 2
	public double minValue() {
		// reutrns the smallest value in the container history. If the history is empty, the method returns 0
		double minValue = 0;
		if (this.history.isEmpty()) {
			return 0;
		} else {
			minValue = this.maxValue();
			for (double value : this.history) {
				if (value < minValue) {
					minValue = value;
				}
			}
		}
		return minValue;
	}
	// Exercise 30.4: ContainerHistory.java, Phase 2
	public double average() {
		// reutrns the average of the values in the container history. If the history is empty, the method returns 0
		if (this.history.isEmpty()) {
			return 0;
		}
		double sum = 0;
		for (double value : this.history) {
			sum += value;
		}
		double average = sum / this.history.size();
		return average;
	}
	// Exercise 30.5: ContainerHistory.java, Phase 3
	public double greatestFluctuation() {
		// returns the absolute value of the single greatest fluctuation in the container history
		List<Double> fluctuations = new ArrayList<Double>();
		double greatestFluctuation = 0;
		if (this.history.isEmpty() || this.history.size() == 1) {
			return 0;
		}
		for (int i = this.history.size() - 1; i >= 1; i--) {
			double fluctuation = Math.abs(this.history.get(i) - this.history.get(i - 1));
			fluctuations.add(fluctuation);
		}
		for (double f : fluctuations) {
			if (greatestFluctuation < f) {
				greatestFluctuation = f;
			}
		}
		return greatestFluctuation;
	}
	// Exercise 30.5: ContainerHistory.java, Phase 3
	public double variance() {
		// returns the sample variance of the container history values
		if (this.history.isEmpty() || this.history.size() == 1) {
			return 0;
		}
		double average = this.average();
		double var = 0;
		
		for (double value : this.history) {
			var += Math.pow(value - average, 2);
		}
		var = var / (this.history.size() - 1);
		return var;
	}
}