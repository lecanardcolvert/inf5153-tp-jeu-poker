package uqam.inf5153.poker;

import java.util.ArrayList;
import java.util.HashMap;

public class Scoreboard extends HashMap<Player, Integer> {

    /**
     * Increments the winners scores in the scoreboard.
     *
     * @param   winners The list of the winners of the game
     */
    protected void incrementWinnerScores(ArrayList<Player> winners) {
        for (Player winner : winners) {
            int score = get(winner);
            score++;
            put(winner, score);
        }
    }

    /**
     * Prints the scoreboard.
     *
     */
    protected void print() {
        System.out.println("===========================");
        System.out.printf("%15s %10s", "JOUEUR", "SCORE");
        System.out.println();
        this.forEach((player, score) -> {
            System.out.format("%15s %10s", player.getName(), score);
            System.out.println();
        });
        System.out.println("===========================");
    }
}
