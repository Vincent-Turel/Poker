package hand;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandValueTest {
    @Test
    public void should() {
        assertEquals(HandValue.CARTE_HAUTE.getStr(),"une carte haute : ");
        assertEquals(HandValue.PAIRE.getStr(),"une paire de ");
        assertEquals(HandValue.DOUBLE_PAIRE.getStr(),"une double paire ");
        assertEquals(HandValue.BRELAN.getStr(),"un brelan de");
        assertEquals(HandValue.SUITE.getStr(),"une suite de hauteur ");
        assertEquals(HandValue.COULEUR.getStr(),"une couleur de hauteur ");
        assertEquals(HandValue.FULL.getStr(),"un full ");
        assertEquals(HandValue.CARRE.getStr(),"un carré de ");
        assertEquals(HandValue.QUINTE_FLUSH.getStr(),"une quinte flush de hauteur ");
    }
}
