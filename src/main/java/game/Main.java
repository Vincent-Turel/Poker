package game;

import card.Card;
import hand.Hand;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int handNb;
        do {
            System.out.println("Combien de mains voulez-vous ?");
            handNb = sc.nextInt();
            if (handNb < 2)
                System.out.println("Il ne peut pas y a voir moins de deux joueurs !");
        } while (handNb < 2);
        List<Hand> jeu = new ArrayList<>();
        ArrayList<Card> cardsAlreadyUsed = new ArrayList<>();
        for (int i = 1; i <= handNb; i++) {
            Card[] cardArray = new Card[5];
            String[] cards;
            do {
                cards = UserInteraction.readInput(i);
            } while (!UserInteraction.convertStringToCard(cards, cardArray, cardsAlreadyUsed));
            jeu.add(new Hand(i, cardArray));
        }

        Collections.sort(jeu);
        UserInteraction.printOutput(jeu);
    }
}
