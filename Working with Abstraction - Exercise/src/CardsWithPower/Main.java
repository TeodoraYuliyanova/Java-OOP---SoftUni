package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CardRank cardsPower = CardRank.valueOf(scanner.nextLine());
        CardsSuits cardsSuits = CardsSuits.valueOf(scanner.nextLine());

        Cards card = new Cards(cardsPower,cardsSuits);

        System.out.printf("Card name: %s of %s; Card power: %d" , card.getCardsPowers() , card.getCardsSuits() , card.getPower());



    }
}
