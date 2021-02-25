package uqam.inf5153.poker;

public class Player {

    private static final int MIN_NAME_LENGTH = 0;
    private static final int MAX_NAME_LENGTH = 15;

    private Hand hand;
    private String name;

    /**
     * Class constructor.
     *
     * @param   name    The name of the player
     * @throws  IllegalArgumentException    If the name of the player is invalid
     */
    public Player(String name) throws IllegalArgumentException {
        setName(name);
    }

    /**
     * Returns the hand of the player
     *
     * @return  the players' hand
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Sets the hand of the player.
     *
     * @param   hand    The players hand
     */
    public void setHand(Hand hand) {
        this.hand = hand;
    }

    /**
     * Returns the name of the player.
     *
     * @return  the players' name
     */
    public String getName() {
        return name;
    }

    /**
     * Verifies if a players name is valid.
     *
     * The names' length has to be between or equals minimum and maximum length.
     *
     * @param   name    The name of the player
     * @return  boolean true if valid, false if not
     */
    private boolean isNameValid(String name) {
        boolean result = false;

        if ((name.length() > 0) && (name.length() <= MAX_NAME_LENGTH)) {
            result = true;
        }

        return result;
    }

    /**
     * Sets the name of the player.
     *
     * @param   name The players' name
     * @throws  IllegalArgumentException    If the given name is invalid
     */
    private void setName(String name) throws IllegalArgumentException {
        if (isNameValid(name) == true) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("La longueur du nom doit être entre " + MIN_NAME_LENGTH + " " +
                    "et " + MAX_NAME_LENGTH + ".");
        }
    }

}
