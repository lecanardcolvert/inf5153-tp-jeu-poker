package uqam.inf5153.poker;

import java.util.NoSuchElementException;

public enum Value {

    ONE     ('1', 1, "un"),
    TWO     ('2', 2, "deux"),
    THREE   ('3', 3, "trois"),
    FOUR    ('4', 4, "quatre"),
    FIVE    ('5', 5, "cinq"),
    SIX     ('6', 6, "six"),
    SEVEN   ('7', 7, "sept"),
    EIGHT   ('8', 8, "huit"),
    NINE    ('9', 9, "neuf"),
    TEN     ('T', 10, "dix"),
    JACK    ('J', 11, "le valet"),
    QUEEN   ('Q', 12, "la reine"),
    KING    ('K', 13, "le roi"),
    ACE     ('A', 14, "l'as");

    /**
     * Returns a Value matching the symbol passed in parameter.
     *
     * @param   symbol The symbol of the value
     * @throws  NoSuchElementException  If no value is found
     */
    public static Value findBySymbol(char symbol) throws NoSuchElementException {
        Value result = null;

        for (Value value : values()) {
            if (value.symbol == symbol) {
                result = value;
            }
        }

        if (result == null) {
            throw new NoSuchElementException("Aucune valeur trouvée avec ce symbole.");
        }

        return result;
    }

    private char symbol;
    private int rank;
    private String word;

    /**
     * Class constructor.
     *
     * @param   symbol  The value symbol
     * @param   rank    The rank of the value
     * @param   word    The word representing the value
     */
    private Value(char symbol, int rank, String word) {
        this.symbol = symbol;
        this.rank = rank;
        this.word = word;
    }

    /**
     * Returns the rank of the value.
     * For example, ONE is 1, ACE is 14.
     *
     * @return  an int representing the rank of the value
     */
    public int getRank() {
        return rank;
    }

    /**
     * Returns the word of the value.
     * For example, "le roi" for KING.
     *
     * @return  a String that matches the word of the value.
     */
    public String getWord() {
        return word;
    }

    /**
     * Returns the word of the color.
     * For example, "pique" for SPADES.
     *
     * @return  a String that matches the word of the color.
     */
    @Override
    public String toString() {
        return word;
    }
}