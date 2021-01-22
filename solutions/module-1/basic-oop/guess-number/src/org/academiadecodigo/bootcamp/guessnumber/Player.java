package org.academiadecodigo.bootcamp.guessnumber;

public class Player {

    private String name;

    public Player(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int chooseNumber(int minGuess, int maxGuess) {
        return Randomizer.getRandom(minGuess, maxGuess);
    }

}
