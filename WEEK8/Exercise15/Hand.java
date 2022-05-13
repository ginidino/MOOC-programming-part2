package Week08;

import java.util.ArrayList;
import java.util.Collections;

// Exercise 15: Sorting Cards
public class Hand implements Comparable<Hand> {
	private ArrayList<Card> hands;
	
	public Hand() {
		this.hands = new ArrayList<Card>();
	}
	// Exercise 15.2: Hand
	public void add(Card card) {
		// adds a card to the hand
		this.hands.add(card);
	}
	// Exercise 15.2: Hand
	public void print() {
		// prints the cards in the hand
		for (Card card : this.hands) {
			System.out.println(card.toString());
		}
	}
	// Exercise 15.3: Sorting the Hand
	public void sort() {
		// sorts the cards in the hand
		// After being sorted, the cards are printed in order
		Collections.sort(this.hands);
	}
	// Exercise 15.4: Comparing Hands
	@Override
	public int compareTo(Hand hand) {
		int comparison = 0;
		int otherHand = 0;
		
		for (Card cards : this.hands) {
			comparison += cards.getValue();
		}
		
		for (Card card : hand.hands) {
			otherHand += card.getValue();
		}
		
		/*if (comparison < otherHand) {
			return -1;
		} else if (comparison == otherHand) {
			return 0;
		} else {
			return 1;
		}*/
		return comparison - otherHand;
	}
	// Exercise 15.6: Sort Against Suit
	public void sortAgainstSuit() {
		Collections.sort(this.hands, new SortAgainstSuit());
	}
}
