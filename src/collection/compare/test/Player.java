package collection.compare.test;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void drawCard(Deck deck) {
        hand.add(deck.drawCard());
    }

    public int rankSum() {
        return hand.stream().mapToInt(Card::getRank).sum();
    }

    public void showHand() {
        hand.sort(null);
        System.out.println(name + "의 카드: " + hand + ", 합계: " + rankSum());
    }

    public String getName() {
        return name;
    }
}
