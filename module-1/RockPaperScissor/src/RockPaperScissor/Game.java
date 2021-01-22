package RockPaperScissor;

public class Game {
    private Player p1;
    private Player p2;

    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void start(){
        HandType p1Guess = p1.pickHand();
        HandType p2Guess = p2.pickHand();

        if (p1.pickHand() == p2.pickHand()) {
            System.out.println("It's a tie!");
        }
        else if (p1.pickHand() == HandType.ROCK && p2.pickHand() == HandType.PAPER){
            System.out.println();
        }

    }
}
