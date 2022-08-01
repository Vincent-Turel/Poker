package card;

public class Card {

    private final CardSuit suit;
    private final CardValue value;

    /**
     * Constructor of the card.Card object
     *
     * @param cardValue The value you want to set to the card.
     * @param cardSuit  The suit you want to set to the card.
     */
    public Card(CardValue cardValue, CardSuit cardSuit) {
        this.value = cardValue;
        this.suit = cardSuit;
    }

    /**
     * @return the card's color
     */
    public CardSuit getSuit() {
        return suit;
    }

    /**
     * @return the card's value
     */
    public CardValue getValue() {
        return value;
    }

    /**
     * @return a formatted String in order to print the card
     */
    @Override
    public String toString() {
        return "Carte{" +
                "couleur=" + suit +
                ", valeur=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return getValue() == card.getValue() &&
                getSuit() == card.getSuit();
    }
}
