package uqam.inf5153.poker;

public class PlayPoker {

    /**
     * Starts a new Poker game.
     *
     * The user can start the program with arguments or not. The arguments
     * has to be the players' hands. If no arguments are given, the program
     * will ask the user to input the players' names. Then, it will ask the
     * user to input the players' hands. After the hands have been set, the
     * results of the game and the scoreboard are printed. The user can start
     * another game as long as he wants.
     *
     * @param   args    The hands for each player (optional)
     */
    public static void main(String[] args) {
        PokerGame pokerGame = new PokerGame();
        System.out.println("Bienvenue dans le projet de programmation d'un jeu de Poker.");

        if (args.length > 0) {
            System.out.println("Les cartes sont passées en paramètre. La partie débute.");
            try {
                pokerGame.quickStart(args);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Le logiciel ne peut pas continuer. Il va s'arrêter.");
                System.exit(1);
            }
        } else {
            pokerGame.start();
        }
        System.exit(0);
    }
}
