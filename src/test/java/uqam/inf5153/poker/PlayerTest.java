package uqam.inf5153.poker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    @DisplayName("Il ne doit pas être possible de créer un joueur avec un nom trop long")
    public void constructorNameTooLong() {
        Exception exception1 = assertThrows(Exception.class, () -> new Player("12345678901234567890"));
        assertEquals("La longueur du nom doit être entre 0 et 15.", exception1.getMessage());
    }

}