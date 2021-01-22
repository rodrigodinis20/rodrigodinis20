package org.academiadecodigo.bootcamp.guessnumber;

public class Main {

    public static void main(String[] args) {

        Player[] players = new Player[] {
                new Player("Robinho"),
                new Player("Pinhas"),
                new Player("Felinux"),
                new Player("Sara")
        };

        GuessNumber game = new GuessNumber(3,10, players);
        game.start();

    }

}
