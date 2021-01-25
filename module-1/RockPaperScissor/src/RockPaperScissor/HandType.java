package RockPaperScissor;

public enum HandType {
    ROCK(HandType.SCISSOR, HandType.PAPER),
    PAPER(HandType.ROCK, HandType.SCISSOR),
    SCISSOR(HandType.PAPER, HandType.ROCK);

    private HandType weakness;
    private HandType strength;

    HandType(HandType weakness, HandType strength) {

        this.weakness = weakness;
        this.strength = strength;
    }

    public HandType getWeakness() {

        return weakness;
    }

    public HandType getStrength() {

        return strength;
    }
}




