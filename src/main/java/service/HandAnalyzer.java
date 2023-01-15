package service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import domain.Card;
import domain.Hand;
import domain.enums.Suit;
import domain.enums.Value;

public class HandAnalyzer {

    public static boolean isRoyalFlush(Hand hand) {
        List<Card> cards = hand.getPlayersCards();
        if (!HandAnalyzer.isSameSuit(cards)) {
            return false;
        }
        cards = HandAnalyzer.sortByValue(cards);
        if (!Value.ACE.equals(cards.get(cards.size() - 1).getValue())) {
            return false;
        }
        return HandAnalyzer.isConsecutiveValue(cards);
    }

    public static boolean isStraightFlush(Hand hand) {
        List<Card> cards = hand.getPlayersCards();
        if (!HandAnalyzer.isSameSuit(cards)) {
            return false;
        }
        return HandAnalyzer.isConsecutiveValue(HandAnalyzer.sortByValue(cards));
    }

    public static boolean isFourOfAKind(Hand hand) {
        return HandAnalyzer.isXOfKind(hand, 4);
    }

    public static boolean isFullHouse(Hand hand) {
        List<Card> cards = hand.getPlayersCards();
        Map<Value, Integer> cardCount = new HashMap<>();
        cards.forEach(card -> {
            if (cardCount.get(card.getValue()) == null) {
                cardCount.put(card.getValue(), 1);
            } else {
                cardCount.replace(card.getValue(), cardCount.get(card.getValue()) + 1);
                if (cardCount.containsValue(3)) {
                    hand.setWinningValue(card.getValue());
                }
            }
        });
        return cardCount.containsValue(3) && cardCount.containsValue(2);
    }

    public static boolean isFlush(Hand hand) {
        return HandAnalyzer.isSameSuit(hand.getPlayersCards());
    }

    public static boolean isStraight(Hand hand) {
        return HandAnalyzer.isConsecutiveValue(HandAnalyzer.sortByValue(hand.getPlayersCards()));
    }

    public static boolean isThreeOfKind(Hand hand) {
        return HandAnalyzer.isXOfKind(hand, 3);
    }

    public static boolean isTwoPairs(Hand hand) {
        List<Card> cards = hand.getPlayersCards();
        Map<Value, Integer> cardCount = new HashMap<>();
        cards.forEach(card -> {
            if (cardCount.get(card.getValue()) == null) {
                cardCount.put(card.getValue(), 1);
            } else {
                cardCount.replace(card.getValue(), cardCount.get(card.getValue()) + 1);
            }
        });
        int pairs = 0;
        for (Map.Entry<Value, Integer> entry : cardCount.entrySet()) {
            int value = entry.getValue();
            if (value >= 2) {
                pairs++;
                if (hand.getWinningValue() == null ||
                        hand.getWinningValue().getValueWeight() < entry.getKey().getValueWeight()) {
                    hand.setWinningValue(entry.getKey());
                }
            }
            if (pairs == 2) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOnePair(Hand hand) {
        return HandAnalyzer.isXOfKind(hand, 2);
    }

    protected static List<Card> sortByValue(List<Card> handCards) {
        return handCards.stream()
                .sorted(Comparator.comparing(card -> card.getValue().getValueWeight()))
                .collect(Collectors.toList());
    }

    private static boolean isSameSuit(List<Card> handCards) {
        Suit firstSuit = handCards.get(0).getSuite();
        return handCards.stream()
                .allMatch(card -> firstSuit.equals(card.getSuite()));
    }

    private static boolean isConsecutiveValue(List<Card> handCards) {
        for (int i = handCards.size()-1; i > 0; i--) {
            if (handCards.get(i-1).getValue().getValueWeight() !=
                    handCards.get(i).getValue().getValueWeight()-1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isXOfKind(Hand hand, int numberOfMustBeCards) {
        List<Card> cards = hand.getPlayersCards();
        Map<Value,Integer> cardCount = new HashMap<>();
        cards.forEach(card -> {
            if (cardCount.get(card.getValue()) == null) {
                cardCount.put(card.getValue(), 1);
            } else {
                cardCount.replace(card.getValue(), cardCount.get(card.getValue()) + 1);
            }
        });
        return cardCount.entrySet().stream()
                .anyMatch(entry -> {
                    if (entry.getValue() == numberOfMustBeCards) {
                        hand.setWinningValue(entry.getKey());
                        return true;
                    }
                    return false;
                });
    }
}
