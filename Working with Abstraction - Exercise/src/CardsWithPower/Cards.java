package CardsWithPower;

public class Cards {

    private CardRank cardsPowers;
    private CardsSuits cardsSuits;

    public Cards(CardRank cardsPowers, CardsSuits cardsSuits) {
        this.cardsPowers = cardsPowers;
        this.cardsSuits = cardsSuits;
    }

    public CardRank getCardsPowers() {
        return cardsPowers;
    }

    public CardsSuits getCardsSuits() {
        return cardsSuits;
    }

    public int getPower(){
        return cardsPowers.getRankPower() + cardsSuits.getSuitPower();

    }
}
