package uqam.inf5153.poker;

/*
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MainTest {


    @Before public void initResult() { Main.result = null; }

    // P1 Wins

    @Test public void p1F_p2H() {
        String p1 = "2D 5D QD KD 7D";
        String p2 = "1S 4C KH TD 3S";
        Main.main(new String[] {p1, p2});
        assertEquals("P1", Main.result);
    }

    @Test public void p1F_p2P() {
        String p1 = "2D 5D QD KD 7D";
        String p2 = "1S 4C 1H TD 3S";
        Main.main(new String[] {p1, p2});
        assertEquals("P1", Main.result);
    }

    @Test public void p1F_p2F() {
        String p1 = "2D 5D QD KD 7D" ;
        String p2 = "1H 4H JH TH 3H" ;
        Main.main(new String[] {p1, p2});
        assertEquals("P1", Main.result);
    }

    // P2 Wins

    @Test public void p2F_p1H() {
        String p1 = "1S 4C KH TD 3S";
        String p2 = "2D 5D QD KD 7D";
        Main.main(new String[] {p1, p2});
        assertEquals("P2", Main.result);
    }

    @Test public void p2F_p1P() {
        String p1 = "1S 4C 1H TD 3S" ;
        String p2 = "2D 5D QD KD 7D";
        Main.main(new String[] {p1, p2});
        assertEquals("P2", Main.result);
    }

    @Test public void p2F_p1F() {
        String p1 = "1H 4H JH TH 3H";
        String p2 = "2D 5D QD KD 7D";
        Main.main(new String[] {p1, p2});
        assertEquals("P2", Main.result);
    }

    // Tie cases

    @Test public void tie_F() {
        String p1 = "3H 8H JH KH 7H";
        String p2 = "2D 5D QD KD 7D";
        Main.main(new String[] {p1, p2});
        assertEquals("TIE", Main.result);
    }

    @Test public void tie_P() {
        String p1 = "1S 4C 1H TD 3S" ;
        String p2 = "1C 5H 1D KS 7C";
        Main.main(new String[] {p1, p2});
        assertEquals("TIE", Main.result);
    }

    @Test public void tie_H() {
        String p1 = "1S 4D JH TD 3H";
        String p2 = "2D 5S JD 3D 7D";
        Main.main(new String[] {p1, p2});
        assertEquals("TIE", Main.result);
    }

    // Error cases

    @Test public void tooManyCards() {
        String p1 = "3H 8H JH KH 7H 7C";
        String p2 = "2D 5D QD KD 7D";
        Main.main(new String[] {p1, p2});
        assertEquals("ERROR", Main.result);
    }

    @Test public void notEnoughCards() {
        String p1 = "3H 8H JH KH 7H";
        String p2 = "2D 5D QD KD";
        Main.main(new String[] {p1, p2});
        assertEquals("ERROR", Main.result);
    }

    @Test public void unknownValue() {
        String p1 = "3H XH JH KH 7H";
        String p2 = "2D 5D QD KD 7D";
        Main.main(new String[] {p1, p2});
        assertEquals("ERROR", Main.result);
    }

    @Test public void unknownSuit() {
        String p1 = "3H 8H JH KH 7H";
        String p2 = "2D 5D QX KD 7D";
        Main.main(new String[] {p1, p2});
        assertEquals("ERROR", Main.result);
    }

    // Extension : Detect cheating

    @Ignore
    @Test public void sameCardTwice() {
        String p1 = "3H 8H JH KH 7H";
        String p2 = "2D 8H QH KD 7D";
        Main.main(new String[] {p1, p2});
        assertEquals("ERROR", Main.result);
    }


}
        */