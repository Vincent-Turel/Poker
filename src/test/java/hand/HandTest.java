package hand;

import org.junit.*;
import card.Card;
import game.UserInteraction;

import java.util.ArrayList;

public class HandTest {

    static Hand m1;


    @Before
    public void setup(){
        String[] str = {"2Tr","6Ca","7Ca","8Tr","APi"};
        Card[] cardArray = new Card[5];
        ArrayList<Card> cardsAlreadyUsed= new ArrayList<>();
        UserInteraction.convertStringToCard(str, cardArray, cardsAlreadyUsed);
        m1 = new Hand(1, cardArray);
    }

    @Test
    public void setHandValueTest(){
        //assertThat(m1.)
    }

    @Test
    public void analyzeHandTest(){
        //assertThat(m1.getHandValue()).isEqualTo(hand.HandValue.CARTE_HAUTE);
    }

    @Test
    public void hasFlushTest(){
        //assertThat()
    }

    @Test
    public void hasStraightTest(){

    }

    @Test
    public void compareToTest(){

    }
}
