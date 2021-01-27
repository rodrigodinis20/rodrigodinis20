package org.academiadecodigo.bootcamp.guessanumber;

public class Casino {
    public static void main(String[] args) {

        Player[] players = {
                new Player("U"),
                new Player("DTB"),
                new Player("Salomé"),
                new Player("José")
        };

        Game game = new Game(10, 20, players);
        game.start();
    }
}
