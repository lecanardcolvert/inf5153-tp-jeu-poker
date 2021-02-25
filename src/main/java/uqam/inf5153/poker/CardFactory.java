package uqam.inf5153.poker;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class CardFactory {

    /**
     * Returns a new Card matching the symbols passed in parameter.
     *
     * The symbols are represented by the value of the card and the color.
     * For example, when passed '1C', it will return a Card of value ONE and color CLUBS.
     *
     * @param   symbols The symbols of the card, must be a length of 2
     * @throws  IllegalArgumentException    If the given symbols is invalid
     */
    public static Card getCard(String symbols) throws IllegalArgumentException {
        Card card;
        IllegalArgumentException exception = new IllegalArgumentException("La carte " + symbols + " est incorrecte. " +
                "Veuillez saisir une carte qui respecte le format VC où V représente une valeur (de 1 à A) et C " +
                "représente la couleur (H, D, C, S) de la carte.");;

        if (symbols != null && symbols.length() == 2) {
            try {
                Value value = Value.findBySymbol(symbols.charAt(0));
                Color color = Color.findBySymbol(symbols.charAt(1));
                card = new Card(value, color);
            } catch (NoSuchElementException e) {
                throw exception;
            }
        } else {
            throw exception;
        }

        return card;
    }

    /**
     * Returns a Card[] matching the symbols passed in parameter.
     *
     * Each symbols must be separated by a space.
     * For example, when passed '1C AS', it will return two Card.
     * First Card of value ONE and color CLUBS. Second card of value ACE and color SPADES.
     *
     * @param   symbols The symbols of the card, each duo must be separated by a space
     * @throws  IllegalArgumentException    If the given parameter is null or invalid
     */
    public static Card[] getCards(String symbols) throws IllegalArgumentException {
        if (symbols == null) throw new IllegalArgumentException("Cette fonction ne peut pas accepter une valeur " +
                "nulle.");

        ArrayList<Card> cardsList = new ArrayList<Card>();
        String[] cardsStrSplit = symbols.split(" ");

        for (String cardStr : cardsStrSplit) {
            cardsList.add(getCard(cardStr));
        }

        Card[] cardsArray = new Card[cardsList.size()];
        cardsArray = cardsList.toArray(cardsArray);

        return cardsArray;
    }

}
