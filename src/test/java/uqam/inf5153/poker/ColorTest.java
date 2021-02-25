package uqam.inf5153.poker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ColorTest {

    @Test
    @DisplayName("Il doit être possible d'obtenir une couleur à partir de son symbole")
    public void findBySymbolValid() {
        Color color1 = Color.findBySymbol('H');
        assertEquals("coeur", color1.getWord());

        Color color2 = Color.findBySymbol('C');
        assertEquals("trèfle", color2.getWord());
    }

    @Test
    @DisplayName("Il ne doit pas être possible d'obtenir une couleur à partir d'un symbole inconnu")
    public void findBySymbolInvalid() {
        Exception exception1 = assertThrows(Exception.class, () -> Color.findBySymbol('R'));
        assertEquals("Aucune couleur trouvée avec ce symbole.", exception1.getMessage());

        Exception exception2 = assertThrows(Exception.class, () -> Color.findBySymbol('Q'));
        assertEquals("Aucune couleur trouvée avec ce symbole.", exception2.getMessage());
    }
}