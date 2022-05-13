package Week08;

import java.util.Comparator;

// Exercise 15: Sorting Cards
// Exercise 15.5: Sorting the Cards against Different Criteria
public class SortAgainstSuit implements Comparator<Card> {
    public int compare(Card card1, Card card2) {
        //return card1.getSuit()-card2.getSuit();
    	/*if (card1.getSuit() == card2.getSuit()) {
    		return card1.getValue() - card2.getValue();
    	} else {
    		return card1.getSuit() - card2.getSuit();
    	}*/
    	
    	if (card1.getSuit() > card2.getSuit()) {
            return 1;
        } else if (card1.getSuit() < card2.getSuit()) {
            return -1;
        } else if (card1.getSuit() == card2.getSuit()) {
            if (card1.getValue() > card2.getValue()) {
                return 1;
            } else if (card1.getValue() < card2.getValue()) {
                return -1;
            }
        }
        return 0;
    	
    	/*if (card1.getSuit() < card2.getSuit()) {
    		return -1;
    	} else if (card1.getSuit() > card2.getSuit()) {
    		return 1;
        } else {
        	return card1.compareTo(card2);
        }*/
        
        /*if(card1.getSuit() - card2.getSuit() < 0){
            if(card1.getValue() < card2.getValue()){
                return card1.compareTo(card2);
            } else {
                return card2.compareTo(card1);
            }
        } else if(card1.getSuit() == card2.getSuit()){       
            return card1.compareTo(card2);
        } else {
            return 1;
        }*/
    }
}
