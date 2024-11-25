package project;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Cards {
	private List <String> deck = new ArrayList<>();
	
	public void resetDeck() {
		deck.clear();
		for (int i = 2; i < 14; i++) {
			for (int j = 0; j < 4; j++) {
				if (i < 11) {
					deck.add(Integer.toString(i));
				}
				else if (i == 11) {
					deck.add("J");
				}
				else if (i == 12) {
					deck.add("Q");
				}
				else if (i == 13) {
					deck.add("K");
				}
				else if (i == 14) {
					deck.add("A");
				}
			}
			
		}
	}
	
	public String getCard() {
		// create a random number object
		Random rand = new Random();
		
		int var = rand.nextInt(deck.size());
		String card = deck.get(var);
		deck.remove(var);
		
		return card;
	}
}
