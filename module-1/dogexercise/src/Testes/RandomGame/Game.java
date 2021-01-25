package Testes.RandomGame;

public class Game {

    private int min;
    private int max;
    private Player[] players;

    public Game(int min, int max, Player[] players) {
        //Construtores para podermos passar como propriedades
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

            for (Player player : players) {

                //player picks a number
                guess = player.pickANumber(min, max);
                System.out.println(player.getName() + " chose: " + guess);

                //compare with chosen number
                if (targetNum == guess) {
                    System.out.println("You won");
                }
            }
        }
    }
}



