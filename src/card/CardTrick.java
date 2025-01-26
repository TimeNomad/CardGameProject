/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;
import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * 
 * CardTrick Class
 * Modifier: Ahmed Ali, 991774753
 * Date: Jan 25, 2025
 */

public class CardTrick {
    public static void main(String[] args) {
        Card[] magicHand = new Card[7];
        Random random = new Random();

        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1);
            c.setSuit(Card.SUITS[random.nextInt(4)]);
            magicHand[i] = c;
        }

        Scanner scan = new Scanner(System.in);

        System.out.print("Pick a card value (1-13): ");
        int userValue = scan.nextInt();
        System.out.print("Pick a card suit (Hearts, Diamonds, Clubs, Spades): ");
        String userSuit = scan.next();

        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userValue && card.getSuit().equalsIgnoreCase(userSuit)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Your card is in the magic hand!");
        } else {
            System.out.println("Your card is not in the magic hand.");
        }

        Card luckyCard = new Card();
        luckyCard.setValue(2); 
        luckyCard.setSuit("Clubs"); 

        boolean luckyFound = false;
        for (Card card : magicHand) {
            if (card.getValue() == luckyCard.getValue() && card.getSuit().equals(luckyCard.getSuit())) {
                luckyFound = true;
                break;
            }
        }

        if (luckyFound) {
            System.out.println("You WIN! Lucky card is in the magic hand.");
        } else {
            System.out.println("You LOSE! Lucky card is not in the magic hand.");
        }

        System.out.println("Cards in the magic hand:");
        for (Card card : magicHand) {
            System.out.println(card);
        }
    }
}
