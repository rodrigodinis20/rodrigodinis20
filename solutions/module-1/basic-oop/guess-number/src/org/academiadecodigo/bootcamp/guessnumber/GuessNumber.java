package org.academiadecodigo.bootcamp.guessnumber;

public class GuessNumber {

    private int minGuess;
    private int maxGuess;
    private Player[] players;

    public GuessNumber(int minGuess, int maxGuess, Player[] players) {

        this.minGuess = minGuess;
        this.maxGuess = maxGuess;
        this.players = players;

    }

    //TODO: Improve exercise:
    // 1. Make sure players do not choose the same number twice
    // 2. Have a max number of rounds, if no player wins, the system does
    public void start() {

        int systemGuess = chooseNumber();
        System.out.println("## The system chooses the number " + systemGuess);

        boolean endGame = false;

        while (!endGame) {

            for (Player player : players) {

                int playerGuess = player.chooseNumber(minGuess, maxGuess);
                System.out.println(player.getName() + " guessed number " + playerGuess);

                if (playerGuess == systemGuess) {

                    System.out.println("## " + player.getName() + " wins! ##");
                    endGame = true;
                    break;

                }
            }
        }
    }

    private int chooseNumber() {
        return  Randomizer.getRandom(minGuess, maxGuess);
    }

}
