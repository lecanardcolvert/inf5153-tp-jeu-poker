package uqam.inf5153.poker;

import java.util.*;

public class Poker {

    private static final int FLUSH_SCORE = 200;
    private static final int PAIR_SCORE = 100;

    /**
     * Returns Card[] containing the best pair in a given array of cards, or Card[] containing null
     * if no pairs are found.
     *
     * @param   cards   The array of cards to look into
     * @returns Card[]  Two Card of same value, or two null cards if no pair found
     * @throws  NullPointerException    If the input is null
     */
    public static Card[] getBestPair(Card[] cards) throws NullPointerException {
        Card[] bestPair = new Card[2];
        Card.CompareByValue compareByValue = new Card.CompareByValue();

        for (int i = 0; i < (cards.length - 1); i++) {
            for (int j = 1; j < cards.length; j++) {
                boolean areSameValue = (compareByValue.compare(cards[i], cards[j]) == 0);

                if ((i != j) && (areSameValue)) {
                    if (bestPair[0] == null && bestPair[1] == null) {
                        bestPair[0] = cards[i];
                        bestPair[1] = cards[j];
                    } else if (compareByValue.compare(cards[i], bestPair[0]) > 0) {
                        bestPair[0] = cards[i];
                        bestPair[1] = cards[j];
                    }
                }
            }
        }

        return bestPair;
    }

    /**
     * Returns the Card with the highest value in a given array of cards.
     *
     * @param   cards   The array of cards to look into
     * @returns Card    The Card with the highest value
     */
    private static Card getHighCard(Card[] cards) {
        int highCardValue = 0;
        Card highCard = cards[0];

        for (int i = 0; i < cards.length; i++) {
            int cardValue = cards[i].getValue().getRank();

            if (highCardValue < cardValue) {
                highCard = cards[i];
                highCardValue = cardValue;
            }
        }

        return highCard;
    }

    /**
     * Returns the results of a poker game.
     *
     * @param   pokerGame   The poker game
     * @returns HashMap<Player, Integer>    A map containing each Player and its score
     */
    public static Scoreboard getResults(PokerGame pokerGame) {
        Scoreboard results = new Scoreboard();

        for (Player player : pokerGame.getPlayers()) {
            Hand hand = player.getHand();
            results.put(player, valueHand(hand));
        }

        return results;
    }

    /**
     * Returns the winners of a poker game.
     *
     * The result of each player is calculated. Then, the player(s) with the highest scores
     * are added to the list.
     *
     * @param   pokerGame   The poker game
     * @returns ArrayList<Player>   The list of the winners
     */
    public static ArrayList<Player> getWinners(PokerGame pokerGame) {
        HashMap<Player, Integer> results = getResults(pokerGame);
        ArrayList<Player> winners = new ArrayList<>();
        int highestResult = 0;

        for (HashMap.Entry<Player, Integer> playerResult : results.entrySet()) {
            if (playerResult.getValue() > highestResult) {
                winners.clear();
                winners.add(playerResult.getKey());
                highestResult = playerResult.getValue();
            } else if (playerResult.getValue() == highestResult) {
                winners.add(playerResult.getKey());
            }
        }

        return winners;
    }

    /**
     * Checks if a hand contains a pair.
     *
     * A pair is defined by two Card of the same value in the same hand.
     *
     * @param   hand    The hand
     * @returns boolean True if a pair is found, or false.
     */
    public static boolean hasPair(Hand hand) {
        boolean result = false;

        Card[] cards = hand.getCards();
        Card.CompareByValue compareByValue = new Card.CompareByValue();

        loop:
        for (int i = 1; i < cards.length; i++) {
            for (int j = 1; j < cards.length; j++) {
                boolean sameValue = (compareByValue.compare(cards[i - 1], cards[i]) == 0);

                if ((i != j) && (sameValue == true)) {
                    result = true;
                    break loop;
                }
            }
        }

        return result;
    }

    /**
     * Checks if a hand is a flush.
     *
     * A flush is defined by five Card of the same color.
     *
     * @param   hand    The hand
     * @returns boolean True if the hand is a flush, or false.
     */
    public static boolean isFlush(Hand hand) {
        boolean result = true;

        Card[] cards = hand.getCards();
        Card.CompareByColor compareByColor = new Card.CompareByColor();

        for (int i = 1; i < cards.length; i++) {
            boolean differentColor = (compareByColor.compare(cards[i - 1], cards[i]) != 0);

            if (differentColor == true) {
                result = false;
                break;
            }
        }

        return result;
    }

    /**
     * Calculates and returns the value of a hand. A higher value is a better hand.
     *
     * The value is calculated by a set of rules.
     * A flush and a high card beats a flush with a lower high card.
     * A flush beats a pair.
     * A pair beats a high card.
     *
     * @param   hand    The hand
     * @returns int     The value of the hand
     */
    public static int valueHand(Hand hand) {
        Card[] cards = hand.getCards();
        int value = valueHighCard(cards);

        if (isFlush(hand) == true) {
            value += FLUSH_SCORE;
        } else if (hasPair(hand) == true) {
            value += PAIR_SCORE;
        }

        return value;
    }

    /**
     * Returns the value of a hand in words.
     *
     * @param   hand    The hand
     * @returns String  The value of the hand in words
     */
    public static String valueHandInWords(Hand hand) {
        String handValueInWords = null;
        Card[] cards = hand.getCards();
        Card highCard = getHighCard(cards);
        String highCardValueInWords =   "carte haute ("
                                        + highCard.getValue().getWord()
                                        +")";
        if (isFlush(hand)) {
            handValueInWords    = "flush ("
                                + hand.getCards()[0].getColor().getWord()
                                + ") et "
                                + highCardValueInWords;
        } else if (hasPair(hand)) {
            Card[] pair = Poker.getBestPair(cards);
            handValueInWords    = "paire de "
                                + pair[0].getValue().getWord();
        } else {
            handValueInWords    = highCardValueInWords;
        }

        return handValueInWords;
    }

    /**
     * Returns the value of the highest Card in a given array of cards
     *
     * @param   cards   The array of cards
     * @returns int     The value of the highest Card
     */
    public static int valueHighCard(Card[] cards) {

        return getHighCard(cards).getValue().getRank();
    }
}