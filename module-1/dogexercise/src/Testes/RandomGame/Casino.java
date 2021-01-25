package Testes.RandomGame;

public class Casino {
    public static void main (String[] args){

        Player[] players = {
                new Player("Alberto"),
                new Player("Albertina"),
                new Player("Albertino"),
                new Player("Alberta"),
        };


        Game game = new Game(0, 10, players);
        game.start();
    }
}
