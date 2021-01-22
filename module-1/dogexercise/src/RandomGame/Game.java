package RandomGame;

public class Game {
    private Player p1;
    private Player p2;

    public Game(Player p1, Player p2){
        this.p1 = p1;
        this.p2 = p2;
    }


    public void start(){
        int winnerNumber = NumberGenerator.generateNumber();

        System.out.println(NumberGenerator.generateNumber());

        p1.pickNumber();
    }
}
