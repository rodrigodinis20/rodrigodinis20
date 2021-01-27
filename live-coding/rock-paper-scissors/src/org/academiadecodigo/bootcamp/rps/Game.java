package org.academiadecodigo.bootcamp.rps;

public class Game {

    private Player player1;
    private Player player2;
    private int nRounds;

    public Game(Player player1, Player player2, int nRounds) {
        this.player1 = player1;
        this.player2 = player2;
        this.nRounds = nRounds;
    }

    public void start() {

        for (int i = 0; i < nRounds; i++) {
            //p1 picks a hand
            HandType hand1 = player1.pickHand();
            //p2 picks a hand
            HandType hand2 = player2.pickHand();
            System.out.println(player1.getName() + "-> " + hand1 + " " + player2.getName() + "-> " + hand2);

            //compare hands
            if (hand1 == hand2) {
                System.out.println("It's a tie");
                continue;
            }

            if (hand1 == HandType.ROCK && hand2 == HandType.SCISSORS ||
                    hand1 == HandType.SCISSORS && hand2 == HandType.PAPER ||
                    hand1 == HandType.PAPER && hand2 == HandType.ROCK) {
                player1.win();
                continue;
            }
            player2.win();
        }


        checkWinner();


    }

    private void checkWinner() {

        if (player1.getScore() == player2.getScore()) {
            System.out.println("GAME OVER: it's a tie!");
            return;
        }

        Player winner = player1.getScore() > player2.getScore() ? player1 : player2;

        System.out.println("GAME OVER: " + winner.getName() + " won with " + winner.getScore() + " victories.");
    }

}
