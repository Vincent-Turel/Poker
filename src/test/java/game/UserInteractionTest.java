package game;

import org.junit.jupiter.api.Test;
import card.Card;
import card.CardSuit;
import card.CardValue;
import game.UserInteraction;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class UserInteractionTest {

    @Test
    public void convertStringToCardTest(){
    Card[] cardArray = new Card[5];
    ArrayList<Card> cardsAlreadyUsed= new ArrayList<>();

    String[] strArray = new String[]{"2Tr", "6Ca", "7Ca", "DCo", "RCo"};
    String[] strArray2 = new String[]{"2Tr", "6Ca", "7Ca", "5Ca", "9Ca", "DCo"};
    String[] strArray3 = new String[]{"10Ta", "6Ca", "9Ca", "DCo", "RCo"};
    String[] strArray4 = new String[]{"Pco", "6Ca", "5Ca", "9Ca", "RCo"};
    String[] strArray5 = new String[]{"2Tr", "2Tr", "9Ca", "7Co", "RCo"};

    assertFalse(UserInteraction.convertStringToCard(strArray2, cardArray, cardsAlreadyUsed));
    Arrays.fill(cardArray, null);
    cardsAlreadyUsed.clear();
    assertFalse(UserInteraction.convertStringToCard(strArray3, cardArray, cardsAlreadyUsed));
    Arrays.fill(cardArray, null);
    cardsAlreadyUsed.clear();
    assertFalse(UserInteraction.convertStringToCard(strArray4, cardArray, cardsAlreadyUsed));
    Arrays.fill(cardArray, null);
    cardsAlreadyUsed.clear();
    assertFalse(UserInteraction.convertStringToCard(strArray5, cardArray, cardsAlreadyUsed));
    Arrays.fill(cardArray, null);
    cardsAlreadyUsed.clear();
    assertTrue(UserInteraction.convertStringToCard(strArray, cardArray, cardsAlreadyUsed));
    assertEquals(CardValue.Roi, cardArray[4].getValue());
    assertEquals(CardSuit.Coeur, cardArray[4].getSuit());
    assertEquals(CardValue.Dame, cardArray[3].getValue());
    assertEquals(CardSuit.Coeur, cardArray[3].getSuit());
    assertEquals(CardValue.Sept, cardArray[2].getValue());
    assertEquals(CardSuit.Carreau, cardArray[2].getSuit());
    assertEquals(CardValue.Six, cardArray[1].getValue());
    assertEquals(CardSuit.Carreau, cardArray[1].getSuit());
    assertEquals(CardValue.Deux, cardArray[0].getValue());
    assertEquals(CardSuit.Trefle, cardArray[0].getSuit());
    }
}
