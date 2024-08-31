package collection.compare.test;

public class CardGameMain {

    public static void main(String[] args) {
        Deck deck = new Deck();

        Player player1 = new Player("플레이어1");
        Player player2 = new Player("플레이어2");

        int playerDeckSize = 5;
        for (int i = 0; i < playerDeckSize; i++) {
            player1.drawCard(deck);
            player2.drawCard(deck);
        }

        player1.showHand();
        player2.showHand();

        Player winner = getWinner(player1, player2);

        if (winner != null) {
            System.out.println(winner.getName() + " 승리");
        } else {
            System.out.println("무승부");
        }

    }

    private static Player getWinner(Player player1, Player player2) {
        int player1Score = player1.rankSum();
        int player2Score = player2.rankSum();

        if (player1Score > player2Score) {
            return  player1;
        } else if (player1Score == player2Score) {
            return null;
        } else {
            return player2;
        }
    }


}
