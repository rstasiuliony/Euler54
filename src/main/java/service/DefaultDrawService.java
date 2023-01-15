package service;

import java.util.List;

import domain.Card;
import domain.Hand;

public class DefaultDrawService implements DrawService {
    @Override
    public Hand getWinner(Hand firstPlayer, Hand secondPlayer) {
        return isFirstPlayerWinner(firstPlayer, secondPlayer) ? firstPlayer : secondPlayer;
    }

    private boolean isFirstPlayerWinner(Hand first, Hand second) {
        return switch (first.getHandRanking()) {
            case HIGHCARD, FLUSH, STRAIGHT, STRAIGHTFLUSH -> hasFirstPlayerHighestCard(first, second);
            case ONEPAIR, TWOPAIRS -> hasFirstPlayerWinningPairs(first, second);
            case THREEOFAKIND -> hasFirstPlayerWinning3or4Kind(first, second);
            default -> throw new IllegalArgumentException("Unsupported value");
        };
    }

    private boolean hasFirstPlayerHighestCard(Hand first, Hand second) {
        List<Card> tempFirst = HandAnalyzer.sortByValue(first.getPlayersCards());
        List<Card> tempSecond = HandAnalyzer.sortByValue(second.getPlayersCards());
        return tempFirst.get(0).getValue().getValueWeight() > tempSecond.get(0).getValue().getValueWeight();
    }

    private boolean hasFirstPlayerWinningPairs(Hand first, Hand second) {
        int firstWeight = first.getWinningValue().getValueWeight();
        int secondWeight = second.getWinningValue().getValueWeight();
        if (firstWeight == secondWeight) {
            return hasFirstPlayerHighestCard(first, second);
        }
        return firstWeight > secondWeight;
    }

    private boolean hasFirstPlayerWinning3or4Kind(Hand first, Hand second) {
        return first.getWinningValue().getValueWeight() > second.getWinningValue().getValueWeight();
    }
}
