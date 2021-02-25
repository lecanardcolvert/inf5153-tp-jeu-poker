package uqam.inf5153.poker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerGameTest {

    @Test
    @DisplayName("Il doit être possible d'ajouter des joueurs à une table")
    public void addPlayer() {
        PokerGame pokerGame = new PokerGame();
        Player player1 = new Player("Alexandre");
        Player player2 = new Player("Jean");

        // pokerGame.addPlayer(player1); TODO Corriger ceci
        // pokerGame.addPlayer(player2); TODO Corriger ceci
        ArrayList<Player> players = pokerGame.getPlayers();

        assertEquals("Alexandre", players.get(0).getName());
        assertEquals("Jean", players.get(1).getName());
    }

    @Test
    @DisplayName("Il ne doit être possible d'ajouter plus de 10 joueurs à une table")
    public void addPlayerTooMuch() {
        PokerGame pokerGame = new PokerGame();
        Player player1 = new Player("Alexandre");
        Player player2 = new Player("Hélène");
        Player player3 = new Player("Sébastien");
        Player player4 = new Player("Carolle");
        Player player5 = new Player("Guy");
        Player player6 = new Player("Anne");
        Player player7 = new Player("Claude");
        Player player8 = new Player("Richard");
        Player player9 = new Player("Philippe");
        Player player10 = new Player("Lambert");
        Player player11 = new Player("Sophie");

        /*
        pokerGame.addPlayer(player1);
        pokerGame.addPlayer(player2);
        pokerGame.addPlayer(player3);
        pokerGame.addPlayer(player4);
        pokerGame.addPlayer(player5);
        pokerGame.addPlayer(player6);
        pokerGame.addPlayer(player7);
        pokerGame.addPlayer(player8);
        pokerGame.addPlayer(player9);
        pokerGame.addPlayer(player10);


        Exception exception1 = assertThrows(Exception.class, () -> pokerGame.addPlayer(player11));
        assertEquals("Impossible d'ajouter un joueur supplémentaire. Le maximum de " +
                "joueurs est 10.", exception1.getMessage());
        // TODO Corriger ceci
         */

    }

    @Test
    @DisplayName("Il ne doit pas être possible d'ajouter le même joueur 2 fois à la même table")
    public void addPlayerExisting() {
        PokerGame pokerGame = new PokerGame();
        Player player1 = new Player("Alexandre");

        /*
        pokerGame.addPlayer(player1);

        Exception exception1 = assertThrows(Exception.class, () -> pokerGame.addPlayer(player1));
        assertEquals("Impossible d'ajouter un joueur déjà à la table.", exception1.getMessage());
        // TODO Corriger ceci
         */
    }

}
