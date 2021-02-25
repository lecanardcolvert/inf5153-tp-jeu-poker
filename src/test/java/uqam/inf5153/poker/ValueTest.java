package uqam.inf5153.poker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValueTest {

    @Test
    @DisplayName("Il doit être possible d'obtenir une valeur à partir de son symbole")
    public void findBySymbolValid() {
        Value value1 = Value.findBySymbol('A');
        assertEquals(14, value1.getRank());

        Value value2 = Value.findBySymbol('3');
        assertEquals(3, value2.getRank());
    }

    @Test
    @DisplayName("Il ne doit pas être possible d'obtenir une valeur à partir d'un symbole inconnu")
    public void findBySymbolInvalid() {
        Exception exception1 = assertThrows(Exception.class, () -> Value.findBySymbol('S'));
        assertEquals("Aucune valeur trouvée avec ce symbole.", exception1.getMessage());

        Exception exception2 = assertThrows(Exception.class, () -> Value.findBySymbol('P'));
        assertEquals("Aucune valeur trouvée avec ce symbole.", exception2.getMessage());
    }

}