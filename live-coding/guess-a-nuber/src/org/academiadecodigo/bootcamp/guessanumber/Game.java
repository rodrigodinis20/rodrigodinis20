package org.academiadecodigo.bootcamp.guessanumber;

public class Game {

    private int min;
    private int max;
    private Player[] players;

    public Game(int min, int max, Player[] players) {
        this.min = min;
        this.max = max;
        this.players = players;
    }

    public void start() {
        //choose a number
        int targetNum = NumberGenerator.randomBetween(min, max);
        System.out.println("Game picked: " + targetNum);

        int guess = min - 1;

        while (guess != targetNum) {
            for (Player bananaPlayer : players) {

                //player picks a number
                guess = bananaPlayer.pickANumber(min, max);
                System.out.println(bananaPlayer.getName() +  " picked: " + guess);

                //compare with chosen number
                if (targetNum == guess) {
                    System.out.println("YOU WON!!");
                }
            }
        }


    }


}
