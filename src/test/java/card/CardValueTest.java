package card;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardValueTest {
    @Test
    public void shouldReturnStr1() {
        assertEquals(CardValue.As.getStr1(),"A");
        assertEquals(CardValue.Roi.getStr1(),"R");
        assertEquals(CardValue.Dame.getStr1(),"D");
        assertEquals(CardValue.Valet.getStr1(),"V");
        assertEquals(CardValue.Dix.getStr1(),"10");
        assertEquals(CardValue.Neuf.getStr1(),"9");
        assertEquals(CardValue.Huit.getStr1(),"8");
        assertEquals(CardValue.Sept.getStr1(),"7");
        assertEquals(CardValue.Six.getStr1(),"6");
        assertEquals(CardValue.Cinq.getStr1(),"5");
        assertEquals(CardValue.Quatre.getStr1(),"4");
        assertEquals(CardValue.Trois.getStr1(),"3");
        assertEquals(CardValue.Deux.getStr1(),"2");
    }

    @Test
    public void shouldReturnStr2(){
        assertEquals(CardValue.As.getStr2(),"As");
        assertEquals(CardValue.Roi.getStr2(),"Roi");
        assertEquals(CardValue.Dame.getStr2(),"Dame");
        assertEquals(CardValue.Valet.getStr2(),"Valet");
        assertEquals(CardValue.Dix.getStr2(),"10");
        assertEquals(CardValue.Neuf.getStr2(),"9");
        assertEquals(CardValue.Huit.getStr2(),"8");
        assertEquals(CardValue.Sept.getStr2(),"7");
        assertEquals(CardValue.Six.getStr2(),"6");
        assertEquals(CardValue.Cinq.getStr2(),"5");
        assertEquals(CardValue.Quatre.getStr2(),"4");
        assertEquals(CardValue.Trois.getStr2(),"3");
        assertEquals(CardValue.Deux.getStr2(),"2");
    }
}
