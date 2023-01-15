package service;

import java.util.List;

import domain.Card;
import domain.Hand;
import service.enums.HandRanking;

public class Dealer {

    private Hand firstPlayer;
    private Hand secondPlayer;

    public void startGame(List<Card> cards) {
        splitCardsToHands(cards);
    }

    private void splitCardsToHands(List<Card> cards) {
        firstPlayer = new Hand(cards.subList(0, 5));
        secondPlayer = new Hand(cards.subList(5, 10));
    }

    public boolean isFirstPlayerWinner() {
        if (getHandsWeight(firstPlayer.getHandRanking()) > getHandsWeight(secondPlayer.getHandRanking())) {
            return true;
        }
        if (getHandsWeight(firstPlayer.getHandRanking()) == getHandsWeight(secondPlayer.getHandRanking())) {
            DrawService service = new DefaultDrawService();
            Hand winner = service.getWinner(firstPlayer, secondPlayer);
            return winner.equals(firstPlayer);
        }
        return false;
    }

    private int getHandsWeight(HandRanking rank) {
        return switch (rank) {
            case HIGHCARD -> 20;
            case ONEPAIR -> 30;
            case TWOPAIRS -> 40;
            case THREEOFAKIND -> 50;
            case STRAIGHT -> 60;
            case FLUSH -> 70;
            case FULLHOUSE -> 80;
            case FOUROFAKIND -> 90;
            case STRAIGHTFLUSH -> 100;
            case ROYALFLUSH -> 110;
            default -> throw new IllegalArgumentException("Unsupported value");
        };
    }
}
