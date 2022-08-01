package hand;

import card.Card;
import card.CardValue;

import java.util.*;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand> {

    private final Card[] cardArray;
    private final HandValue handValue;
    private final List<Map.Entry<CardValue, Long>> sortedCards;
    private final int num;

    /**
     * Constructor of the Hand object.
     * Analyzes directly the hand.
     *
     * @param card or multiple card
     * @param num  number ID of the hand
     */
    public Hand(int num, Card... card) {
        this.num = num;
        this.cardArray = card;
        this.sortedCards = analyzeHand();
        this.handValue = setHandValue();
    }

    Card[] getCardArray() {
        return this.cardArray;
    }

    public int getNum() {
        return num;
    }

    /**
     * @return the hand's value
     */
    public HandValue getHandValue() {
        return this.handValue;
    }

    /**
     * @return SortedCards
     * Contains a 2-Dimension array which gives the ordinal's value of each card in the hand as well as its frequency of occurrence
     */
    public List<Map.Entry<CardValue, Long>> getSortedCards() {
        return this.sortedCards;
    }

    /**
     * @return a formatted String in order to print the hand
     */
    @Override
    public String toString() {
        return "Main{" +
                "tab_cartes=" + Arrays.toString(cardArray) +
                '}';
    }

    public HandValue setHandValue() {
        var types = HandValue.values();
        for (int i = types.length - 1; i >= 0; i--) {
            var result = types[i].getFunction().apply(this);
            if (result.equals(Boolean.TRUE))
                return types[i];
        }
        throw new RuntimeException("This should never happen.");
    }

    /**
     * @return a list of Map.Entryarray which gives the card value of each card in the hand as well as its frequency of occurrence
     */
    private List<Map.Entry<CardValue, Long>> analyzeHand() {
        return Arrays.stream(cardArray).collect(Collectors.groupingBy(Card::getValue, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<CardValue, Long>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toList());
    }

    /**
     * @param hand The hand that you want to compare.
     */
    @Override
    public int compareTo(Hand hand) {
        if (handValue.ordinal() > hand.handValue.ordinal())
            return -1;
        else if (handValue.ordinal() < hand.handValue.ordinal())
            return 1;
        else {
            for (int i = 0; i < sortedCards.size(); i++) {
                int resCompare = sortedCards.get(i).getKey().compareTo(hand.sortedCards.get(i).getKey());
                if (resCompare != 0)
                    return resCompare;
            }
        }
        return 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hand)) return false;
        Hand hand = (Hand) o;
        return this.compareTo(hand) == 0;
    }
}
