package Week7;

import java.util.HashMap;

// Exercise 6: Promissory Note
public class PromissoryNote {
	private HashMap<String, Double> amount;
	
	public PromissoryNote() {
		// creates a new promissory note
		this.amount = new HashMap<String, Double>();
	}

	public void setLoan(String toWhom, double value) {
		// stores the information about loans to specific people
		this.amount.put(toWhom, value);
	}

	public double howMuchIsTheDebt(String whose) {
		// returns the entity of the debt held by the parameter person
		if (this.amount.containsKey(whose)) {
			return this.amount.get(whose);
		}
		return 0;
	}
	
}
