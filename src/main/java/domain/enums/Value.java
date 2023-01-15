package domain.enums;

public enum Value {

    TWO (2),
    THREE (3),
    FOUR (4),
    FIVE (5),
    SIX (6),
    SEVEN (7),
    EIGHT (8),
    NINE (9),
    TEN (10),
    JACK (11),
    QUEEN (12),
    KING (13),
    ACE (14);

    private int valueWeight;

    Value(int valueWeight) {
        this.valueWeight = valueWeight;
    }

    public static Value getValue(char value) {
        return switch (value) {
            case '2' -> TWO;
            case '3' -> THREE;
            case '4' -> FOUR;
            case '5' -> FIVE;
            case '6' -> SIX;
            case '7' -> SEVEN;
            case '8' -> EIGHT;
            case '9' -> NINE;
            case 'T' -> TEN;
            case 'J' -> JACK;
            case 'Q' -> QUEEN;
            case 'K' -> KING;
            case 'A' -> ACE;
            default -> throw new IllegalArgumentException("Unsupported value");
        };
    }

    public int getValueWeight() {
        return valueWeight;
    }
}
