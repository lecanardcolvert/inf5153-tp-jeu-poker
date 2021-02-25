package uqam.inf5153.poker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HandTest {
    Card card1 = new Card(Value.ONE, Color.SPADES);
    Card card2 = new Card(Value.TWO, Color.SPADES);
    Card card3 = new Card(Value.THREE, Color.SPADES);
    Card card4 = new Card(Value.FOUR, Color.SPADES);
    Card card5 = new Card(Value.FIVE, Color.SPADES);
    Card card6 = new Card(Value.SIX, Color.SPADES);

    @Test
    @DisplayName("Il doit être possible de créer une main de 5 cartes")
    public void constructorFiveCards() {
        Card[] cards = {card1, card2, card3, card4, card5};
        Hand hand = new Hand(cards);
        assertEquals(   "un de pique\n" +
                        "deux de pique\n" +
                        "trois de pique\n" +
                        "quatre de pique\n" +
                        "cinq de pique\n", hand.toString());

        Card[] cards1 = {card1, card2, card3, card4, card5, card6};
        Exception exception1 = assertThrows(Exception.class, () -> new Hand(cards1));
        assertEquals("Une main doit être composée de 5 cartes.", exception1.getMessage());

        Card[] cards2 = {card1, card2};
        Exception exception2 = assertThrows(Exception.class, () -> new Hand(cards2));
        assertEquals("Une main doit être composée de 5 cartes.", exception2.getMessage());
    }

    @Test
    @DisplayName("Il ne doit pas être possible de créer une main de plus ou moins de 5 cartes")
    public void constructorNotFiveCards() {
        Card[] cards1 = {card1, card2, card3, card4, card5, card6};
        Exception exception1 = assertThrows(Exception.class, () -> new Hand(cards1));
        assertEquals("Une main doit être composée de 5 cartes.", exception1.getMessage());

        Card[] cards2 = {card1, card2};
        Exception exception2 = assertThrows(Exception.class, () -> new Hand(cards2));
        assertEquals("Une main doit être composée de 5 cartes.", exception2.getMessage());
    }
}
