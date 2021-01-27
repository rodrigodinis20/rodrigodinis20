package org.academiadecodigo.bootcamp.rps;

public class Sandbox {
    public static void main(String[] args) {

        Player player1 = new Player("Paulim");
        Player player2 = new Player("Paulão");

        int nRouds = 3;

        Game game = new Game(player1,player2,nRouds);
        game.start();

    }
}
