package card;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardSuitTest {
    @Test
    public void shouldReturnStr1() {
        assertEquals(CardSuit.Pique.getStr(),"Pi");
        assertEquals(CardSuit.Carreau.getStr(),"Ca");
        assertEquals(CardSuit.Coeur.getStr(),"Co");
        assertEquals(CardSuit.Trefle.getStr(),"Tr");
    }
}
