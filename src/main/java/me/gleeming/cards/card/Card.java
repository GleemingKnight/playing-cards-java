package me.gleeming.cards.card;

import lombok.Data;
import lombok.Getter;
import me.gleeming.cards.deck.CardDeck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Card {
    private final CardSuite suite;
    private final CardType type;

    /**
     * Suite controller
     */
    public enum CardSuite { SPADE, HEART, CLUB, DIAMOND, JOKER }

    /**
     * Type controller
     */
    public enum CardType {
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), JOKER(0);

        @Getter private final int value;
        CardType(int value) {
            this.value = value;
        }
    }

    /**
     * Creates a deck
     *
     * @param jokers Whether or not you want jokers in the deck
     * @return Created Deck
     */
    public static CardDeck createDeck(boolean jokers) {
        List<Card> cards = new ArrayList<>();

        Arrays.stream(CardSuite.values()).forEach(cardSuite -> {
            if(cardSuite != CardSuite.JOKER) Arrays.stream(CardType.values()).forEach(cardType -> {
                if(cardType != CardType.JOKER) cards.add(new Card(cardSuite, cardType));
            });
        });

        if(jokers) {
            Card joker = new Card(CardSuite.JOKER, CardType.JOKER);
            cards.addAll(Arrays.asList(joker, joker));
        }

        return new CardDeck(cards);
    }
}
