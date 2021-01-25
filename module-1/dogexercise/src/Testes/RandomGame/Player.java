package Testes.RandomGame;

public class Player {

    private String name;

    //Constructor
    public Player(String name){
        this.name = name;
    }

    public int pickANumber(int min, int max){
        return NumberGenerator.randomBetween(min, max);
    }

    public String getName(){
        return this.name;
    }
}
