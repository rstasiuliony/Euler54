package domain;

import domain.enums.Suit;
import domain.enums.Value;

public class Card {

    private Value value;
    private Suit suit;

    public Card(String card) {
        value = Value.getValue(card.charAt(0));
        suit = Suit.getSuit(card.charAt(1));
    }

    public Suit getSuite() {
        return suit;
    }

    public Value getValue() {
        return value;
    }
}
