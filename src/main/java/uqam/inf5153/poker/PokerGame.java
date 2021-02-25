package uqam.inf5153.poker;

import java.util.*;

public class PokerGame {

    private static final String YES = "oui";
    private static final String NO = "non";
    private static final int MAX_PLAYERS = 10;

    private ArrayList<Player> players = new ArrayList<Player>();
    private Scoreboard scoreboard = new Scoreboard();

    /**
     * Class constructor.
     */
    public PokerGame() {
    }

    /**
     * Adds a player to the game.
     *
     * @param   player  The player
     * @throws  UnsupportedOperationException   If the maximum of players has been reached
     * @throws  UnsupportedOperationException   If the player is already in the players' list
     */
    private void addPlayer(Player player) throws UnsupportedOperationException {
        if (isMaxPlayersReached()) {
            throw new UnsupportedOperationException("Impossible d'ajouter un joueur supplémentaire. Le maximum de " +
                    "joueurs est " + MAX_PLAYERS + ".");
        } else if (isPlayerPresent(player)) {
            throw new UnsupportedOperationException("Impossible d'ajouter un joueur déjà à la table.");
        } else {
            players.add(player);
            scoreboard.put(player, 0);
        }
    }

    /**
     * Main loop for the poker game.
     *
     * Prints the winner of the last game and the scoreboard. Then, asks the user if he
     * wants to play again.
     *
     */
    private void continueGame() {
        gameloop:
        while(true) {
            ArrayList<Player> winners = Poker.getWinners(this);
            printResults(winners);
            incrementWinnerScores(winners);
            printScoreboard();

            while (true) {
                System.out.println("Voulez-vous jouer une autre partie ? Saisir " + YES + " ou " + NO + ".");
                String reponse = new Scanner(System.in).nextLine();

                if (reponse.equals(YES)) {
                    break;
                } else if (reponse.equals(NO)) {
                    break gameloop;
                } else {
                    System.out.println("Réponse invalide.");
                }
            }
            inputMorePlayers();
            inputHands();
        }
    }

    /**
     * Returns a list of the players of the game.
     *
     * @return  ArrayList<Player>   The players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Increments the winners scores in the scoreboard.
     *
     * @param   winners The list of the winners of the game
     */
    private void incrementWinnerScores(ArrayList<Player> winners) {
        scoreboard.incrementWinnerScores(winners);
    }

    /**
     * Asks the user to input the hands of the players.
     *
     */
    private void inputHands() {
        Scanner scanner = new Scanner(System.in);

        for (Player player : players) {
            System.out.println("Quelle est la main de " + player.getName() + " ?");

            while (true) {
                try {
                    Card[] cards = CardFactory.getCards(scanner.nextLine());
                    Hand hand = new Hand(cards);
                    player.setHand(hand);
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Veuillez saisir la main de " + player.getName() + " à nouveau.");
                }
            }
        }
    }

    /**
     * Asks the user to input a player's name.
     *
     */
    private void inputPlayer() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                Player player = new Player(scanner.nextLine());
                addPlayer(player);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Veuillez saisir le nom du joueur à nouveau.");
            }
        }
    }

    /**
     * Asks the user if he wants to add more players to the game.
     *
     */
    private void inputMorePlayers() {
        while (true) {
            if (players.size() < MAX_PLAYERS) {
                System.out.println("Voulez-vous ajouter un autre joueur ? Saisir " + YES + " ou " + NO + ".");
                String reponse = new Scanner(System.in).nextLine();

                if (reponse.equals(YES)) {
                    System.out.println("Quel est son nom ?");
                    inputPlayer();
                } else if (reponse.equals(NO)) {
                    break;
                } else {
                    System.out.println("Réponse invalide.");
                }
            } else {
                System.out.println("Le maximum de " + MAX_PLAYERS + " a été atteint.");
                break;
            }
        }
    }

    /**
     * Checks if a given player is already in the players list.
     *
     * @param   player  The player
     * @returns boolean True if the player is already in the players list, else false.
     */
    private boolean isPlayerPresent(Player player) {
        return (players.contains(player));
    }

    /**
     * Checks if the maximum of players have been reached.
     *
     * @returns boolean True if the maximum of player have been reached, else false.
     */
    private boolean isMaxPlayersReached() {
        return (players.size() == MAX_PLAYERS);
    }

    /**
     * Starts the first round with the given parameters.
     *
     * The players are created then a hand is assigned to each one. The players
     * are added to the game. Then, the game continues.
     *
     * @param   playerHands     The hands of the players
     * @throws  Exception       If there is an error with the parameters
     */
    public void quickStart(String[] playerHands) throws Exception {
        for (int i = 0; i < playerHands.length; i++) {
            Player player = new Player("J" + i);
            Hand hand = new Hand(CardFactory.getCards(playerHands[i]));
            player.setHand(hand);
            addPlayer(player);
        }
        continueGame();
    }

    /**
     * Starts the first round.
     *
     * The systems asks for user to input the first two players' names and their hand.
     * Then, the game continues.
     *
     */
    public void start() {
        System.out.println("Quel est le nom du joueur 1 ?");
        inputPlayer();
        System.out.println("Quel est le nom du joueur 2 ?");
        inputPlayer();
        inputMorePlayers();
        inputHands();
        continueGame();
    }

    /**
     * Prints the results of the game.
     *
     * @param   winners     The winners of the game
     */
    private void printResults(ArrayList<Player> winners) {
        System.out.println("Résultat de la partie :");

        if (winners.size() == 1) {
            System.out.println( winners.get(0).getName()
                                + " gagne la partie. Sa main gagnante est : "
                                + Poker.valueHandInWords(winners.get(0).getHand())
                                + ".");
        } else {
            System.out.print("C'est une égalité entre ");

            for (int i = 0; i < winners.size(); i++) {
                System.out.print(winners.get(i).getName());

                if (i != (winners.size() - 1)) {
                    System.out.print(", ");
                }
            }
            System.out.println( ". Leur main gagnante est : "
                                + Poker.valueHandInWords(winners.get(0).getHand())
                                + ".");
        }
    }

    /**
     * Prints the scoreboard.
     *
     */
    private void printScoreboard() {
        scoreboard.print();
    }
}