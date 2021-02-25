package uqam.inf5153.poker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardFactoryTest {
    CardFactory cardFactory = new CardFactory();

    @Test
    @DisplayName("Il doit être possible de générer une carte à partir d'un code valide'")
    public void getCardValid() {
        String cardStrGood1 = "1C";
        String cardStrGood2 = "AS";

        Card card1 = cardFactory.getCard(cardStrGood1);
        assertEquals("un de trèfle", card1.toString());

        Card card2 = cardFactory.getCard(cardStrGood2);
        assertEquals("l'as de pique", card2.toString());
    }

    @Test
    @DisplayName("Il ne doit pas être possible de générer une carte à partir d'un code invalide'")
    public void getCardInvalid() {
        String cardStrBad1 = "LOL";
        String cardStrBad2 = "7F98SD7F9SD";
        String cardStrBad3 = "22";

        Exception exception1 = assertThrows(Exception.class, () -> cardFactory.getCard(cardStrBad1));
        assertEquals("La carte LOL est incorrecte. Veuillez saisir une carte " +
                "qui respecte le format VC où V représente une valeur (de 1 à A) et C représente la couleur (H, D, " +
                "C, S) de la carte.", exception1.getMessage());

        Exception exception2 = assertThrows(Exception.class, () -> cardFactory.getCard(cardStrBad2));
        assertEquals("La carte 7F98SD7F9SD est incorrecte. Veuillez saisir une carte " +
                "qui respecte le format VC où V représente une valeur (de 1 à A) et C représente la couleur (H, D, " +
                "C, S) de la carte.", exception2.getMessage());

        Exception exception3 = assertThrows(Exception.class, () -> cardFactory.getCard(cardStrBad3));
        assertEquals("La carte 22 est incorrecte. Veuillez saisir une carte " +
                "qui respecte le format VC où V représente une valeur (de 1 à A) et C représente la couleur (H, D, " +
                "C, S) de la carte.", exception3.getMessage());
    }

    @Test
    @DisplayName("La fonction getCard doit pouvoir traiter la valeur null")
    public void getCardNull() {
        String cardStrBad1 = null;

        Exception exception1 = assertThrows(Exception.class, () -> cardFactory.getCard(cardStrBad1));
        assertEquals("La carte null est incorrecte. Veuillez saisir une carte " +
                "qui respecte le format VC où V représente une valeur (de 1 à A) et C représente la couleur (H, D, " +
                "C, S) de la carte.", exception1.getMessage());
    }

    @Test
    @DisplayName("Il doit être possible de générer plusieurs cartes à partir de codes valides")
    public void getCardsValid() {
        String cardsStrGood1 = "1C 2H 3D 4S 5C 6H 7D";

        Card[] cards1 = cardFactory.getCards(cardsStrGood1);
        assertEquals("un de trèfle", cards1[0].toString());
        assertEquals("deux de coeur", cards1[1].toString());
        assertEquals("trois de carreau", cards1[2].toString());
        assertEquals("quatre de pique", cards1[3].toString());
        assertEquals("cinq de trèfle", cards1[4].toString());
        assertEquals("six de coeur", cards1[5].toString());
        assertEquals("sept de carreau", cards1[6].toString());
        Exception exception1 = assertThrows(Exception.class, () -> cards1[7].toString());
        assertEquals("Index 7 out of bounds for length 7", exception1.getMessage());
    }

    @Test
    @DisplayName("Il ne doit pas être possible de générer plusieurs cartes à partir de codes invalides")
    public void getCardsInvalid() {
        String cardsStrBad1 = "1C 2H 7UP COKE";
        String cardsStrBad2 = "";

        Exception exception1 = assertThrows(Exception.class, () -> cardFactory.getCards(cardsStrBad1));
        assertEquals("La carte 7UP est incorrecte. Veuillez saisir une carte " +
                "qui respecte le format VC où V représente une valeur (de 1 à A) et C représente la couleur (H, D, " +
                "C, S) de la carte.", exception1.getMessage());

        Exception exception2 = assertThrows(Exception.class, () -> cardFactory.getCards(cardsStrBad2));
        assertEquals("La carte  est incorrecte. Veuillez saisir une carte " +
                "qui respecte le format VC où V représente une valeur (de 1 à A) et C représente la couleur (H, D, " +
                "C, S) de la carte.", exception2.getMessage());
    }

    @Test
    @DisplayName("La fonction getCards doit pouvoir traiter la valeur null")
    public void getCardsNull() {
        String cardsStrBad1 = null;

        Exception exception1 = assertThrows(Exception.class, () -> cardFactory.getCards(cardsStrBad1));
        assertEquals("Cette fonction ne peut pas accepter une valeur nulle.", exception1.getMessage());
    }

}
