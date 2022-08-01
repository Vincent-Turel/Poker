package game;

import card.Card;
import card.CardSuit;
import card.CardValue;
import hand.Hand;
import hand.HandValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInteraction {

    /**
     * Asks the user which hand he wants to compare and processes them.
     *
     * @param i the number of the hand
     * @return True if the input has correctly been read. False otherwise.
     */
    static String[] readInput(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Main " + i + ":  ");
        return sc.nextLine().split("\\s+");
    }

    /**
     * @param cards            An array of String which contains the 10 cards.
     * @param cardArray        An array of cards ready to be fill up.
     * @param cardsAlreadyUsed A list of all cards which has been used in previous hand.
     * @return True if the input has correctly been read. False otherwise.
     */
    public static boolean convertStringToCard(String[] cards, Card[] cardArray, ArrayList<Card> cardsAlreadyUsed) {
        Arrays.fill(cardArray, null);
        ArrayList<Card> cardUsed = new ArrayList<>();
        if (cards.length != cardArray.length)
            return ProcessProblem.toDo(new RuntimeException("Incorrect amount of cards"));
        for (int i = 0; i < cards.length; i++) {
            CardValue x = null;
            CardSuit y = null;
            for (CardValue elem : CardValue.values())
                if (cards[i].startsWith(elem.getStr1())) {
                    x = elem;
                    break;
                }
            if (x == null) return ProcessProblem.toDo(new RuntimeException("Incorrect value format"));
            for (CardSuit elem : CardSuit.values()) {
                if (cards[i].substring(x.getStr1().length()).equals(elem.getStr())) {
                    y = elem;
                    break;
                }
            }
            if (y == null) return ProcessProblem.toDo(new RuntimeException("Incorrect suit format"));
            Card card = new Card(x, y);
            if (cardsAlreadyUsed.contains(card) || cardUsed.contains(card))
                return ProcessProblem.toDo(new RuntimeException("Twice the same card"));
            cardUsed.add(card);
            cardArray[i] = card;
        }
        cardsAlreadyUsed.addAll(cardUsed);
        return true;
    }

    /**
     * Gives the results to the user.
     *
     * @param jeu A sorted list of all hand
     */
    static void printOutput(List<Hand> jeu) {
        if (!jeu.get(0).equals(jeu.get(1))) {
            String print = "La main " + jeu.get(0).getNum() + " gagne avec " + jeu.get(0).getHandValue().getStr() + jeu.get(0).getSortedCards().get(0).getKey().getStr2();
            if (jeu.get(0).getHandValue().equals(HandValue.DOUBLE_PAIRE) || jeu.get(0).getHandValue().equals(HandValue.FULL))
                print += " - " + jeu.get(0).getSortedCards().get(1).getKey().getStr2();
            System.out.println(print);
        } else {
            System.out.println("Egalité");
        }
    }
}
