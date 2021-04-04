# Java Cards Library
A lightweight simple library for creating card games and handling cards\
There will be more examples of different card games added in the future as this project is still in the development stage, although you can already use it for the barebones of a card project.\
\
**Example**

```java
import me.gleeming.cards.card.Card;
import me.gleeming.cards.deck.CardDeck;

class Example {
    public void exampleCreatingDeck() {
        // Create a new deck and choose whether or not you want jokers
        CardDeck deck = Card.createDeck(false);
        
        // Shuffle the deck
        deck.shuffle();

        // You can take the top card off the deck
        Card card = deck.takeTopCard();
        
        // Split the cards between an amount of players
        // The parameter is for the number of players
        // (Useful for games like "Bullshit")
        List<CardDeck> decks = deck.split(4);
        
        // You can deal the cards to the amount of players
        // and amount of cards to your choosing
        // (This example would deal 7 each to 3 players)
        List<CardDeck> decks = deck.deal(7, 3);
    }
}
```
