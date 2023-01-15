package domain;

import java.util.List;

import domain.enums.Value;
import service.HandAnalyzer;
import service.enums.HandRanking;

public class Hand {

    private List<Card> cards;
    private Value winningValue;

    public Hand(List<Card> handCards) {
        cards = handCards;
    }

    public HandRanking getHandRanking() {
        if (HandAnalyzer.isRoyalFlush(this)) {
            return HandRanking.ROYALFLUSH;
        }
        if (HandAnalyzer.isStraightFlush(this)) {
            return HandRanking.STRAIGHTFLUSH;
        }
        if (HandAnalyzer.isFourOfAKind(this)) {
            return HandRanking.FOUROFAKIND;
        }
        if (HandAnalyzer.isFullHouse(this)) {
            return HandRanking.FULLHOUSE;
        }
        if (HandAnalyzer.isFlush(this)) {
            return HandRanking.FLUSH;
        }
        if (HandAnalyzer.isStraight(this)) {
            return HandRanking.STRAIGHT;
        }
        if (HandAnalyzer.isThreeOfKind(this)) {
            return HandRanking.THREEOFAKIND;
        }
        if (HandAnalyzer.isTwoPairs(this)) {
            return HandRanking.TWOPAIRS;
        }
        if (HandAnalyzer.isOnePair(this)) {
            return HandRanking.ONEPAIR;
        }
        return HandRanking.HIGHCARD;
    }

    public List<Card> getPlayersCards() {
        return cards;
    }

    public void setWinningValue(Value value) {
        winningValue = value;
    }

    public Value getWinningValue() {
        return winningValue;
    }
}
