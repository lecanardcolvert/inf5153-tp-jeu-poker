package uqam.inf5153.poker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    @DisplayName("Il ne doit pas être possible de créer une carte avec des valeurs nulles")
    public void constructorNull() {
        Exception exception1 = assertThrows(Exception.class, () -> new Card(null, Color.HEARTS));
        assertEquals("La valeur et la couleur ne peuvent être nulles.", exception1.getMessage());

        Exception exception2 = assertThrows(Exception.class, () -> new Card(Value.ACE, null));
        assertEquals("La valeur et la couleur ne peuvent être nulles.", exception2.getMessage());

        Exception exception3 = assertThrows(Exception.class, () -> new Card(null, null));
        assertEquals("La valeur et la couleur ne peuvent être nulles.", exception3.getMessage());

    }

    @Test
    @DisplayName("Deux cartes avec la même valeur doivent être égales")
    public void compareCardByValueEquals() {
        int result;
        Card.CompareByValue compareByValue = new Card.CompareByValue();

        Card card1 = new Card(Value.ONE, Color.SPADES);
        Card card2 = new Card(Value.ONE, Color.CLUBS);
        result = compareByValue.compare(card1, card2);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Deux cartes qui n'ont pas la même valeur ne doivent pas être égales")
    public void compareCardByValueNotEquals() {
        int result;
        Card.CompareByValue compareByValue = new Card.CompareByValue();

        Card card1 = new Card(Value.NINE, Color.SPADES);
        Card card2 = new Card(Value.ACE, Color.CLUBS);
        result = compareByValue.compare(card1, card2);
        assertNotEquals(0, result);
    }

    @Test
    @DisplayName("Deux cartes avec la même couleur doivent être égales")
    public void compareCardByColorEquals() {
        int result;
        Card.CompareByColor compareByColor = new Card.CompareByColor();

        Card card1 = new Card(Value.ACE, Color.HEARTS);
        Card card2 = new Card(Value.SEVEN, Color.HEARTS);
        result = compareByColor.compare(card1, card2);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Deux cartes qui n'ont pas la même couleur ne doivent pas être égales")
    public void compareCardByColorNotEquals() {
        int result;
        Card.CompareByColor compareByColor = new Card.CompareByColor();

        Card card1 = new Card(Value.ACE, Color.DIAMONDS);
        Card card2 = new Card(Value.SEVEN, Color.SPADES);
        result = compareByColor.compare(card1, card2);
        assertNotEquals(0, result);
    }

}
