package service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import domain.Card;
import domain.Hand;
import org.junit.Before;
import org.junit.Test;

public class TestHandAnalyzer {

    private final List<Card> royalFlush = new ArrayList<>();
    private final List<Card> straightFlush  = new ArrayList<>();
    private final List<Card> fourOfKind  = new ArrayList<>();
    private final List<Card> fullHouse  = new ArrayList<>();
    private final List<Card> flush  = new ArrayList<>();
    private final List<Card> straight  = new ArrayList<>();
    private final List<Card> twoPairs  = new ArrayList<>();
    private final List<Card> onePair  = new ArrayList<>();
    private Hand handRoyalFlush;
    private Hand handStraightFlush;
    private Hand handFourOfKind;
    private Hand handFullHouse;
    private Hand handFlush;
    private Hand handStraight;
    private Hand handTwoPairs;
    private Hand handOnePair;

    @Before
    public void setUp() {
        createCardsAndHands();
        handRoyalFlush = new Hand(royalFlush);
        handStraightFlush = new Hand(straightFlush);
        handFourOfKind = new Hand(fourOfKind);
        handFullHouse = new Hand(fullHouse);
        handFlush = new Hand(flush);
        handStraight = new Hand(straight);
        handTwoPairs = new Hand(twoPairs);
        handOnePair = new Hand(onePair);
    }

    @Test
    public void testIsRoyalFlush() {
        assertTrue(HandAnalyzer.isRoyalFlush(handRoyalFlush));
        assertFalse(HandAnalyzer.isRoyalFlush(handStraightFlush));
        assertFalse(HandAnalyzer.isRoyalFlush(handFourOfKind));
        assertFalse(HandAnalyzer.isRoyalFlush(handFullHouse));
        assertFalse(HandAnalyzer.isRoyalFlush(handFlush));
        assertFalse(HandAnalyzer.isRoyalFlush(handStraight));
        assertFalse(HandAnalyzer.isRoyalFlush(handTwoPairs));
        assertFalse(HandAnalyzer.isRoyalFlush(handOnePair));
    }

    @Test
    public void testIsStraightFlush() {
        assertTrue(HandAnalyzer.isStraightFlush(handRoyalFlush));
        assertTrue(HandAnalyzer.isStraightFlush(handStraightFlush));
        assertFalse(HandAnalyzer.isStraightFlush(handFourOfKind));
        assertFalse(HandAnalyzer.isStraightFlush(handFlush));
        assertFalse(HandAnalyzer.isStraightFlush(handStraight));
        assertFalse(HandAnalyzer.isStraightFlush(handOnePair));
    }

    @Test
    public void testIsFourOfAKind() {
        assertFalse(HandAnalyzer.isFourOfAKind(handStraightFlush));
        assertTrue(HandAnalyzer.isFourOfAKind(handFourOfKind));
        assertFalse(HandAnalyzer.isFourOfAKind(handFullHouse));
        assertFalse(HandAnalyzer.isFourOfAKind(handFlush));
        assertFalse(HandAnalyzer.isFourOfAKind(handTwoPairs));
        assertFalse(HandAnalyzer.isFourOfAKind(handOnePair));
    }

    @Test
    public void testIsFullHouse() {
        assertFalse(HandAnalyzer.isFullHouse(handRoyalFlush));
        assertFalse(HandAnalyzer.isFullHouse(handFourOfKind));
        assertTrue(HandAnalyzer.isFullHouse(handFullHouse));
        assertFalse(HandAnalyzer.isFullHouse(handFlush));
        assertFalse(HandAnalyzer.isFullHouse(handTwoPairs));
        assertFalse(HandAnalyzer.isFullHouse(handOnePair));
    }

    @Test
    public void testIsFlush() {
        assertTrue(HandAnalyzer.isFlush(handRoyalFlush));
        assertTrue(HandAnalyzer.isFlush(handStraightFlush));
        assertFalse(HandAnalyzer.isFlush(handFourOfKind));
        assertTrue(HandAnalyzer.isFlush(handFlush));
        assertFalse(HandAnalyzer.isFlush(handStraight));
        assertFalse(HandAnalyzer.isFlush(handOnePair));
    }

