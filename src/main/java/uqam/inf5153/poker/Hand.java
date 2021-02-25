package uqam.inf5153.poker;

import java.util.Arrays;

public class Hand {

    private Card[] cards;

    /**
     * Class constructor.
     *
     * @param   cards   An array containing the cards
     * @throws  IllegalArgumentException    If the size of the cards parameter is not 5
     */
    public Hand(Card[] cards) throws IllegalArgumentException {
        if (cards.length == 5) {
            this.cards = cards;
            Arrays.sort(cards, new Card.CompareByValue());
        } else {
            throw new IllegalArgumentException("Une main doit être composée de 5 cartes.");
        }
    }

    /**
     * Return the cards of the hand.
     *
     * @return  an array of the hands' cards.
     */
    public Card[] getCards () {
        return cards;
    }

    /**
     * Returns a String with the value and colors of each cards.
     *
     * @return  a String with the value and color of each card
     */
    @Override
    public String toString() {
        String result = "";

        for (Card card : cards) {
            result += card.toString() + "\n";
        }

        return result;
    }
}