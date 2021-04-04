package me.gleeming.cards.deck;

import lombok.Getter;
import me.gleeming.cards.card.Card;

import java.util.*;

public class CardDeck {
    @Getter private final List<Card> cards;
    public CardDeck(Card... cards) { this.cards = Arrays.asList(cards); }
    public CardDeck(List<Card> cards) { this.cards = cards; }

    /**
     * Gets the card off top of the deck
     * @return Top Card
     */
    public Card getTopCard() {
        return cards.get(0);
    }

    /**
     * Takes the top card off the deck
     * @return Top Card
     */
    public Card takeTopCard() {
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

    /**
     * Has top card
     * @return Top Card or not
     */
    public boolean hasTopCard() {
        return cards.size() > 0;
    }

    /**
     * Shuffles the deck
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Splits the deck into requested decks
     *
     * @param amount New deck amount
     * @return Split Decks
     */
    public List<CardDeck> split(int amount) {
        HashMap<Integer, List<Card>> cardMap = new HashMap<>();

        while(hasTopCard()) {
            for(int i = 0; i < amount; i++) {
                List<Card> playerCards = cardMap.get(i);
                if(playerCards == null) playerCards = new ArrayList<>();

                if(hasTopCard()) playerCards.add(takeTopCard());
                cardMap.put(i, playerCards);
            }
        }

        List<CardDeck> decks = new ArrayList<>();
        cardMap.values().forEach(cards -> decks.add(new CardDeck(cards)));
        return decks;
    }

    /**
     * Deals the deck into requested decks
     *
     * @param cardAmount Amount of cards
     * @param deckAmount Amount of decks
     *
     * @return Requested Deal
     */
    public List<CardDeck> deal(int cardAmount, int deckAmount) {
        HashMap<Integer, List<Card>> cardMap = new HashMap<>();

        for(int i = 0; i < cardAmount; i++) {
            for(int deckIndex = 0; deckIndex < deckAmount; deckIndex++) {
                List<Card> playerCards = cardMap.get(i);
                if(playerCards == null) playerCards = new ArrayList<>();

                if(hasTopCard()) playerCards.add(takeTopCard());
                cardMap.put(i, playerCards);
            }
        }

        List<CardDeck> decks = new ArrayList<>();
        cardMap.values().forEach(cards -> decks.add(new CardDeck(cards)));
        return decks;
    }
}
