package uqam.inf5153.poker;

import java.util.Comparator;

public class Card {

    private Color color;
    private Value value;

    static class CompareByColor implements Comparator<Card> {
        @Override
        public int compare(Card c1, Card c2) {
            return c1.color.compareTo(c2.color);
        }
    }

    static class CompareByValue implements Comparator<Card> {
        @Override
        public int compare(Card c1, Card c2) {
            return c1.value.compareTo(c2.value);
        }
    }

    /**
     * Class constructor.
     *
     * @param   value   The card value
     * @param   color   The card color
     * @throws  IllegalArgumentException    If the color or value is null
     */
    public Card(Value value, Color color) throws IllegalArgumentException {
        if (color != null && value != null) {
            this.color = color;
            this.value = value;
        } else {
            throw new IllegalArgumentException("La valeur et la couleur ne peuvent être nulles.");
        }
    }

    /**
     * Returns the card color.
     *
     * @return  the color of the card
     */
    public Color getColor() {
        return color;
    }

    /**
     * Returns the card value.
     *
     * @return  the value of the card
     */
    public Value getValue() {
        return value;
    }

    /**
     * Returns a String containing the value and color of the card.
     * For example, "deux de pique".
     *
     * @return  a String containing the value and color of the card
     */
    @Override
    public String toString() {
        return value + " de " + color;
    }
}