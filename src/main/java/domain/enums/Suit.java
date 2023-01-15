package domain.enums;

public enum Suit {

    CLUB,
    DIAMOND,
    HEART,
    SPADE;

    public static Suit getSuit(char suit) {

        return switch (suit) {
            case 'C' -> CLUB;
            case 'D' -> DIAMOND;
            case 'H' -> HEART;
            case 'S' -> SPADE;
            default -> throw new IllegalArgumentException("Unsupported suit");
        };
    }
}
