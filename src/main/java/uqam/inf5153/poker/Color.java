package uqam.inf5153.poker;

import java.util.NoSuchElementException;

public enum Color {

    HEARTS      ('H', "coeur"),
    DIAMONDS    ('D', "carreau"),
    CLUBS       ('C', "trèfle"),
    SPADES      ('S', "pique");

    /**
     * Returns a Color matching the symbol passed in parameter.
     *
     * @param   symbol The symbol of the color
     * @throws  NoSuchElementException  If no color is found
     */
    public static Color findBySymbol(char symbol) throws NoSuchElementException {
        Color result = null;

        for (Color color : values()) {
            if (color.symbol == symbol) {
                result = color;
            }
        }

        if (result == null) {
            throw new NoSuchElementException("Aucune couleur trouvée avec ce symbole.");
        }

        return result;
    }

    private char symbol;
    private String word;

    /**
     * Class constructor.
     *
     * @param   symbol  The symbol of the color
     * @param   word    The word representing the color
     */
    private Color(char symbol, String word) {
        this.symbol = symbol;
        this.word = word;
    }

    /**
     * Returns the word of the color.
     * For example, "pique" for SPADES.
     *
     * @return  a String that matches the word of the color.
     */
    public String getWord() {
        return word;
    }

    /**
     * Returns the word of the color.
     * For example, "pique".
     *
     * @return  a String that matches the word of the color.
     */
    @Override
    public String toString() {
        return word;
    }
}
