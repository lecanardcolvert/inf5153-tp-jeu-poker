package uqam.inf5153.poker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PokerTest {

    private final Card ONE_OF_SPADES = new Card(Value.ONE, Color.SPADES);
    private final Card TWO_OF_SPADES = new Card(Value.TWO, Color.SPADES);
    private final Card THREE_OF_SPADES = new Card(Value.THREE, Color.SPADES);
    private final Card FOUR_OF_SPADES = new Card(Value.FOUR, Color.SPADES);
    private final Card FIVE_OF_SPADES = new Card(Value.FIVE, Color.SPADES);
    private final Card FIVE_OF_HEARTS = new Card(Value.FIVE, Color.HEARTS);
    private final Card TEN_OF_DIAMONDS = new Card(Value.TEN, Color.DIAMONDS);
    private final Card ACE_OF_CLUBS = new Card(Value.ACE, Color.CLUBS);
    private final Card ACE_OF_HEARTS = new Card(Value.ACE, Color.HEARTS);

    @Test
    @DisplayName("Les règles doivent détecter la meilleure paire d'une main")
    public void getBestPairAces() {
        Card[] cards = {ONE_OF_SPADES, TWO_OF_SPADES, THREE_OF_SPADES, ACE_OF_CLUBS, ACE_OF_HEARTS};

        Card bestPairFirstCard = Poker.getBestPair(cards)[0];
        Card bestPairSecondCard = Poker.getBestPair(cards)[1];
        assertEquals(ACE_OF_CLUBS, bestPairFirstCard);
        assertEquals(ACE_OF_HEARTS, bestPairSecondCard);
    }

    @Test
    @DisplayName("Les règles doivent détecter qu'il n'y a aucune paire dans une main")
    public void getBestPairNone() {
        Card[] cards = {ONE_OF_SPADES, TWO_OF_SPADES, THREE_OF_SPADES, TEN_OF_DIAMONDS, ACE_OF_HEARTS};

        Card bestPairFirstCard = Poker.getBestPair(cards)[0];
        Card bestPairSecondCard = Poker.getBestPair(cards)[1];
        assertEquals(null, bestPairFirstCard);
        assertEquals(null, bestPairSecondCard);
    }

    @Test
    @DisplayName("Les règles doivent détecter lorsqu'une main a une paire")
    public void hasPairYes() {
        Card[] cards = {ONE_OF_SPADES, TWO_OF_SPADES, THREE_OF_SPADES, ACE_OF_CLUBS, ACE_OF_HEARTS};
        Hand hand = new Hand(cards);

        assertEquals(true, Poker.hasPair(hand));
    }

    @Test
    @DisplayName("Les règles doivent détecter lorsqu'une main n'a pas de paire")
    public void hasPairNo() {
        Card[] cards = {ONE_OF_SPADES, TWO_OF_SPADES, THREE_OF_SPADES, FOUR_OF_SPADES, FIVE_OF_SPADES};
        Hand hand = new Hand(cards);

        assertEquals(false, Poker.hasPair(hand));
    }

    @Test
    @DisplayName("Les règles doivent détecter lorsqu'une main est une flush")
    public void isFlushYes() {
        Card[] cards = {ONE_OF_SPADES, TWO_OF_SPADES, THREE_OF_SPADES, FOUR_OF_SPADES, FIVE_OF_SPADES};
        Hand hand = new Hand(cards);

        assertEquals(true, Poker.isFlush(hand));
    }

    @Test
    @DisplayName("Les règles doivent détecter lorsqu'une main n'est pas une flush")
    public void isFlushNo() {
        Card[] cards = {ONE_OF_SPADES, TWO_OF_SPADES, THREE_OF_SPADES, FOUR_OF_SPADES, FIVE_OF_HEARTS};
        Hand hand = new Hand(cards);

        assertEquals(false, Poker.isFlush(hand));
    }

    @Test
    @DisplayName("Les règles doivent évaluer correctement la valeur d'une main")
    public void valueHand() {
        Card[] cards1 = {ONE_OF_SPADES, TWO_OF_SPADES, THREE_OF_SPADES, FOUR_OF_SPADES, ACE_OF_HEARTS};
        Card[] cards2 = {ONE_OF_SPADES, TWO_OF_SPADES, THREE_OF_SPADES, ACE_OF_CLUBS, ACE_OF_HEARTS};
        Card[] cards3 = {ONE_OF_SPADES, TWO_OF_SPADES, THREE_OF_SPADES, FOUR_OF_SPADES, FIVE_OF_SPADES};
        Hand hand1 = new Hand(cards1);
        Hand hand2 = new Hand(cards2);
        Hand hand3 = new Hand(cards3);

        assertEquals(14, Poker.valueHand(hand1));
        assertEquals(114, Poker.valueHand(hand2));
        assertEquals(205, Poker.valueHand(hand3));
    }

    @Test
    @DisplayName("Les règles doivent pouvoir expliquer le contenu de la main gagnante")
    public void valueHandInWords() {
        Card[] cards1 = {ONE_OF_SPADES, TWO_OF_SPADES, THREE_OF_SPADES, FIVE_OF_SPADES, FOUR_OF_SPADES};
        Card[] cards2 = {ONE_OF_SPADES, TWO_OF_SPADES, THREE_OF_SPADES, ACE_OF_CLUBS, ACE_OF_HEARTS};
        Card[] cards3 = {ONE_OF_SPADES, TWO_OF_SPADES, THREE_OF_SPADES, TEN_OF_DIAMONDS, FIVE_OF_SPADES};
        Hand hand1 = new Hand(cards1);
        Hand hand2 = new Hand(cards2);
        Hand hand3 = new Hand(cards3);

        assertEquals("flush (pique) et carte haute (cinq)", Poker.valueHandInWords(hand1));
        assertEquals("paire de l'as", Poker.valueHandInWords(hand2));
        assertEquals("carte haute (dix)", Poker.valueHandInWords(hand3));
    }

    @Test
    @DisplayName("Les règles doivent évaluer correctement la valeur de la plus haute carte d'une main (14)")
    public void valueHighCard() {
        Card[] cards1 = {ONE_OF_SPADES, TWO_OF_SPADES, THREE_OF_SPADES, FOUR_OF_SPADES, ACE_OF_HEARTS};
        Card[] cards2 = {ONE_OF_SPADES, TWO_OF_SPADES, THREE_OF_SPADES, FOUR_OF_SPADES, TEN_OF_DIAMONDS};

        assertEquals(14, Poker.valueHighCard(cards1));
        assertEquals(10, Poker.valueHighCard(cards2));
    }
}