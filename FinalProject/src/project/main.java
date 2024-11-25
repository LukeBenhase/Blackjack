// written by Luke Benhase
package project;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Luke Benhase's Blackjack Simulator.");
		System.out.println("This is my final project for CSIS 212. \n");
		
		// varables
		//String[] cards = {"K", "J", "K", "10"};
		//String[] dealer = {"J", "6"};
		List <String> player = new ArrayList<>();
		List <String> dealer = new ArrayList<>();
		double betAmount;
		double balance;   // initlises amount in the first loop
		double userInputDouble;
		String userInputString;
		boolean endGame = false;
		Cards deck = new Cards();
		boolean playerBusts = false;
		
		// creates a scanner object to get user input
		Scanner input = new Scanner(System.in);
		
		
		// loop to run the main game
		while (!endGame) { 
		
		// Give the player a starting amount of money and confirm that they understand the rules
			balance = 1000;
			// clear the array for dealer and player
			dealer.clear();
			player.clear();
			
			System.out.println("You will be given $1000. Try to get that up as high as you can!");
			System.out.println("To play blackjack you get two cards and the dealer gets two cards");
			System.out.println("clossest to 21 but not over 21 wins. All face cards count as 10");
			System.out.println("and ace counts as a 1 or 11. If you decide to hit you will get");
			System.out.println("another card. If you decide to stand then the dealer will flip his");
			System.out.println("other card and we will see who is closser. The dealer will always");
			System.out.println("hit if their cards total 16 or under. \n");
			
			// clear the string
			userInputString = "";
			System.out.println("Are you ready? (y / n) ");
			userInputString = input.next();
			
			if (userInputString.equals("n")) {
				System.out.println("Then just stop playing.");
			}
			
			while (balance > 0) {
			// second loop if the player has more than 0 dollars
				
				// make a cards object that consists of one deck of cards that can draw random cards with a function
				deck.resetDeck();
				
				// clear the array for dealer and player
				dealer.clear();
				player.clear();
				playerBusts = false;
						
				// print the empty game screen
				printGameScreen(balance, 0, dealer, player, 000);

				
				// get the betting amount for their first hand
				// loop until they enter a valid amount
				System.out.print("How much would you like to bet: ");
				while (true) {
					userInputDouble = input.nextDouble();
					if (userInputDouble > balance) {
						System.out.println("You can't bet more than you have. Try again: ");
					}
					else {
						break;
					}
				}
				balance -= userInputDouble;
				betAmount = userInputDouble;
				
				// then deal out the hands and have one face down for the dealer
				dealer.add(deck.getCard());
				dealer.add(deck.getCard());

				player.add(deck.getCard());
				player.add(deck.getCard());

				
				while (true) {
					printGameScreen(balance, 1, dealer, player, betAmount);
					
					
					// ask if they want to hit or stand
					// if they wan't to hit add to their total and ask them again
					// clear the string
					userInputString = "";
					System.out.println("Would you like to hit or stand? (h / s) ");
					userInputString = input.next();
					
					if (userInputString.equals("h")) {
						player.add(deck.getCard());
						// check to see if the player busts
						if (getTotal(player) > 21) {
							
							// make player busts true so that the rest of the game doen't have to play out
							playerBusts = true;
							printGameScreen(balance, 1, dealer, player, betAmount);
							
							System.out.println("You Lose: You Bust ");

							break;
						}
					}
					else {
						break;
					}
				}
				
				
				// then flip the card over for the dealer check to see the total 
				// if the total is less than 16 consecutivly draw cards until it is above 16 or a bust
				while (!playerBusts) {
					printGameScreen(balance, 2, dealer, player, betAmount);
					
					if (getTotal(dealer) < 17) {
						dealer.add(deck.getCard());
						// check to see if the player busts
						if (getTotal(dealer) > 21) {
							
							// show the hand that the dealer had
							printGameScreen(balance, 2, dealer, player, betAmount);

							System.out.println("You Win: Dealer Busts");
							break;
						}
					}
					else {
						break;
					}
				}
				// find the winner and pay out accordingly
				if (playerBusts) {
				}
				else if (getTotal(dealer) > 21) {
					balance += betAmount *2;
				}
				else if (getTotal(dealer) <= getTotal(player)) {
					System.out.println("You win. Dealer: "+ getTotal(dealer) + " Player: " + getTotal(player));
					balance += betAmount*2;					
				}
				else if (getTotal(dealer) > getTotal(player)) {
					System.out.println("You lose. Dealer: "+ getTotal(dealer) + " Player: " + getTotal(player));

				}
				
				
				
			}
			
			// clear the string
			userInputString = "";
						
			System.out.println("Game Over: you lost all your money :(");
			System.out.println("Would you like to play again? (y / n) ");
			userInputString = input.next();
			
			if (userInputString.equals("y")) {
				System.out.println("Restarting...");
			}
			else {
				endGame = true;
				System.out.println("Thanks for playing!");
			}

		}
	
		input.close();
	}
	
	// get the total amount of points that are in a hand
	public static int getTotal(List<String> hand) {
		int total = 0;
		for (int i =0; i < hand.size(); i ++) {
			switch (hand.get(i)) {
				case "2":
					total += 2;
					break;
				case "3":
					total += 3;
					break;
				case "4":
					total += 4;
					break;
				case "5":
					total += 5;
					break;
				case "6":
					total += 6;
					break;
				case "7":
					total += 7;
					break;
				case "8":
					total += 8;
					break;
				case "9":
					total += 9;
					break;
				case "10":
					total += 10;
					break;
				case "J":
					total += 10;
					break;
				case "Q":
					total += 10;
					break;
				case "K":
					total += 10;
					break;
				default:
					total = -9999;
			}
		}
		
		return total;
	}
	
	
	// print the game screen
	public static void printGameScreen( double balance, int stageOfGameplay, List<String> dealerCardsToDisplay, List<String> playerCardsToDisplay, double betAmounts ) {
	// there needs to be 2 different stages. 
	// one before the second card is flipped and one when the player is getting cards
		
		System.out.println("Balance: $" + balance);
		System.out.println("");		
		
		
		if (stageOfGameplay == 0) {
			System.out.println("                Dealer");
			System.out.println("                " );
			System.out.println("");
			
			System.out.println("             Player's Hand");
			System.out.print("             ");
			for (int i = 0; i < playerCardsToDisplay.size(); i++) {
				System.out.print(playerCardsToDisplay.get(i) + " ");
			}
			System.out.println();
			
			System.out.println("               $");
		
		}
		else if (stageOfGameplay == 1) {
			System.out.println("                Dealer");
			System.out.println("                " + dealerCardsToDisplay.get(0) + " " + "XXX");
			System.out.println("");
			
			System.out.println("             Player's Hand");
			System.out.print("             ");
			for (int i = 0; i < playerCardsToDisplay.size(); i++) {
				System.out.print(playerCardsToDisplay.get(i) + " ");
			}
			System.out.println();
			
			System.out.println("               $" + betAmounts);
		
		
		}
		else if (stageOfGameplay == 2) {
			System.out.println("                Dealer");
			System.out.print("                " );
			for (int i = 0; i < dealerCardsToDisplay.size(); i++) {
				System.out.print(dealerCardsToDisplay.get(i) + " " );
			}
			System.out.println("");
			System.out.println("");
			
			System.out.println("             Player's Hand");
			System.out.print("             ");
			for (int i = 0; i < playerCardsToDisplay.size(); i++) {
				System.out.print(playerCardsToDisplay.get(i) + " ");
			}
			System.out.println();
			
			System.out.println("               $" + betAmounts);
		
		}
		else {
			
		}
		
		
	}
}
