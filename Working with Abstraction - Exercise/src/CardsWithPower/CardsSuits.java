package CardsWithPower;

public enum CardsSuits {
    CLUBS(0),
    DIAMONDS (13),
    HEARTS (26),
    SPADES (39);

    private int suitPower;

    CardsSuits(int suitPower) {
        this.suitPower = suitPower;
    }

    public int getSuitPower() {
        return suitPower;
    }
}
