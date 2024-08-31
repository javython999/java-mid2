package collection.compare.test;

public class Card implements Comparable<Card> {

    private Integer rank;
    private Suit suit;

    public Card(Integer rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Integer getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank +"(" + suit.getIcon() + ")";
    }

    @Override
    public int compareTo(Card o) {

        if (this.rank != o.rank) {
            return Integer.compare(this.rank, o.rank);
        } else {
            return this.suit.compareTo(o.suit);
        }
    }
}
