package hand;

import card.Card;
import card.CardValue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public enum HandValue {
    CARTE_HAUTE("une carte haute : ", hand -> Boolean.TRUE),
    PAIRE("une paire de ", hand -> Boolean.valueOf(hand.getSortedCards().get(0).getValue() == 2)),
    DOUBLE_PAIRE("une double paire ", hand -> Boolean.valueOf(hand.getSortedCards().get(0).getValue() == 2 && hand.getSortedCards().get(1).getValue() == 2)),
    BRELAN("un brelan de", hand -> Boolean.valueOf(hand.getSortedCards().get(0).getValue() == 3)),
    SUITE("une suite de hauteur ", hand -> Boolean.valueOf(hasStraight(hand.getSortedCards()))),
    COULEUR("une couleur de hauteur ", hand -> Boolean.valueOf(hasFlush(hand.getCardArray()))),
    FULL("un full ", hand -> Boolean.valueOf(hand.getSortedCards().get(0).getValue() == 3 && hand.getSortedCards().get(1).getValue() == 2)),
    CARRE("un carré de ", hand -> Boolean.valueOf(hand.getSortedCards().get(0).getValue() == 4)),
    QUINTE_FLUSH("une quinte flush de hauteur ", hand -> Boolean.valueOf(hasFlush(hand.getCardArray()) && hasStraight(hand.getSortedCards())));

    private final String str;
    private final Function<Hand, Boolean> function;

    HandValue(String str, Function<Hand, Boolean> function) {
        this.str = str;
        this.function = function;
    }

    /**
     * @return A string (used in order to print the results).
     */
    public String getStr() {
        return str;
    }

    public Function<Hand, Boolean> getFunction() {
        return function;
    }

    private static boolean hasStraight(List<Map.Entry<CardValue, Long>> sortedCards) {
        if (sortedCards.size() != 5) return Boolean.FALSE;
        for (int i = 0; i < sortedCards.size() - 1; i++)
            if (sortedCards.get(i).getKey().ordinal() + 1 != sortedCards.get(i + 1).getKey().ordinal())
                return Boolean.FALSE;
        return Boolean.TRUE;
    }

    private static boolean hasFlush(Card[] cardArray) {
        return Arrays.stream(cardArray).map(Card::getSuit).allMatch(suit -> suit.equals(cardArray[0].getSuit()));
    }
}