    @Test
    public void testIsStraight() {
        assertTrue(HandAnalyzer.isStraight(handRoyalFlush));
        assertTrue(HandAnalyzer.isStraight(handStraightFlush));
        assertFalse(HandAnalyzer.isStraight(handFourOfKind));
        assertFalse(HandAnalyzer.isStraight(handFullHouse));
        assertTrue(HandAnalyzer.isStraight(handStraight));
        assertFalse(HandAnalyzer.isStraight(handTwoPairs));
    }

    @Test
    public void testIsThreeOfKind() {
        assertFalse(HandAnalyzer.isThreeOfKind(handStraightFlush));
        assertTrue(HandAnalyzer.isThreeOfKind(handFullHouse));
        assertFalse(HandAnalyzer.isThreeOfKind(handStraight));
        assertFalse(HandAnalyzer.isThreeOfKind(handTwoPairs));
        assertFalse(HandAnalyzer.isThreeOfKind(handOnePair));
    }

    @Test
    public void testIsTwoPairs() {
        assertFalse(HandAnalyzer.isTwoPairs(handRoyalFlush));
        assertFalse(HandAnalyzer.isTwoPairs(handStraightFlush));
        assertTrue(HandAnalyzer.isTwoPairs(handFullHouse));
        assertFalse(HandAnalyzer.isTwoPairs(handStraight));
        assertTrue(HandAnalyzer.isTwoPairs(handTwoPairs));
        assertFalse(HandAnalyzer.isTwoPairs(handOnePair));
    }

    @Test
    public void testIsOnePair() {
        assertFalse(HandAnalyzer.isOnePair(handRoyalFlush));
        assertFalse(HandAnalyzer.isOnePair(handStraightFlush));
        assertTrue(HandAnalyzer.isOnePair(handFullHouse));
        assertFalse(HandAnalyzer.isOnePair(handStraight));
        assertTrue(HandAnalyzer.isOnePair(handTwoPairs));
        assertTrue(HandAnalyzer.isOnePair(handOnePair));
    }

    private void createCardsAndHands() {
        Card ace = new Card("AC");
        Card king = new Card("KC");
        Card queen = new Card("QC");
        Card jack = new Card("JC");
        Card tenClub = new Card("TC");
        Card tenHeart = new Card("TH");
        Card nineClub = new Card("9C");
        Card nineDiamond = new Card("9D");
        Card nineHeart = new Card("9H");
        Card nineSpade = new Card("9S");
        Card eight = new Card("8C");
        royalFlush.add(ace);
        royalFlush.add(king);
        royalFlush.add(queen);
        royalFlush.add(jack);
        royalFlush.add(tenClub);
        straightFlush.add(king);
        straightFlush.add(queen);
        straightFlush.add(jack);
        straightFlush.add(tenClub);
        straightFlush.add(nineClub);
        fourOfKind.add(tenClub);
        fourOfKind.add(nineClub);
        fourOfKind.add(nineDiamond);
        fourOfKind.add(nineHeart);
        fourOfKind.add(nineSpade);
        fullHouse.add(tenClub);
        fullHouse.add(nineClub);
        fullHouse.add(nineDiamond);
        fullHouse.add(nineHeart);
        fullHouse.add(tenHeart);
        flush.add(ace);
        flush.add(queen);
        flush.add(jack);
        flush.add(tenClub);
        flush.add(eight);
        straight.add(king);
        straight.add(queen);
        straight.add(jack);
        straight.add(tenClub);
        straight.add(nineDiamond);
        twoPairs.add(tenHeart);
        twoPairs.add(king);
        twoPairs.add(tenClub);
        twoPairs.add(nineClub);
        twoPairs.add(nineDiamond);
        onePair.add(ace);
        onePair.add(king);
        onePair.add(nineHeart);
        onePair.add(nineSpade);
        onePair.add(queen);
    }
}
