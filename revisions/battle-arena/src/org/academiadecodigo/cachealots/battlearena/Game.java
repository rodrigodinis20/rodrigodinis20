package org.academiadecodigo.cachealots.battlearena;

public class Game {

    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start(){

        //boolean over = false;
        int rounds = 0;

        while(rounds < 15){

            player1.attack(player2);
            player2.attack(player1);

            rounds++;
        }
    }
}
