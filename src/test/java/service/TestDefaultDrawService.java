package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import domain.Card;
import domain.Hand;
import domain.enums.Value;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDefaultDrawService {

    private DrawService target;

    @BeforeEach
    public void setUp() {
        target = new DefaultDrawService();
    }

    @Test
    public void firstHandIsWinnerWhenFirstHandHasHighestCard() {
        List<Hand> hands = createHighestCardHands();
        Hand winner = target.getWinner(hands.get(0), hands.get(1));
        assertEquals(winner, hands.get(0));
    }

    @Test
    public void firstHandIsWinnerWhenEqualPair() {
        List<Hand> hands = createEqualPairHands();
        Hand winner = target.getWinner(hands.get(0), hands.get(1));
        assertEquals(winner, hands.get(0));
    }

    @Test
    public void firstHandIsWinnerWhenHigherPair() {
        List<Hand> hands = createNotEqualPairHands();
        Hand winner = target.getWinner(hands.get(0), hands.get(1));
        assertEquals(winner, hands.get(0));
    }

    @Test
    public void firstHandIsWinnerWhenHigher3OfKind() {
        List<Hand> hands = create3ofKindHands();
        Hand winner = target.getWinner(hands.get(0), hands.get(1));
        assertEquals(winner, hands.get(0));
    }

    private List<Hand> createHighestCardHands() {
        Hand first = new Hand(List.of(new Card("AC"), new Card("TD"), new Card("8D"), new Card("7D"), new Card("5S")));
        Hand second = new Hand(List.of(new Card("AC"), new Card("9D"), new Card("8D"), new Card("7C"), new Card("5C")));
        return List.of(first, second);
    }

    private List<Hand> createEqualPairHands() {
        Hand first = new Hand(List.of(new Card("AH"), new Card("AD"), new Card("3D"), new Card("7D"), new Card("5S")));
        first.setWinningValue(Value.ACE);
        Hand second = new Hand(List.of(new Card("AC"), new Card("AS"), new Card("2D"), new Card("7D"), new Card("5S")));
        second.setWinningValue(Value.ACE);
        return List.of(first, second);
    }

    private List<Hand> createNotEqualPairHands() {
        Hand first = new Hand(List.of(new Card("AH"), new Card("AD"), new Card("3D"), new Card("7D"), new Card("5S")));
        first.setWinningValue(Value.ACE);
        Hand second = new Hand(List.of(new Card("2C"), new Card("AS"), new Card("2D"), new Card("7D"), new Card("5S")));
        second.setWinningValue(Value.TWO);
        return List.of(first, second);
    }

    private List<Hand> create3ofKindHands() {
        Hand first = new Hand(List.of(new Card("AH"), new Card("AD"), new Card("AS"), new Card("7D"), new Card("5S")));
        first.setWinningValue(Value.ACE);
        Hand second = new Hand(List.of(new Card("2C"), new Card("2S"), new Card("2D"), new Card("7D"), new Card("5S")));
        second.setWinningValue(Value.TWO);
        return List.of(first, second);
    }
}
