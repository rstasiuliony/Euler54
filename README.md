The project can be run in IDE (I used IntelliJ) with JDK17.

This is the solution for the Euler54 problem. The program reads card strings from the file poker.txt and counts how many times player 1 has won.

In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:

High Card: Highest value card.
One Pair: Two cards of the same value.
Two Pairs: Two different pairs.
Three of a Kind: Three cards of the same value.
Straight: All cards are consecutive values.
Flush: All cards of the same suit.
Full House: Three of a kind and a pair.
Four of a Kind: Four cards of the same value.
Straight Flush: All cards are consecutive values of same suit.
Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
The cards are valued in the order:
2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.

If two players have the same ranked hands then the rank made up of the highest value wins; for example, 
a pair of eights beats a pair of fives (see example 1 below). But if two ranks tie, for example, 
both players have a pair of queens, then highest cards in each hand are compared (see example 4 below); 
if the highest cards tie then the next highest cards are compared, and so on.
