package org.academiadecodigo.bootcamp.rps;

public class Player {

    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public HandType pickHand(){

        int randnum = NumberGenerator.randomBetween(0,2);
        return HandType.values()[randnum];

    }

    public int getScore(){
        return this.score;
    }

    public void win(){
        this.score++;
    }

    public String getName(){
        return this.name;
    }


}
