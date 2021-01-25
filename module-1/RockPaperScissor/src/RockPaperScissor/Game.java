package RockPaperScissor;

public class Game {
    private Player p1;
    private Player p2;
    private int nRounds;

    public Game(Player p1, Player p2, int nRounds) {
        this.p1 = p1;
        this.p2 = p2;
        this.nRounds = nRounds;
    }

    public void start() {

        for (int i = 0; i < nRounds; i++) {
            HandType p1Guess = p1.pickHand();
            HandType p2Guess = p2.pickHand();

            System.out.println(p1.getName() + " chose " + p1Guess + " and " + p2.getName() + " chose "
            + p2Guess);

            if (p1Guess == p2Guess) {
                System.out.println("It's a tie!");

            }

            /*if (p1Guess == HandType.ROCK && p2Guess == HandType.SCISSOR ||
                    p1Guess == HandType.PAPER && p2Guess == HandType.ROCK ||
                    p1Guess == HandType.SCISSOR && p2Guess == HandType.PAPER) {
                p1.win();
                continue;*/

            if (p1Guess.getStrength() == p2Guess.getStrength() ||
                    p1Guess == HandType.PAPER && p2Guess == HandType.ROCK ||
                    p1Guess == HandType.SCISSOR && p2Guess == HandType.PAPER) {
                p1.win();
                continue;

            }

            p2.win();
        }

        checkWinner();

    }

    private void checkWinner(){
        if(p1.getScore() == p2.getScore()){
            System.out.println("It's a tie");
            return;
        }

        Player winner = (p1.getScore()> p2.getScore()) ? p1 : p2;
        System.out.println(winner.getName() + " won this game with " + winner.getScore() + " wins!");
    }

}
        /*HandType p1Guess = p1.pickHand();
        HandType p2Guess = p2.pickHand();

        if (p1Guess == p2Guess) {
            System.out.println("It's a tie!");
        }
        else if (p1Guess == HandType.ROCK && p2Guess == HandType.SCISSOR ||
        p1Guess == HandType.PAPER && p2Guess == HandType.ROCK ||
        p1Guess == HandType.SCISSOR && p2Guess == HandType.PAPER){
            p1.win();
        } else {
            p2.win();
        }
        System.out.println(p1.getName() + " chose " + p1Guess + " and ");
    }*/

